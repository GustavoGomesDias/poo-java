package dominio;

import java.util.LinkedList;
import java.io.Serializable;

public class Vendedor implements Serializable {
    private String nome;
    private LinkedList<Viagem> viagem;

    public Vendedor() {
        this.viagem = new LinkedList<Viagem>();
        this.nome = "";
    }

    public String getNome() {   
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void loadViagem(Viagem viagem) {
        this.viagem.add(viagem);
    }

    public boolean ViagemListIsEmpty () {
        return this.viagem.isEmpty();
    }

    public float calcValorTotalReembolso() {
        float totalReembolso = 0;
        // forEach => mesmas coisa que usar o for (int i = 0; i < list.size(); i++), só que de forma simplificada
        for (Viagem viagem : this.viagem) {
            totalReembolso += viagem.calcValorAReembolsar();
        }

        return totalReembolso;
    }

    public int calcValorTotalKm() {
        int totalKm = 0;
        for (Viagem viagem : this.viagem) {
            totalKm += viagem.getKm();
        }

        return totalKm;
    }

    public float calcValorTotalVendas() {
        float totalVendas = 0;
        for (Viagem viagem : this.viagem) {
            totalVendas += viagem.getValorVendas();
        }

        return totalVendas;
    }
}
