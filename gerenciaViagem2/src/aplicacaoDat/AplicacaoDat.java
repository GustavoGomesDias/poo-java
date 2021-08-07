package aplicacaoDat;

import manipulaArq.ManipuladorArq;

import java.io.File;

public class AplicacaoDat {
    public static void main(String[] args) {
        String input, output;
        if (args.length > 0) {
            input = args[0];
            output = args[1];
        } else {
            input = "input";
            output = "output";
        }
        ManipuladorArq arq = new ManipuladorArq(input, output);
        arq.leitorDeDados();
        arq.escritorDeRelatorios();
    }
}
