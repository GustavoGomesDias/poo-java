package manipulaArq;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import dominio.Vendedor;
import dominio.Viagem;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ManipuladorArq {
    private ArrayList<Vendedor> vendedores;
    public String inputFile;
    public String outputFile;

    public ManipuladorArq(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
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

    public ArrayList<Vendedor> getVendedores() {
        return this.vendedores;
    }

    public void escritorDeRelatorios() {
        try {
            File file = new File(this.outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            DecimalFormat formato = new DecimalFormat("#.##");
            formato.setMaximumFractionDigits(2);
            formato.setMinimumFractionDigits(2);
            for (Vendedor vendedor : this.vendedores) {
                if (vendedor.ViagemListIsEmpty()) {
                    bufferedWriter.write("-----------------------------------------------\n");
                    bufferedWriter.write("Nome: " + vendedor.getNome() + "\n");
                    bufferedWriter.write("Nao tem viagens cadastradas.");
                    bufferedWriter.write("\n-----------------------------------------------\n");
                } else {
                    bufferedWriter.write("Nome: " + vendedor.getNome() + "\n");
                    bufferedWriter.write("Km total: " + vendedor.calcValorTotalKm() + "\n");
                    bufferedWriter.write("Reembolso total: R$ " + formato.format(vendedor.calcValorTotalReembolso()) + "\n");
                    bufferedWriter.write("Vendas Total: R$ " + formato.format(vendedor.calcValorTotalVendas()) + "\n");
                    bufferedWriter.write(vendedor.getMenorKm() + "\n");
                    bufferedWriter.write(vendedor.getMaiorReembolso() + "\n");
                    bufferedWriter.write(vendedor.getMaiorVenda() + "\n");
                    bufferedWriter.write(vendedor.getMaiorDuracao());
                    bufferedWriter.write("\n\n---\n\n");
                }

            }
            bufferedWriter.close();
            System.out.println("Relatorio criado com sucesso. Esta no diretorio: " + file.getAbsolutePath());
        } catch (IOException error) {
            System.out.println("Error output message: " + error.getMessage());
        }
    }
}
