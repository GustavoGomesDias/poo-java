package aplicacaoDat;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


import dominio.*;

public class AplicacaoDat {
    private static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

    public static void main(String[] args) {
        AplicacaoDat.setVendedores(args);
        AplicacaoDat.serealizaDat();
        AplicacaoDat.desserealizaDat();
    }

    public static void serealizaDat() {
        try {
            File arq = new File("vendedores.dat");
            FileOutputStream newArq = new FileOutputStream(arq);
            ObjectOutputStream obj = new ObjectOutputStream(newArq);
            obj.writeObject(AplicacaoDat.vendedores);
            obj.close();
            System.out.println("Objeto gravado com sucesso!");
            AplicacaoDat.vendedores.clear();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void desserealizaDat() {
        try {
            File arq = new File("vendedores.dat");
            if (arq.exists()) {
                FileInputStream inputArq = new FileInputStream(arq);
                ObjectInputStream objArq = new ObjectInputStream(inputArq);
                AplicacaoDat.vendedores = (ArrayList<Vendedor>) objArq.readObject();
                AplicacaoDat.relatorio();
            } else {
                System.out.println("Arquivo não existe!");
            }

        } catch (IOException | ClassNotFoundException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void setVendedores(String[] args) {
        Scanner read = new Scanner(System.in);
        read.useDelimiter("\n");

        String nome;

        nome = read.next();
        while(!nome.equalsIgnoreCase("fim")) {
            Vendedor vendedor = new Vendedor();
            vendedor.setNome(nome);
            int km;
            String descricao;
            int dias;
            float vendas;
            km = read.nextInt();

            while(km != 0) {
                descricao = read.next();
                dias = read.nextInt();
                vendas = read.nextFloat();

                Viagem viagem = new Viagem();

                viagem.setKm(km);
                viagem.setDescricao(descricao);
                viagem.setDias(dias);
                vendedor.loadViagem(viagem);
                viagem.setValorVendas(vendas);
                km = read.nextInt();
            }
            AplicacaoDat.loadVedendor(vendedor);
            nome = read.next();
        }
    }

    public static void loadVedendor(Vendedor vendedor) {
        AplicacaoDat.vendedores.add(vendedor);
    }

    public static void relatorio () {
        if (!AplicacaoDat.vendedores.isEmpty()) {
            for (Vendedor vendedor : AplicacaoDat.vendedores) {
                System.out.println(vendedor.getNome());
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }
}
