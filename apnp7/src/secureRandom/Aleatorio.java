package secureRandom;
import java.security.SecureRandom;

public class Aleatorio {
    private int[] arr = new int[10000];

    public Aleatorio() {
        SecureRandom random = new SecureRandom();

        for(int i = 0; i < this.arr.length; i++) {
            arr[i] = random.nextInt(6) + 1;
        }
    }

    public int getInt(int pos) {
        return arr[pos];
    }

    public int getLength() {
        return this.arr.length;
    }
}
