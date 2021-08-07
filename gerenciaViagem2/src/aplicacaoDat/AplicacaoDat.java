package aplicacaoDat;

import manipulaArq.ManipuladorArq;

public class AplicacaoDat {
    public static void main(String[] args) {
        ManipuladorArq arq = new ManipuladorArq("input", "output");
        arq.leitorDeDados();
        arq.escritorDeRelatorios();
    }
}
