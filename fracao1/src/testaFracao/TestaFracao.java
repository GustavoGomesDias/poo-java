package testaFracao;

import java.io.IOException;
import java.util.Scanner;

public class TestaFracao {

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);

        int num1, den1, num2, den2;
        Fracao f1, f2;

        num1 = read.nextInt();
        den1 = read.nextInt();

        num2 = read.nextInt();
        den2 = read.nextInt();

        f1 = new Fracao(num1, den1);
        f2 = new Fracao(num2, den2);

        System.out.println("Soma="+f1.soma(f2).retornaString());
        System.out.println("Subtracao="+f1.subtrai(f2).retornaString());
        System.out.println("Multiplicacao="+f1.multiplica(f2).retornaString());
        System.out.println("Divisao="+f1.divide(f2).retornaString());
    }

}
