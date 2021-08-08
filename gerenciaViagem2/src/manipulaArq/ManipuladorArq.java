package manipulaArq;

import dominio.Vendedor;
import dominio.Viagem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ManipuladorArq {
    protected ArrayList<Vendedor> vendedores;
    public String inputFile;

    public ManipuladorArq(String inputFile) {
        this.inputFile = inputFile;
        this.vendedores = new ArrayList<Vendedor>();
    }

    public void leitorDeDados() {
        try {
            File file = new File(this.inputFile);
            if (!file.exists()) {
                System.out.println("Arquivo de entrada nao existente!");
                return;
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.inputFile));
            String nome = "";
            nome = bufferedReader.readLine();
            while(!nome.equalsIgnoreCase("fim")) {
                Vendedor vendedor = new Vendedor();
                vendedor.setNome(nome);
                int km;
                String descricao;
                int dias;
                float vendas;

                km = parseInt(bufferedReader.readLine());
                while (km != 0) {
                    descricao = bufferedReader.readLine();
                    dias = parseInt(bufferedReader.readLine());
                    vendas = parseFloat(bufferedReader.readLine());

                    Viagem viagem = new Viagem();
                    viagem.setKm(km);
                    viagem.setDescricao(descricao);
                    viagem.setDias(dias);
                    viagem.setValorVendas(vendas);
                    vendedor.loadViagem(viagem);
                    km = parseInt(bufferedReader.readLine());
                }
                this.vendedores.add(vendedor);
                nome = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch(IOException error) {
            System.out.println("Error input message: " + error.getMessage());
        }
    }
}
