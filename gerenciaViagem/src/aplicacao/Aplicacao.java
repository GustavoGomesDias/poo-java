package aplicacao;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import gerencia.*;

public class Aplicacao {
    private static LinkedList<Vendedor> vendedor;

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);

        String nome;

        nome = read.next();
        while(nome != "fim") {
            Vendedor vendedor = new Vendedor();
            vendedor.setNome(nome);
            int km;
            String descricao;
            float vendas;
            km = read.nextInt();

            while(km != 0) {
                Viagem viagem = new Viagem();
                viagem.setKm(km);
                descricao = read.next();
                viagem.setDescricao(descricao);
                vendas = read.nextFloat();
                viagem.setValorVendas(vendas);
                vendedor.loadViagem(viagem);
                km = read.nextInt();
            }

            Aplicacao.loadVendedor(vendedor);
            nome = read.next();
        }

    }

    public static void loadVendedor(Vendedor vendedor) {
        Aplicacao.vendedor.add(vendedor);
    }

    public void relatoriosVendedores() {
        // Função que imprime as informações
    }
}
