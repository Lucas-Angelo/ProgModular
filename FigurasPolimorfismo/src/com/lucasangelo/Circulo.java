package com.lucasangelo;

public class Circulo extends Figura{

    private double raio;

    public Circulo(double raio) {
        super("Circulo. ");
        if(raio>=0)
            this.raio = raio;
        else
            this.raio = 1;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * this.raio;
    }

}
