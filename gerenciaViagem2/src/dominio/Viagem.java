package dominio;

import java.io.Serializable;

public class Viagem implements Serializable {
    private String descricao;
    private int km;
    private int dias;
    private float valorVendas;

    public Viagem() {
        this.descricao = "";
        this.km = 0;
        this.valorVendas = 0;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
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

    public float calcValorAReembolsar() {
        if (this.km <= 150) {
            return this.km * 0.40f;
        } else if (this.km >= 600) {
            return this.km * 0.35f;
        } else {
            return this.km * 0.38f;
        }
    }
}
