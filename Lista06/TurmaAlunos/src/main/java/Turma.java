import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Turma {

    private String codigo;
    private int nivel;
    private int turno;
    private int qtd_aulas;
    private int qtd_atividades;

    private static final int MAX_ALUNOS;
    private static final char turnos[];

    public static final double MIN_PONTOS;
    public static final double MIN_FREQUEN;
    public static final double ATIVIDADE_SOMA;

    private Aluno alunos[];

    private int matriculas;
    private int vagas;

    static {
        MAX_ALUNOS=20;
        turnos = new char[]{'M', 'V', 'N'}; // Matutino, Vespertino e Noturno
        MIN_PONTOS=60.0;
        MIN_FREQUEN=75.0;
        ATIVIDADE_SOMA=100.0;
    }

    private void init(int nivel, char turno, int qtd_aulas, int qtd_atividades) throws Exception {
        this.alunos = new Aluno[MAX_ALUNOS];

        boolean turnoValido = false;
        for(int i=0; i<turnos.length; i++)
            if (turno == turnos[i])
                turnoValido = true;
        if(!turnoValido)
            throw new Exception("Turno invalido!");

        this.codigo = gerarCodigo(nivel, turno);
        this.turno = turno;
        this.nivel = nivel;

        if(qtd_aulas>0)
            this.qtd_aulas=qtd_aulas;
        else
            throw new Exception("Uma turma preciso de no mínimo 1 aula!");

        if(qtd_atividades>0)
            this.qtd_atividades=qtd_atividades;
        else
            throw new Exception("Uma turma preciso de no mínimo 1 atividade!");

        this.vagas=MAX_ALUNOS;
        this.matriculas=0;
    }

    public Turma (int nivel, char turno, int qtd_aulas, int qtd_atividades) throws Exception {
        init(nivel, turno, qtd_aulas, qtd_atividades);
    }

    private String gerarCodigo(int nivel, char turno) {
        String diaDaSemana = capturarDiaSemana();
        StringBuilder codigo = new StringBuilder();
        codigo.append(nivel).append(".").append(diaDaSemana).append(".").append(turno);
        return codigo.toString();
    }

    private String capturarDiaSemana() {
        Locale.setDefault(new Locale("pt", "BR"));
        DateFormat formatter = new SimpleDateFormat("EEEE");
        Date date = new Date();
        return formatter.format(date);
    }

    public void matricular(Aluno aluno) throws Exception {

        if(aluno.isMatriculado())
            throw new Exception("Aluno já matriculado em uma turma!");

        if(aluno.getNivel() != this.nivel)
            throw new Exception("Nivel do aluno incompativel com a turma!");

        if(this.vagas>0) {
            this.alunos[MAX_ALUNOS-this.vagas] = aluno;
        } else {
            throw new Exception("Turma cheia!");
        }

        this.matriculas++;
        this.vagas--;
        aluno.setTurma(this);
    }

    public String relatorio() {
        StringBuilder stringBuilder = new StringBuilder();

        QuickSort quickSort = new QuickSort();
        Aluno ordenados[] = this.alunos;
        quickSort.sort(ordenados, matriculas);

        for(int i=0; i<matriculas; i++){
            alunos[i].calcularInformacoes();
            stringBuilder.append("Nome: " + ordenados[i].getNome() + " | Nota: " + ordenados[i].getNota() + " | Aprovado: " + ordenados[i].isAprovado() + "\n");
        }

        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public double mediaNotas() {
        double somatorioMedias=0;
        for(int i=0; i< matriculas; i++) {
            alunos[i].calcularInformacoes();
            somatorioMedias += alunos[i].getNota();
        }
        double media = somatorioMedias/matriculas;

        return media;
    }

    public double mediaFrequencia() {
        double somatorioMedias=0;
        for(int i=0; i< matriculas; i++) {
            alunos[i].calcularInformacoes();
            somatorioMedias += alunos[i].getFrequencia();
        }
        double media = somatorioMedias/matriculas;

        return media;
    }

    public Aluno melhorDesempenho() {
        Aluno melhor = null;
        double maiorDesempenho = 0;

        double desempenho;
        for(int i=0; i< matriculas; i++) {

            alunos[i].calcularInformacoes();
            desempenho = ((alunos[i].getNota()*8) + (alunos[i].getFrequencia()*2))/10;

            if(desempenho>maiorDesempenho) {
                maiorDesempenho = desempenho;
                melhor = alunos[i];
            }
        }

        return melhor;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQtd_aulas() {
        return qtd_aulas;
    }

    public int getQtd_atividades() {
        return qtd_atividades;
    }

}
