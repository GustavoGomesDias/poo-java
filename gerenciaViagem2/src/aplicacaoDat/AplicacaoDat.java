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
        if (!AplicacaoDat.getFileDat().equals("")) {
            AplicacaoDat.desserealizaDat();
        } else {
            AplicacaoDat.setVendedores(args);
            AplicacaoDat.serealizaDat(args);
            AplicacaoDat.desserealizaDat();
        }
    }

    public static void serealizaDat(String[] args) {
        try {
            Scanner read = new Scanner(System.in);
            read.useDelimiter("\n");

            System.out.println("Digite o nome do arquivo:");
            String nomeArq = read.next();

            File arq = new File(nomeArq + ".dat");
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
            File arq = new File(AplicacaoDat.getFileDat());
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

    public static String getFileDat() {
        String path = System.getProperty("user.dir");
        File file = new File(path);
        String arqv = "";
        File[] arqs = file.listFiles();
        for(File f : arqs) {
            if (f.getName().contains(".dat")) {
                arqv = f.getName();
            }
        }
        return arqv;
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

    public static void relatorio() {
        if (!AplicacaoDat.vendedores.isEmpty()) {
            for (Vendedor vendedor : AplicacaoDat.vendedores) {
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("Valor de reembolso: " + vendedor.calcValorTotalReembolso());
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }
}
