public class Main {

    // As explica��es para cada mudan�a est�o na linha anterior de forma comentada

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

    // Fun��o ser privada pelo Fator de Integridade
    // Nome da funcao alterada para Fator de Legibilidade
    /* Uso de par�metros para Fator de Modulariza��o (Por meio da classe Aluno)
    Integridade (seguran�a dos dados n�o saber mais que o necess�rio). Com isso � poss�vel fazer testes
    para o Fator de Verificabilidade */
    private static String verificarAprovacao(double nota[], double frequencia) {

        // Zerar vari�vel para garantir que n�o exista lixo da mem�ria e adequar ao Fato de Corre��o
        // Somat�rio da notaFinal ser double para o Fator de Robustez caso a nota n�o seja exata
        double notaFinal=0;

        // Com finalidade de aumentar a Legibilidade, retornar o que ocorreu diretamente com o aluno
        // Talvez isso impactaria minimamente no fator de Efici�ncia, pois uma String gasta mais que int
        String status = new String();

        // Somar dinamicamente para garantir o Fator de Reusabilidade dessa fun��o caso aja necessidade
        for(int i=0; i<nota.length; i++)
            notaFinal+=nota[i];

        /* Com objetivo de diminuir a quantiade de comparac�es, utilizei o frequ�ncia como condi��o principal,
        j� que se a frequ�ncia for menor que 0.75 n�o precisa fazer mais compara��es, est� reprovado. */
        // Mudan�a feito para agregar um m�nimo Fator de Efici�ncia
        if(frequencia<0.75)
            status="Reprovado";
        else
            if(notaFinal>=60)
                status="Aprovado";
            else
                status="Reavali��o";

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