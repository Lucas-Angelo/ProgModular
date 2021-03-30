package com.lucasangelo;

public class Retangulo extends Poligono {

    public Retangulo(double altura, double base) {
        super(base, altura);
        this.descricao = "Retângulo. ";
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }

    @Override
    public double perimetro() {
        return (this.base * 2) + (this.altura * 2);
    }
}
