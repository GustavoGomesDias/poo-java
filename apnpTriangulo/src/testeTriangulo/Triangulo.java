package testeTriangulo;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public boolean verificaTriangulo() {
        boolean comparacaoLado1 = this.lado1 < this.lado2 + lado3;
        boolean comparacaoLado2 = this.lado2 < this.lado1 + lado3;
        boolean comparacaoLado3 = this.lado3 < this.lado1 + lado2;

        return comparacaoLado1 && comparacaoLado2 && comparacaoLado3;
    }

    public boolean verificaEscaleno() {
        boolean verificaLadoIguais1 = this.lado1 == this.lado2;
        boolean verificaLadoIguais2 = this.lado1 == this.lado3;
        boolean verificaLadoIguais3 = this.lado2 == this.lado3;

        if(!verificaLadoIguais1 && !verificaLadoIguais2 && !verificaLadoIguais3) {
            return true;
        }

        return false;
    }

    public boolean verificaIsosceles() {
        boolean verificaLadoIguais1 = this.lado1 == this.lado2;
        boolean verificaLadoIguais2 = this.lado1 == this.lado3;
        boolean verificaLadoIguais3 = this.lado2 == this.lado3;

        if(verificaLadoIguais1 && !verificaLadoIguais2 && !verificaLadoIguais3) {
            return true;
        }

        if(!verificaLadoIguais1 && verificaLadoIguais2 && !verificaLadoIguais3) {
            return true;
        }

        if(!verificaLadoIguais1 && !verificaLadoIguais2 && verificaLadoIguais3) {
            return true;
        }

        return false;
    }

    public boolean verificaEquilatero() {
        boolean verificaLadoIguais = this.lado1 == this.lado2 && this.lado1 == this.lado3;

        if(verificaLadoIguais) {
            return true;
        }

        return false;
    }

    public double area() {
        double semiperimetro = this.perimetro() / 2;
        return Math.sqrt(semiperimetro * (semiperimetro - this.lado1) * (semiperimetro - this.lado2) * (semiperimetro - this.lado3));
    }

    public double perimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }
}

