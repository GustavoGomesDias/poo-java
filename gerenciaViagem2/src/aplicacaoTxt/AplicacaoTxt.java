package aplicacaoTxt;

import manipulaArq.ManipuladorBin;
import manipulaArq.ManipuladorJSON;
import manipulaArq.ManipuladorTxt;

import java.io.File;
import java.io.IOException;

public class AplicacaoTxt {
    public static void main(String[] args) {
        AplicacaoTxt.run(args);
    }

    public static void run(String[] args) {
        try {
            String input, output, outputPath;
            if (args.length > 0) {
                input = args[0];
                output = args[1];
            } else {
                File file = new File("./input.txt");
                input = file.getCanonicalPath();
                if (!file.exists()) {
                    System.out.println("Arquivo de entrada não existe");
                    return;
                }
                output = new File("./output.txt").getCanonicalPath();
            }

            if (args.length > 0 && !args[1].isEmpty()) {
                outputPath = args[1];
            } else {
                outputPath = ".";
            }
            ManipuladorTxt arq = new ManipuladorTxt(input, output);
            ManipuladorJSON json = new ManipuladorJSON(input, outputPath, "VendedoresVendas1.json");
            ManipuladorBin bin = new ManipuladorBin(input, outputPath);

            arq.leitorDeDados();
            arq.escritorDeRelatorios();
            json.toJSON(arq.getVendedores());
            bin.serealizaBin(arq.getVendedores());
        } catch (IOException err) {
            System.out.println("Error main: " + err.getMessage());
        }

    }
}
