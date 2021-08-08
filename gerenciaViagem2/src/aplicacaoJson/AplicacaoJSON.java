package aplicacaoJson;

import manipulaArq.ManipuladorBin;
import manipulaArq.ManipuladorJSON;

import java.io.File;
import java.io.IOException;

public class AplicacaoJSON {
    public static void main(String[] args) {
        AplicacaoJSON.run(args);
    }

    public static void run(String[] args) {
        try {
            String input, outputPath;
            if (args.length > 0) {
                input = args[0];
            } else {
                File file = new File("./input.txt");
                input = file.getCanonicalPath();
                if (!file.exists()) {
                    System.out.println("Arquivo de entrada não existe");
                    return;
                }
            }

            if (args.length > 0 && !args[1].isEmpty()) {
                outputPath = args[1];
            } else {
                outputPath = ".";
            }
            ManipuladorJSON json = new ManipuladorJSON(input, outputPath,"VendedoresVendas2.json");
            ManipuladorBin bin = new ManipuladorBin(input, outputPath);
            bin.desserealizaBin();
            json.toJSON(bin.getVendedores());
        } catch (IOException err) {
            System.out.println("Error Aplicacao JSON: " + err.getMessage());
        }
    }
}
