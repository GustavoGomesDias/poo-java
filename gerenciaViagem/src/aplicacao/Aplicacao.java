package aplicacao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import gerencia.*;

public class Aplicacao {
    private static LinkedList<Vendedor> vendedor = new LinkedList<Vendedor>();

    public static void main(String[] args) throws IOException {
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

        Aplicacao.relatoriosVendedores();

    }

    public static void loadVendedor(Vendedor vendedor) {
        Aplicacao.vendedor.add(vendedor);
    }

    public static void relatoriosVendedores() {
        DecimalFormat formatado = new DecimalFormat("#.##");
        if (!Aplicacao.vendedor.isEmpty()) {
            for (int i = 0; i < Aplicacao.vendedor.size(); i++) {
                System.out.println(Aplicacao.vendedor.get(i).getNome());
                System.out.println("Km total: " + Aplicacao.vendedor.get(i).calcValorTotalKm());
                System.out.println("Reembolso total: " + formatado.format(Aplicacao.vendedor.get(i).calcValorTotalReembolso()));
                System.out.println("Vendas total: " + formatado.format(Aplicacao.vendedor.get(i).calcValorTotalVendas()));
            }
        }
    }
}
