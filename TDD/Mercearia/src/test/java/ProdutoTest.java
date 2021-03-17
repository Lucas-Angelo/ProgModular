import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {

    private Produto produtoBebidas;
    private Produto produtoComidas;
    private Produto produtoMaterais;

    @BeforeEach
    public void initEach() throws Exception {
        produtoBebidas = new Produto("bebidas", 100, 25, 2);
        produtoComidas = new Produto("comidas",100, 25, 3);
        produtoMaterais = new Produto("material escolar",100, 25, 4);
    }

    // Inicio Valores
    @Test
    @DisplayName("Verificar dados inseridos.")
    void criarProduto() {
        assertEquals(produtoBebidas.getTipo(), "bebidas");
        assertEquals(produtoBebidas.getPrecoDeCusto(), 100);
        assertEquals(produtoBebidas.getMargemDeVenda(), 25);
    }

    @Test
    @DisplayName("Verificar se não tiver vendido nenhum o total de vendidos é 0.")
    void verificarZeroVendidos() {
        int totalVendidos = produtoBebidas.getTotalVendido();
        assertEquals(totalVendidos, 0);
    }

    @Test
    @DisplayName("Verificar se tiver vendido um o total de vendidos é 1.")
    void verificarUmVendido() throws Exception {
        produtoBebidas.vender();
        int totalVendidos = produtoBebidas.getTotalVendido();
        assertEquals(totalVendidos, 1);
    }

    @Test
    @DisplayName("Verificar a % de imposto..")
    void verificarImposto() {
        double porcentagem = produtoComidas.getPorcImposto();
        assertEquals(porcentagem, 0.18);
    }
    // Fim Valores

    // Inicio Calculos
    @Test
    @DisplayName("Calcular e verificar preço de venda de comida.")
    void verificarPrecoDeVendaComida() {
        double precoDeVenda = produtoComidas.getPrecoDeVenda();
        // 100 + 25 + 22,5
        assertEquals(precoDeVenda, 147.5);
    }

    @Test
    @DisplayName("Calcular e verificar preço de venda de bebida.")
    void verificarPrecoDeVendaBebida() {
        double precoDeVenda = produtoBebidas.getPrecoDeVenda();
        // 100 + 25 + 56,25
        assertEquals(precoDeVenda, 181.25);
    }

    @Test
    @DisplayName("Calcular e verificar preço de venda de material escolar.")
    void verificarPrecoDeVendaMaterial() {
        double precoDeVenda = produtoMaterais.getPrecoDeVenda();
        // 100 + 25 + 26,25
        assertEquals(precoDeVenda, 151.25);
    }
    // Fim Calculos

    @Test
    @DisplayName("Verificar se o estoque de materiais escoladores está correto.")
    void etqMaterial() {
        int qtd = produtoMaterais.getEstoque();
        assertEquals(qtd, 4); // Estoque sempre igual a quatro do BeforeEach
    }

}
