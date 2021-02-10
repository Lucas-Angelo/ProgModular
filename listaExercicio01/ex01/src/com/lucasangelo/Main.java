package com.lucasangelo;

public class Main {

    // As explicações para cada mudança estão na linha anterior de forma comentada

    public static void main(String[] args) {
        double notas[] = new double[3];

        for(int i=0; i<notas.length; i++)
            notas[i] = 25.00;
        Aluno alunoTesteAprovado = new Aluno(notas, 0.75);
        System.out.println(
                verificarAprovacao(
                        alunoTesteAprovado.getNotas(),
                        alunoTesteAprovado.getFrequencia()
                )
        );

        for(int i=0; i<notas.length; i++)
            notas[i] = 25.00;
        Aluno alunoTesteReprovado = new Aluno(notas, 0.74);
        System.out.println(
                verificarAprovacao(
                        alunoTesteReprovado.getNotas(),
                        alunoTesteReprovado.getFrequencia()
                )
        );

        for(int i=0; i<notas.length; i++)
            notas[i] = 15.00;
        Aluno alunoTesteEmReavaliacao = new Aluno(notas, 0.75);
        System.out.println(
                verificarAprovacao(
                        alunoTesteEmReavaliacao.getNotas(),
                        alunoTesteEmReavaliacao.getFrequencia()
                )
        );

    }

    // Função ser privada pelo Fator de Integridade
    // Nome da funcao alterada para Fator de Legibilidade
    /* Uso de parâmetros para Fator de Modularização (Por meio da classe Aluno)
    Integridade (segurança dos dados não saber mais que o necessário). Com isso é possível fazer testes
    para o Fator de Verificabilidade */
    private static String verificarAprovacao(double nota[], double frequencia) {

        // Zerar variável para garantir que não exista lixo da memória e adequar ao Fato de Correção
        // Somatório da notaFinal ser double para o Fator de Robustez caso a nota não seja exata
        double notaFinal=0;

        // Com finalidade de aumentar a Legibilidade, retornar o que ocorreu diretamente com o aluno
        // Talvez isso impactaria minimamente no fator de Eficiência, pois uma String gasta mais que int
        String status = new String();

        // Somar dinamicamente para garantir o Fator de Reusabilidade dessa função caso aja necessidade
        for(int i=0; i<nota.length; i++)
            notaFinal+=nota[i];

        /* Com objetivo de diminuir a quantiade de comparacões, utilizei o frequência como condição principal,
        já que se a frequência for menor que 0.75 não precisa fazer mais comparações, está reprovado. */
        // Mudança feito para agregar um mínimo Fator de Eficiência
        if(frequencia<0.75)
            status="Reprovado";
        else
            if(notaFinal>=60)
                status="Aprovado";
            else
                status="Reavalição";

        return status;
    }
}

class Aluno {
    private double notas[];
    private double frequencia;

    public Aluno(double[] notas, double frequencia) {
        this.notas = notas;
        this.frequencia = frequencia;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }
}