package com.lucasangelo;

public class TrianguloRet extends Poligono {

    public TrianguloRet(double altura, double base) {
        super(base, altura);
        this.descricao = "Triângulo retângulo. ";
    }

    @Override
    public double area() {
        return (this.base * this.altura) / 2 ;
    }

    @Override
    public double perimetro() {
        return (this.altura + this.base + this.hipotenusa());
    }

    private double hipotenusa() {
        return (Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.altura, 2)));
    }

}
