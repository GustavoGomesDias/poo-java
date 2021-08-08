package aplicacaoDat;

import manipulaArq.ManipuladorArq;

import java.io.File;
import java.io.IOException;

public class AplicacaoDat {
    public static void main(String[] args) {
        try {
            String input, output;
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
            ManipuladorArq arq = new ManipuladorArq(input, output);
            arq.leitorDeDados();
            arq.escritorDeRelatorios();
        } catch (IOException err) {
            System.out.println("Error main: " + err.getMessage());
        }
    }
}
