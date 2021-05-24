package testeContaBancaria;

public class Conta {
    // Atributos/campos -> descrição física da "conta"
    int numero;
    float saldo;

    // Método construtor
    public Conta(int num, float valor) {
        numero = num;
        saldo = valor;
    }

    // Métodos/operação/funções
    void creditar(float valor) {
        saldo += valor;
    }

    void debitar(float valor) {

    }

}
