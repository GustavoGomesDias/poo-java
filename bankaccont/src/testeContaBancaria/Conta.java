package testeContaBancaria;

public class Conta {
    // Atributos/campos -> descrição física da "conta"
    private int numero;
    private double saldo;

    // Métodos/operação/funções

    // Método construtor
    public Conta(int num, double valor) {
        this.numero = num;
        this.saldo = valor;
    }

    // Métodos de alteração
    public void creditar(double valor) {
        this.saldo += valor;
    }

    public void debitar(double valor) {
        double multa = 50.00;
        this.saldo -= valor;

        if (this.saldo < 0) {
            this.saldo -= multa;
        }
    }

    // Métodos de consulta
    public double consultarSaldo() {
        return this.saldo;
    }

}
