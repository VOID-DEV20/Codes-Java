/**
 * Tema: Interfaces e Encapsulamento
 */

// Interface define um "contrato" de comportamento
interface FormaGeometrica {
    double calcularArea();
    double calcularPerimetro();
}

class Retangulo implements FormaGeometrica {
    // Encapsulamento: atributos privados, acesso via métodos
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }
}

class Circulo implements FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

public class Interfaces {
    public static void main(String[] args) {
        FormaGeometrica[] formas = {
            new Retangulo(4, 6),
            new Circulo(3)
        };

        for (FormaGeometrica forma : formas) {
            System.out.printf("Área: %.2f | Perímetro: %.2f%n",
                    forma.calcularArea(), forma.calcularPerimetro());
        }
    }
}
