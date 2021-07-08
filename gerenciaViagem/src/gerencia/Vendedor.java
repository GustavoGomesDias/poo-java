package gerencia;

import java.text.DecimalFormat;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void loadViagem(Viagem viagem) {
        this.viagem.add(viagem);
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

    public String getMenorKm() {
        int menorKm = this.viagem.getFirst().getKm();
        String descricao = this.viagem.getFirst().getDescricao();

        for (Viagem viagem : this.viagem) {
            if (viagem.getKm() < menorKm) {
                menorKm = viagem.getKm();
                descricao = viagem.getDescricao();
            }
        }
        return "Maior km: " + descricao + " " + menorKm + " km";
    }

    public String getMaiorReembolso() {
        DecimalFormat formatado = new DecimalFormat("#.######");
        float maiorReembolso = this.viagem.getFirst().calcValorAReembolsar();
        String descricao = this.viagem.getFirst().getDescricao();
        for (Viagem viagem : this.viagem) {
            if (viagem.calcValorAReembolsar() > maiorReembolso) {
                maiorReembolso = viagem.calcValorAReembolsar();
                descricao = viagem.getDescricao();
            }
        }

        return "Maior reembolso: " +  descricao + " R$ " + formatado.format(maiorReembolso);
    }

    public String getMaiorVenda() {
        DecimalFormat formatado = new DecimalFormat("#.######");
        float maiorVendas = this.viagem.getFirst().getValorVendas();
        String descricao = this.viagem.getFirst().getDescricao();
        for (Viagem viagem : this.viagem) {
            if (viagem.getValorVendas() > maiorVendas) {
                maiorVendas = viagem.getValorVendas();
                descricao = viagem.getDescricao();
            }
        }

        return "Maior venda: " +  descricao + " R$ " + formatado.format(maiorVendas);
    }

    public String getMaiorDuracao() {
        int maiorDias = this.viagem.getFirst().getDias();
        String descricao = this.viagem.getFirst().getDescricao();
        for (Viagem viagem : this.viagem) {
            if (viagem.getDias() > maiorDias) {
                maiorDias = viagem.getDias();
                descricao = viagem.getDescricao();
            }
        }

        return "Maior duracao: " +  descricao + " " + maiorDias + " dias";
    }
}
