package testeContaBancaria;

public class TesteContaBancaria {
    public static void main(String[] args) {
        Conta c1, c2, c3;

        c1 = new Conta(1, 1229.30);
        c2 = new Conta(2, 300.00);
        c3 = new Conta(3, 1789.50);

        System.out.println(c1.consultarSaldo());
        c1.creditar(200.00);
        System.out.println(c1.consultarSaldo());
        c1.debitar(300.00);
        System.out.println(c1.consultarSaldo());
    }
}
