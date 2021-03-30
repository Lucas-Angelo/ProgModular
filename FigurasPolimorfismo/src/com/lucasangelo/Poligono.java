package com.lucasangelo;

public abstract class Poligono extends Figura {

    protected double altura;
    protected double base;

    public Poligono(double altura, double base) {
        super("");
        if(altura > 0)
            this.altura = altura;
        else
            this.altura = 1;

        if(base > 0)
            this.base = base;
        else
            this.base = 1;
    }

}
