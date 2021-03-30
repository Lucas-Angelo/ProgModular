package com.lucasangelo;

import java.util.Random;

public class Main {

    static Random sorteio = new Random();

    public static void main(String[] args) {
	    ListaFiguras lista = new ListaFiguras(10);

	    for(int i=0; i<15; i++) {
	        int qual = sorteio.nextInt(4)+1;
	        double n1 = sorteio.nextDouble()*5;
            double n2 = sorteio.nextDouble()*8;
            Figura aux = null;
            switch (qual) {
                case 1: aux = new Circulo(n1);
                    break;
                case 2: aux = new TrianguloRet(n1, n2);
                    break;
                case 3: aux = new Retangulo(n1, n2);
                    break;
                case 4: aux = new Quadrado(n2);
                    break;
            }
            lista.addFigura(aux);
        }

        System.out.println(lista);
        System.out.println("Maior de todas: " + lista.maiorArea());
    }
}
