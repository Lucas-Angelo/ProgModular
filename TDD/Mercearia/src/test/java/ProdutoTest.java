import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    @DisplayName("Criar produto e verificar dados inseridos.")
    void criarProduto() throws Exception {
        Produto produto = new Produto("bebidas", 100, 25);
        String tipo = produto.getTipo();
        double preco = produto.getPrecoDeCusto();
        double margem = produto.getMargemDeVenda();
        Assertions.assertEquals(tipo, "bebidas");
        Assertions.assertEquals(preco, 100);
        Assertions.assertEquals(margem, 25);
    }

    @Test
    @DisplayName("Criar produto de comidas e verificar a % de imposto.")
    void verificarImposto() throws Exception {
        Produto produto = new Produto("comidas",100, 25);
        double porcentagem = produto.getPorcImposto();
        Assertions.assertEquals(porcentagem, 0.18);
    }

    @Test
    @DisplayName("Calcular e verificar preço de venda.")
    void verificarPrecoDeVenda() throws Exception {
        Produto produto = new Produto("comidas",100, 25);
        double precoDeVenda = produto.getPrecoDeVenda();
        Assertions.assertEquals(precoDeVenda, 147.5);
    }

}
