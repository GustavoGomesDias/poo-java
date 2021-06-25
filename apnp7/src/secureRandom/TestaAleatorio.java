package secureRandom;

public class TestaAleatorio {
    public static void main(String[] arg) {
        Aleatorio random = new Aleatorio();

        for (int i = 0; i < random.getLength(); i++) {
            System.out.println("Número aleatório: " + random.getInt(i));
        }
    }
}
