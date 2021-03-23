import org.junit.jupiter.api.*;

public class AlunoTeste {

    public static Turma turma;
    public Aluno aluno;

    @BeforeAll
    public static void gerarTurma() throws Exception {
        turma = new Turma(1, 'N', 2, 2);
    }

    @BeforeEach
    public void gerarAluno() {
        this.aluno = new Aluno("Lucas", 1);
    }

    @Test
    @DisplayName("Criar aluno e verificar dados.")
    public void criarAluno() {
        Assertions.assertEquals(aluno.getNome(), "Lucas");
        Assertions.assertEquals(aluno.getNivel(), 1);
        Assertions.assertEquals(aluno.isMatriculado(), false);
    }

    @Test
    @DisplayName("Criar aluno e verificar dados.")
    public void matricularAluno() throws Exception {
        Assertions.assertEquals(aluno.isMatriculado(), false);
        turma.matricular(aluno);
        Assertions.assertEquals(aluno.isMatriculado(), true);
        Assertions.assertEquals(aluno.getTurma(), turma);

        // Quando matricula o aluno ele ainda nao viu nenhuma aula
        for(int i=0; i<turma.getQtd_aulas(); i++) {
            Assertions.assertFalse(aluno.getAulas_vistas()[i]);
        }

        // Quando matricula o aluno ele ainda nao fez nenhuma atividade
        for(int i=0; i<turma.getQtd_atividades(); i++) {
            Assertions.assertEquals(aluno.getAtividades_feitas()[i], -1.0);
        }

    }

    @Test
    @DisplayName("Fazer uma aula e uma atividade.")
    public void alunoTrabalhar() throws Exception {
        turma.matricular(aluno);
        aluno.verProximaAula();
        aluno.fazerProximaAtividade(50.0);

        Assertions.assertTrue(aluno.getAulas_vistas()[0]);
        Assertions.assertEquals(aluno.getAtividades_feitas()[0], 50.0);
    }

    @Test
    @DisplayName("Erro ao matricular aluno em duas turmas.")
    public void matricularDuasVezes() throws Exception {
        turma.matricular(aluno);
        Assertions.assertThrows(Exception.class, () -> {
            turma.matricular(aluno);
        });
    }

    @Test
    @DisplayName("Aluno aprovado.")
    public void alunoAprovado() throws Exception {
        turma.matricular(aluno);

        aluno.verProximaAula();
        aluno.fazerProximaAtividade(50.0);
        aluno.verProximaAula();
        aluno.fazerProximaAtividade(50.0);

        Assertions.assertTrue(aluno.aprovado());
    }

}
