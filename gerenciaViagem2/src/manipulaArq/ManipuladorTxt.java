package manipulaArq;

import java.io.*;
import java.text.DecimalFormat;

import dominio.Vendedor;

public class ManipuladorTxt extends ManipuladorArq {
    public String outputFile;

    public ManipuladorTxt(String inputFile, String outputFile) {
        super(inputFile);
        this.outputFile = outputFile;
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
