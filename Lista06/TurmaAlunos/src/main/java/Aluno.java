public class Aluno {

    private String nome;

    private int nivel;
    private boolean matriculado;
    private Turma turma;

    private double atividades_feitas[];
    private boolean aulas_vistas[];

    private boolean aprovado;
    private double nota;
    private double media;
    private double frequencia;

    public Aluno(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
        this.matriculado = false;
    }

    public Aluno() {

    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        this.matriculado = true;
        this.atividades_feitas = new double[turma.getQtd_atividades()];
        this.aulas_vistas = new boolean[turma.getQtd_aulas()];

        for(int i = 0; i < this.atividades_feitas.length; i++)
            this.atividades_feitas[i] = -1.0; // Caso ele tenha uma nota 0, atualiza o -1

        for(int i = 0; i < this.aulas_vistas.length; i++)
            this.aulas_vistas[i] = false;
    }

    public void verProximaAula() {
        boolean parar = false;
        for(int i = 0; i < this.aulas_vistas.length && !parar; i++){
            if(!this.aulas_vistas[i]){
                this.aulas_vistas[i]=true;
                parar = true;
            }
        }
    }

    public void fazerProximaAtividade(double nota) throws Exception {

        double notaSomatorio=0.0;
        for(int i = 0; i < this.atividades_feitas.length; i++){
            notaSomatorio+=atividades_feitas[i];
        }
        notaSomatorio+=nota;
        if(notaSomatorio>this.turma.ATIVIDADE_SOMA)
            throw new Exception("Nota total passou do limite!");

        boolean parar = false;
        for(int i = 0; i < this.atividades_feitas.length && !parar; i++){
            if(this.atividades_feitas[i]==-1.0) {
                this.atividades_feitas[i]=nota;
                parar = true;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public Turma getTurma() {
        return turma;
    }

    public double[] getAtividades_feitas() {
        return atividades_feitas;
    }

    public boolean[] getAulas_vistas() {
        return aulas_vistas;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public double getNota() {
        return nota;
    }

    public double getMedia() {
        return media;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public boolean aprovado() {
        boolean res=false;
        double notaSomatorio=0.0;
        double frequencia=0.0;

        for(int i=0; i<this.atividades_feitas.length; i++) {
            notaSomatorio+=atividades_feitas[i];
        }

        int aulasAssistidas=0;
        for(int i=0; i<this.aulas_vistas.length; i++) {
            if(this.aulas_vistas[0])
                aulasAssistidas++;
        }
        frequencia = (aulasAssistidas/this.turma.getQtd_aulas())*100;

        if(notaSomatorio>=this.turma.MIN_PONTOS && frequencia>=this.turma.MIN_FREQUEN)
            res = true;

        this.aprovado = res;
        this.nota = notaSomatorio;
        this.media = notaSomatorio/this.atividades_feitas.length;
        this.frequencia = frequencia;

        return res;
    }

    public Aluno clone() {
        Aluno aluno = this;
        return aluno;
    }

}
