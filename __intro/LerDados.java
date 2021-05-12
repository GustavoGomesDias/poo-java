import java.util.Scanner;

public class LerDados {
    public static void main(String[] args) {
        // Instanciando o sanner de leitura
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o nome: ");

        // Lê a String que foi digitada ou a próxima linha completa (?).
        String nome = leitor.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = leitor.nextInt();
        
        System.out.println("Digite o peso: ");
        double peso = leitor.nextDouble();

        System.out.println("O nome digitado foi: " + nome + " e a idade foi: " + idade + " e o peso: " + peso);

        leitor.close();
    }
}
