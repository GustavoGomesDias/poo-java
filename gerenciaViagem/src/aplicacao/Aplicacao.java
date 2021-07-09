package aplicacao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import dominio.*;

public class Aplicacao {
    private static LinkedList<Vendedor> vendedor = new LinkedList<Vendedor>();

    public static void main(String[] args) throws IOException {
        Aplicacao.setVendedores(args);
        Aplicacao.relatoriosVendedores();
        Aplicacao.relatorio();

    }

    public static void setVendedores(String[] args) {
        Scanner read = new Scanner(System.in);

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
            read.nextLine();

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
                read.nextLine();
            }

            Aplicacao.loadVendedor(vendedor);
            nome = read.nextLine();
        }
    }

    public static void loadVendedor(Vendedor vendedor) {
        Aplicacao.vendedor.add(vendedor);
    }

    public static void relatoriosVendedores() {
        DecimalFormat formatado = new DecimalFormat("#.##");
        formatado.setMaximumFractionDigits(2);
        if (!Aplicacao.vendedor.isEmpty()) {
            for (int i = 0; i < Aplicacao.vendedor.size(); i++) {
                System.out.println(Aplicacao.vendedor.get(i).getNome());
                System.out.println("Km total: " + Aplicacao.vendedor.get(i).calcValorTotalKm());
                System.out.println("Reembolso total: " + formatado.format(Aplicacao.vendedor.get(i).calcValorTotalReembolso()));
                System.out.println("Vendas total: " + formatado.format(Aplicacao.vendedor.get(i).calcValorTotalVendas()));
            }
        }
    }

    public static void relatorio() {
        if(!Aplicacao.vendedor.isEmpty()) {
            for (int i = 0; i < Aplicacao.vendedor.size(); i++) {
                System.out.println(Aplicacao.vendedor.get(i).getNome());
                System.out.println(Aplicacao.vendedor.get(i).getMenorKm());
                System.out.println(Aplicacao.vendedor.get(i).getMaiorReembolso());
                System.out.println(Aplicacao.vendedor.get(i).getMaiorVenda());
                System.out.println(Aplicacao.vendedor.get(i).getMaiorDuracao());
            }
        }
    }
}
