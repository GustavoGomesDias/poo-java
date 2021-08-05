package aplicacaoDat;

import dominio.Vendedor;
import dominio.Viagem;
import manipulaArq.ManipuladorArq;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AplicacaoDat {
    public static void main(String[] args) {
        ManipuladorArq arq = new ManipuladorArq("input", "output");
        arq.leitorDeDados();
        arq.escritorDeRelatorios();
    }
}
