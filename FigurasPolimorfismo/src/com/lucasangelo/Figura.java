package com.lucasangelo;

public abstract class Figura {
    protected String descricao;

    public Figura(String descricao) {
        this.descricao = descricao;
    }

    public abstract double area();
    public abstract double perimetro();

    @Override
    public String toString() {
        return this.descricao + "Área " + this.area() + " e Perímetro: " + this.perimetro();
    }
}
