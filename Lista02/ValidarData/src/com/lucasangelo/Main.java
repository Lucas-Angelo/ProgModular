package com.lucasangelo;

import com.lucasangelo.classes.Data;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Questão 1: ");
        System.out.println("Programa aceitando datas a partir de 1900.");
        Data dataQuaseInvalida = new Data("01/01/1900");
        dataQuaseInvalida.imprimir();

        System.out.println();

        System.out.println("Questão 2: ");
        String dataStr = new String("20/02/2015");
        Data dataOriginal = new Data(dataStr);
        System.out.print("Data original: ");
        dataOriginal.imprimir();
        System.out.print("Data original com 9 dias adicionados: ");
        Data dataComNoveDiasAMais = dataOriginal.adicionarDias(9);
        dataComNoveDiasAMais.imprimir();

        System.out.println();

        System.out.println("Questão 3: ");
        System.out.print("Data 1: ");
        Data data1 = new Data("30/10/2001");
        data1.imprimir();
        System.out.print("Data 2: ");
        Data data2 = new Data("30/10/2005");
        data2.imprimir();
        System.out.println("Diferença de dias entre data 1 e data 2: " + data1.calcularDiferenca(data2));

        System.out.println();

        System.out.println("Questão 4: ");
        System.out.print("Dentre a data 1: ");
        data1.imprimir();
        System.out.print("E a data 2: ");
        data2.imprimir();
        data1.verificarMaisRecente(data2);

        System.out.println();

        System.out.println("Questão 5: ");
        System.out.print("A data mais recente utilizada foi: ");
        Data ultimaData = new Data();
        ultimaData.imprimir();
    }

}
