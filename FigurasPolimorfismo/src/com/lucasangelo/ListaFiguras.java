package com.lucasangelo;

public class ListaFiguras {

    private Figura[] minhasFiguras;
    private int capacidade;
    private int quantidade;

    public ListaFiguras(int capacidade) {
        this.quantidade = 0;
        this.capacidade = capacidade;
        this.minhasFiguras = new Figura[this.capacidade];
    }

    public boolean addFigura(Figura nova) {
        if(this.quantidade<this.capacidade) {
            this.minhasFiguras[this.quantidade] = nova;
            this.quantidade++;
            return true;
        }
        return false;
    }

    public Figura maiorArea() {
        double maiorArea = Double.MIN_VALUE;
        Figura maiorFigura = null;

        for(int i=0; i<this.quantidade; i++) {
            if(this.minhasFiguras[i].area() > maiorArea) {
                maiorFigura = this.minhasFiguras[i];
                maiorArea = this.minhasFiguras[i].area();
            }
        }

        return maiorFigura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<this.quantidade; i++) {
            sb.append((i+1)+ " - " + this.minhasFiguras[i].toString() + "\n");
        }
        return sb.toString();
    }

}
