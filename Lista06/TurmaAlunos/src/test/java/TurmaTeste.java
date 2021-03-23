import org.junit.jupiter.api.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class TurmaTeste {

    public static Turma turma;

    @BeforeAll
    public static void gerarTurma() throws Exception {
        turma = new Turma(1, 'N', 2, 2);
    }

    @Test
    @DisplayName("Verificar código da turma criada.")
    public void criarTurma() {
        Locale.setDefault(new Locale("pt", "BR"));
        DateFormat formatter = new SimpleDateFormat("EEEE");
        Date date = new Date();
        String diaDaSemana = formatter.format(date);

        Assertions.assertEquals(turma.getCodigo(), "1." + diaDaSemana + ".N");
    }

    @Test
    @DisplayName("Verificar turno invalido.")
    public void verificarTurno() {
        AtomicReference<Turma> turmaTurnoInvalido = null;

        Assertions.assertThrows(Exception.class, () -> {
            turmaTurnoInvalido.set(new Turma(1, 'W', 2, 2));
        });
    }

    @Test
    @DisplayName("Verificar quantidade de aulas e atividades.")
    public void quantidades() {
        Assertions.assertEquals(turma.getQtd_aulas(), 2);
        Assertions.assertEquals(turma.getQtd_atividades(), 2);
    }

    @Test
    @DisplayName("Testar relatorio.")
    public void relatorio() throws Exception {
        Turma turmaRelatorio = new Turma(1, 'N', 2, 2);

        Aluno aluno1 = new Aluno("Lucas", 1);
        turmaRelatorio.matricular(aluno1);
        aluno1.fazerProximaAtividade(10);
        aluno1.fazerProximaAtividade(10);
        aluno1.verProximaAula();
        aluno1.verProximaAula();

        Aluno aluno2 = new Aluno("Victor", 1);
        turmaRelatorio.matricular(aluno2);
        aluno2.fazerProximaAtividade(50);
        aluno2.fazerProximaAtividade(50);
        aluno2.verProximaAula();
        aluno2.verProximaAula();

        Aluno aluno3 = new Aluno("José", 1);
        turmaRelatorio.matricular(aluno3);
        aluno3.fazerProximaAtividade(35);
        aluno3.fazerProximaAtividade(35);
        aluno3.verProximaAula();

        String resultado = "Nome: José | Nota: 70.0 | Aprovado: true\n" +
                "Nome: Lucas | Nota: 20.0 | Aprovado: false\n" +
                "Nome: Victor | Nota: 100.0 | Aprovado: true\n";

        Assertions.assertEquals(turmaRelatorio.relatorio(), resultado);
        Assertions.assertEquals(turmaRelatorio.melhorDesempenho(), aluno2);
    }

    @Test
    @DisplayName("Verificar quantidade de aulas e atividades.")
    public void verificarMedias() throws Exception {
        Turma turmaMedias = new Turma(1, 'N', 2, 2);

        Aluno aluno1 = new Aluno("Lucas", 1);
        turmaMedias.matricular(aluno1);
        aluno1.fazerProximaAtividade(50);
        aluno1.fazerProximaAtividade(50);
        aluno1.verProximaAula();
        aluno1.verProximaAula();

        Assertions.assertEquals(turmaMedias.mediaNotas(), 100);
        Assertions.assertEquals(turmaMedias.mediaFrequencia(), 100);
    }

}
