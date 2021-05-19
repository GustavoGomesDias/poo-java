public class Exer5 {
    /*
    * Variaveis do tipo int tem um tamanho de 4 bytes para armazenamentos, isso faz com que variáveis desse tipo perca informações quando armazena números muito grandes (que custam mais de 4 bytes para serem armazenados).
    *
    * Com variáveis do tipo long, temos um tamanho de armazenamento de 8 bytes, que permite armazenar números muito maiores e é a solução para os problemas encontrados nesse código (apesar disso, o long também não consgue armazenar números imensamente grandes).
    *
    * Long vai até fatorial de 20 nesse código e int vai até fatorial de 16.
     */

    public static void main(String[] args) {
        exercicio5();
    }

    public static void exercicio5() {
        long fat = 1;
        for(long n = 1; n <= 40; n++){
            fat = fat * n;
            System.out.println("Fatorial de " + n + ": " + fat);
        }
    }
}
