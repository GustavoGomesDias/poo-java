package controle;

import java.io.IOException;
import java.util.Scanner;

public class TestaHeater {
    public static void main(String[] arg) throws IOException {
        Scanner read =  new Scanner(System.in);
        int option, min, max;

        min = read.nextInt();
        max = read.nextInt();
        Heater heater = new Heater(min, max);
        option = read.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.println("Temperatura="+heater.getTemperature());
                    heater.warmer();
                    System.out.println("Temperatura="+heater.getTemperature());
                    break;
                case 2:
                    System.out.println("Temperatura="+heater.getTemperature());
                    heater.cooler();
                    System.out.println("Temperatura="+heater.getTemperature());
                    break;
                case 3:
                    int increment;
                    increment = read.nextInt();
                    heater.setIncrement(increment);
                    break;
            }
            option = read.nextInt();
        }
    }
}
