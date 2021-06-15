package testaFracao;

public class Fracao {
    private int numerador;
    private int denominador;

    // constructor
    public Fracao(int num, int den) {
        int mdc = this.mdc(num, den);

        this.numerador = num / mdc;
        this.denominador = den / mdc;
    }

    public Fracao soma(Fracao fracao) {
        int num, den;
        Fracao res;

        den = this.denominador * fracao.denominador;

        num = (den / this.denominador) * this.numerador  + (den / fracao.denominador) * fracao.numerador;

        res = new Fracao(num, den);

        return res;
    }

    public Fracao subtrai(Fracao fracao) {
        int num, den;
        Fracao res;

        den = this.denominador * fracao.denominador;

        num = (this.numerador * fracao.denominador) - (fracao.numerador * this.denominador);

        res = new Fracao(num, den);
        return res;
    }

    public Fracao multiplica(Fracao fracao) {
        int num, den;

        num = this.numerador * fracao.numerador;
        den = this.denominador * fracao.denominador;

        return new Fracao(num, den);
    }

    public Fracao divide(Fracao fracao) {
        int num, den;

        num = this.numerador * fracao.denominador;
        den = this.denominador * fracao.numerador;

        return new Fracao(num, den);
    }

    private static int mdc(int num, int den) {
        if (num < 0 || den < 0) {
            if (num < 0) {
                num *= -1;
            } else {
                den *= -1;
            }
        }

        int resto = num % den;

        while(resto > 0) {
            num = den;
            den = resto;
            resto = num % den;
        }

        return den;
    }

    public String retornaString() {
        return this.numerador + "/" + this.denominador;
    }
}
