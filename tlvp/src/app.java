import java.io.IOException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        
        System.out.println("Informe um número: (num < 0 ou num > 20 == Sair do cálculo de fatorial) ");

        long num =  read.nextLong();

        while(num >= 0 && num <= 20) {
            long fat = 1;
            for(long i = 1; i <= num; i++) {
                fat = fat * i;
            }
            System.out.println("Fatorial de num: " + fat);

            System.out.println("Informe um número: (num < 0 ou num > 20 == Sair do cálculo de fatorial) ");
            num =  read.nextLong();
        }
    }
}
