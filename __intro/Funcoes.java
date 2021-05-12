public class Funcoes {
    public static int soma(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void mostrar (int x) {
        System.out.println(x);
    }

    public static void main(String arg[]){
        int a = 5;
        int b = 10;

        int c = soma(a, b);
        mostrar(c);
    }
}
