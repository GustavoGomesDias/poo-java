package gerencia;

import java.util.LinkedList;

public class Vendedor {
    private String nome;
    private LinkedList<Viagem> viagem;

    public Vendedor() {
        this.nome = "";
    }

    public String getNome() {
        return this.nome;
    }


    public LinkedList<Viagem> getViagem() {
        return this.viagem;
    }
}
