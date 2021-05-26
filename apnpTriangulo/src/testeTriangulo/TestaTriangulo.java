package testeTriangulo;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TestaTriangulo {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Digite o lado 1: ");
        double lado1 = read.nextDouble();

        System.out.println("Digite o lado 2: ");
        double lado2 = read.nextDouble();

        System.out.println("Digite o lado 3: ");
        double lado3 = read.nextDouble();

        while(lado1 != 0 && lado2 != 0 && lado3 != 0) {
            Triangulo triangulo;
            triangulo = new Triangulo(lado1, lado2, lado3);
            if (triangulo.verificaTriangulo()) {
                if (triangulo.verificaEscaleno()) {
                    System.out.println("Lados formam um triangulo Escaleno");
                }

                if (triangulo.verificaEquilatero()) {
                    System.out.println("Lados formam um triangulo Equilatero");
                }

                if (triangulo.verificaIsosceles()) {
                    System.out.println("Lados formam um triangulo Isosceles");
                }
                System.out.println("Area do triangulo: " + String.format("%.2f", triangulo.area()));
                System.out.println("Perimetro do triangulo: " + String.format("%.2f", triangulo.perimetro()));
            } else {
                System.out.println("Lados nao formam um triangulo");
            }

            System.out.println("Digite o lado 1: ");
            lado1 = read.nextDouble();

            System.out.println("Digite o lado 2: ");
            lado2 = read.nextDouble();

            System.out.println("Digite o lado 3: ");
            lado3 = read.nextDouble();
        }
    }
}
