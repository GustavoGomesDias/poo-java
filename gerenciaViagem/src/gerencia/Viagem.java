package gerencia;

public class Viagem {
    private String descricao;
    private int km;
    private int duracao;
    private float valorVendas;

    public Viagem() {
        this.km = 0;
        this.duracao = 0;
        this.valorVendas = 0;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public float getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(float valorVendas) {
        this.valorVendas = valorVendas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
