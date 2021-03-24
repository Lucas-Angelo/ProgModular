public class Aluno {

    private String nome;

    private int nivel;
    private boolean matriculado;

    private double atividades_feitas[];
    private boolean aulas_vistas[];

    private boolean aprovado;
    private double nota;
    private double frequencia;

    private int qtdAulas;

    public Aluno(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
        this.matriculado = false;
    }

    public Aluno() {}

    public Aluno clone() {
        Aluno aluno = this;
        return aluno;
    }

    public void setTurma(Turma turma) {
        this.matriculado = true;
        this.atividades_feitas = new double[turma.getQtd_atividades()];
        this.aulas_vistas = new boolean[turma.getQtd_aulas()];

        for(int i = 0; i < this.atividades_feitas.length; i++)
            this.atividades_feitas[i] = -1.0; // Caso ele tenha uma nota 0, atualiza o -1

        for(int i = 0; i < this.aulas_vistas.length; i++)
            this.aulas_vistas[i] = false;

        this.qtdAulas = turma.getQtd_aulas();
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
            if(atividades_feitas[i]>=0)
                notaSomatorio+=atividades_feitas[i];
        }
        notaSomatorio+=nota;
        if(notaSomatorio>Turma.ATIVIDADE_SOMA)
            throw new Exception("Nota total passou do limite!");

        boolean parar = false;
        for(int i = 0; i < this.atividades_feitas.length && !parar; i++){
            if(this.atividades_feitas[i]==-1.0) {
                this.atividades_feitas[i]=nota;
                parar = true;
            }
        }
    }

    public void calcularInformacoes() {
        double notaTotal = calcularNotaTotal();
        double frequencia = calcularFrequencia();

        this.aprovado = aprovado(notaTotal, frequencia);
        this.nota = notaTotal;
        this.frequencia = frequencia;
    }

    private double calcularNotaTotal() {
        double notaSomatorio=0.0;
        for(int i=0; i<this.atividades_feitas.length; i++) {
            if(atividades_feitas[i]>=0)
                notaSomatorio+=atividades_feitas[i];
        }
        return notaSomatorio;
    }

    private double calcularFrequencia() {
        double frequencia=0.0;
        int aulasAssistidas=0;
        for(int i=0; i<this.aulas_vistas.length; i++) {
            if(this.aulas_vistas[0])
                aulasAssistidas++;
        }
        frequencia = (aulasAssistidas/this.qtdAulas)*100;
        return frequencia;
    }

    private boolean aprovado(double notaTotal, double frequencia) {
        if(notaTotal>=Turma.MIN_PONTOS && frequencia>=Turma.MIN_FREQUEN)
            return true;
        else
            return false;
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

    public double getFrequencia() {
        return frequencia;
    }

}
