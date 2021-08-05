package aplicacaoDat;

import dominio.Vendedor;
import dominio.Viagem;
import manipulaArq.ManipuladorArq;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AplicacaoDat {
    private static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    private static String path = System.getProperty("user.dir");

    public static void main(String[] args) {
        ManipuladorArq arq = new ManipuladorArq("input", "output");
        arq.leitor();
    }

    public static void serealizaDat(String[] args) {
        try {
            Scanner read = new Scanner(System.in);
            read.useDelimiter("\n");

            System.out.println("Digite o nome do arquivo:");
            String nomeArq = read.next();

            new File(AplicacaoDat.path + "/input/").mkdir();

            File arq = new File(AplicacaoDat.path + "/input/" + nomeArq + ".txt");

            FileOutputStream newArq = new FileOutputStream(arq);
            ObjectOutputStream obj = new ObjectOutputStream(newArq);
            obj.writeObject(AplicacaoDat.vendedores);
            obj.close();
            System.out.println("Arquivo gravado com sucesso!");
            AplicacaoDat.vendedores.clear();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void desserealizaDat() {
        try {
            File arq = new File("input/" + AplicacaoDat.getFileTxt("input"));
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

    public static String getFileTxt(String option) {
        File file = new File(AplicacaoDat.path + "/" + option);
        if (!file.exists()) return "";
        String arqv = "";
        File[] arqs = file.listFiles();
        for(File f : arqs) {
            if (f.getName().contains(".txt")) {
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
        try {
            Scanner read = new Scanner(System.in);
            read.useDelimiter("\n");

            FileWriter file;

            if (AplicacaoDat.getFileTxt("output").equals("")) {
                System.out.println("Digite o nome do arquivo:");
                String nomeArq = read.next();
                new File(AplicacaoDat.path + "/output/").mkdir();
                String output = AplicacaoDat.path + "/output";
                file = new FileWriter(output + "/" + nomeArq + ".txt", true);

            } else {
                file = new FileWriter(AplicacaoDat.getFileTxt("output"), true);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(file);

            if (!AplicacaoDat.vendedores.isEmpty()) {
                for (Vendedor vendedor : AplicacaoDat.vendedores) {
                    bufferedWriter.write("Nome: " + vendedor.getNome());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Vendas total: " + vendedor.calcValorTotalVendas());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Valor de reembolso: " + vendedor.calcValorTotalReembolso());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Km total: " + vendedor.calcValorTotalKm());
                    bufferedWriter.newLine();
                }
            } else {
                System.out.println("Lista vazia!");
            }
            bufferedWriter.close();
            file.close();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }
}
