package aplicacaoDat;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


import dominio.*;

public class AplicacaoDat {
    private static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

    public static void main(String[] args) {
        AplicacaoDat.setVendedores(args);
        AplicacaoDat.serealizaDat();
    }

    public static void serealizaDat() {
        try {
            File arq = new File("vendedores.dat");
            FileOutputStream newArq = new FileOutputStream(arq);
            ObjectOutputStream obj = new ObjectOutputStream(newArq);
            obj.writeObject(AplicacaoDat.vendedores);
            obj.close();
            System.out.println("Objeto gravado com sucesso!");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void setVendedores(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");

        String nome;

        nome = read.nextLine();
        while(!nome.equalsIgnoreCase("fim")) {
            Vendedor vendedor = new Vendedor();
            vendedor.setNome(nome);
            int km;
            String descricao;
            int dias;
            float vendas;
            km = read.nextInt();

            while(km != 0) {
                descricao = read.nextLine();
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
            nome = read.nextLine();
        }
    }

    public static void loadVedendor(Vendedor vendedor) {
        AplicacaoDat.vendedores.add(vendedor);
    }
}
