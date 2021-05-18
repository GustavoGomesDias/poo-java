public class Exer4 {

    public static void main(String[] args) {
        exercicio4();
    }

    public static void exercicio4() {
        int fat = 1;
        for(int n = 1; n <= 10; n++){
            fat = fat * n;
            System.out.println("Fatorial de " + n + ": " + fat);
        }
    }
}
