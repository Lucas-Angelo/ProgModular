import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    @DisplayName("Verificar se o tamanho do conjunto é zero quando ele é criado.")
    void criandoConjunto() {
        Conjunto aux = new Conjunto(10);
        Assertions.assertEquals(aux.getTamanho(), 0);
    }

    @Test
    @DisplayName("Verificar se o tamanho do conjunto é cem após adicionar 10 elementos.")
    void verificandoTamanho() {
        int N = 10;
        Conjunto aux = new Conjunto(N);

        for(int i=0; i<10; i++){
            aux.addObjeto(i);
        }

        int tam = aux.getTamanho();
        Assertions.assertEquals(tam, N);
    }

    @Test
    @DisplayName("Verificar se o objeto adicionado existe.")
    void procurarObjeto() {
        int N = 10;
        Conjunto aux = new Conjunto(N);

        Object objetoZero = "0";

        aux.addObjeto("1");
        aux.addObjeto(1);
        aux.addObjeto(00.1);
        aux.addObjeto("Lucas");
        aux.addObjeto('c');
        aux.addObjeto(objetoZero);
        aux.addObjeto("6");
        aux.addObjeto("7");
        aux.addObjeto("8");
        aux.addObjeto("9");

        boolean existe = aux.procurarObjeto(objetoZero);
        Assertions.assertEquals(existe, true);
    }

    @Test
    @DisplayName("Verificar se o tamanho aumentou quando adicionado um objeto repetido.")
    void verificarRepetido() {
        int N = 10;
        Conjunto aux = new Conjunto(N);

        Object objetoZero = "0";
        Object objetoUm= "1";

        int qtdObjetosAdicionados = 2;
        aux.addObjeto(objetoZero);
        aux.addObjeto(objetoUm);

        int tam = aux.getTamanho();
        Assertions.assertEquals(tam, qtdObjetosAdicionados);
    }

    @Test
    @DisplayName("Verificar se conjunto está cheio.")
    void conjuntoCheio() {
        int N = 2;
        Conjunto aux = new Conjunto(N);

        aux.addObjeto(1);
        aux.addObjeto(2);

        boolean cheio = aux.cheio();
        Assertions.assertEquals(cheio, true);
    }

    @Test
    @DisplayName("Tentar adicionar elemento em conjunto cheio.")
    void adicionarConjuntoCheio() {
        int N = 10;
        Conjunto aux = new Conjunto(N);

        boolean adicionado = aux.addObjeto("obj");
        for(int i=0; i<10; i++){
            adicionado = aux.addObjeto("obj");
        }

        Assertions.assertEquals(adicionado, false);
    }

}
