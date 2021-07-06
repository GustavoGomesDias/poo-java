package gerencia;

import java.util.LinkedList;

public class Vendedor {
    private String nome;
    private LinkedList<Viagem> viagem;

    public Vendedor() {
        this.viagem = new LinkedList<Viagem>();
        this.nome = "";
    }

    public String getNome() {   
        return this.nome;
    }


    public void loadViagem(Viagem viagem) {
        this.viagem.add(viagem);
    }

    public float calcValorTotalReembolso() {
        float totalReembolso = 0;
        for (int i = 0; i < this.viagem.size(); i++) {
            totalReembolso += this.viagem.get(i).calcValorAReembolsar();
        }

        return totalReembolso;
    }

    public int calcValorTotalKm() {
        int totalKm = 0;
        for (int i = 0; i < this.viagem.size(); i++) {
            totalKm += this.viagem.get(i).getKm();
        }

        return totalKm;
    }

    public float calcValorTotalVendas() {
        float totalVendas = 0;
        for (int i = 0; i < this.viagem.size(); i++) {
            totalVendas += this.viagem.get(i).getValorVendas();
        }

        return totalVendas;
    }
}
