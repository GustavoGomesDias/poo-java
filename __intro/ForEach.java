public class ForEach {
    public static void main(String args[]) {
        int[] array = {1,2,3}; //veremos Arrays em uma próxima aula.
        for(int contador : array) { //a variável iniciadora deve ser do mesmo tipo da que você quer percorrer.

            System.out.println(contador); //mostra o contador até que o array tenha todas as posições percorridas.
        }
    }
}
