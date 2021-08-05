package manipulaArq;

import java.io.*;
import java.util.ArrayList;

import dominio.Vendedor;
import dominio.Viagem;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ManipuladorArq {
    private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    public String inputFile;
    public String outputFile;
    public String path;

    public ManipuladorArq(String inputFile, String outputFile) {
        this.path = System.getProperty("user.dir");
        this.inputFile = inputFile + ".txt";
        this.outputFile = outputFile + ".txt";
    }

    public boolean fileExists(String option) throws IOException {
        File file = new File(this.path + "/" + option +"/" + this.inputFile);
        return file.exists();
    }

    public void leitor() {
        try {
            if (!this.fileExists("input")) {
                System.out.println("Arquivo de entrada não existente!");
                return;
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path + "/input/" + this.inputFile));
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
            System.out.println("Error message: " + error.getMessage());
        }
    }

    public ArrayList<Vendedor> getVendedores() {
        return this.vendedores;
    }
}
