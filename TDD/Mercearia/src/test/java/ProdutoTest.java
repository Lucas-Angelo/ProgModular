import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    // Inicio Valores
    @Test
    @DisplayName("Criar produto e verificar dados inseridos.")
    void criarProduto() throws Exception {
        Produto produto = new Produto("bebidas", 100, 25);
        String tipo = produto.getTipo();
        Assertions.assertEquals(tipo, "bebidas");
    }

    @Test
    @DisplayName("Verificar se não tiver vendido nenhum o total de vendidos é 0.")
    void verificarZeroVendidos() throws Exception {
        Produto produto = new Produto("bebidas", 100, 25);
        int totalVendidos = produto.getTotalVendido();
        Assertions.assertEquals(totalVendidos, 0);
    }

    @Test
    @DisplayName("Verificar se tiver vendido um o total de vendidos é 1.")
    void verificarUmVendido() throws Exception {
        Produto produto = new Produto("bebidas", 100, 25);
        produto.vender("bebidas");
        int totalVendidos = produto.getTotalVendido();
        Assertions.assertEquals(totalVendidos, 1);
    }

    @Test
    @DisplayName("Criar produto de comidas e verificar o preco de custo.")
    void verificarPrecoDeCusto() throws Exception {
        Produto produto = new Produto("comidas",100, 25);
        double precoDeCusto = produto.getPrecoDeCusto();
        Assertions.assertEquals(precoDeCusto, 100);
    }

    @Test
    @DisplayName("Criar produto de comidas e verificar a margem de venda.")
    void verificarMargemDeVenda() throws Exception {
        Produto produto = new Produto("comidas",100, 25);
        double margemVenda = produto.getMargemDeVenda();
        Assertions.assertEquals(margemVenda, 25);
    }

    @Test
    @DisplayName("Criar produto de comidas e verificar a % de imposto..")
    void verificarImposto() throws Exception {
        Produto produto = new Produto("comidas",100, 25);
        double porcentagem = produto.getPorcImposto();
        Assertions.assertEquals(porcentagem, 0.18);
    }
    // Fim Valores

    // Inicio Calculos
    @Test
    @DisplayName("Calcular e verificar preço de venda de comida.")
    void verificarPrecoDeVendaComida() throws Exception {
        Produto produto = new Produto("comidas",100, 25);
        double precoDeVenda = produto.getPrecoDeVenda();
        // 100 + 25 + 22,5
        Assertions.assertEquals(precoDeVenda, 147.5);
    }

    @Test
    @DisplayName("Calcular e verificar preço de venda de bebida.")
    void verificarPrecoDeVendaBebida() throws Exception {
        Produto produto = new Produto("bebidas",100, 25);
        double precoDeVenda = produto.getPrecoDeVenda();
        // 100 + 25 + 56,25
        Assertions.assertEquals(precoDeVenda, 181.25);
    }

    @Test
    @DisplayName("Calcular e verificar preço de venda de material escolar.")
    void verificarPrecoDeVendaMaterial() throws Exception {
        Produto produto = new Produto("material escolar",100, 25);
        double precoDeVenda = produto.getPrecoDeVenda();
        // 100 + 25 + 26,25
        Assertions.assertEquals(precoDeVenda, 151.25);
    }
    // Fim Calculos

    @Test
    @DisplayName("Verificar o tanto de material escolar no estoque.")
    void verificarEtqMaterial() {
        double escolarEstoque = Produto.getEtqMaterialEscolar();
        Assertions.assertEquals(escolarEstoque, 0);
    }

    @Test
    @DisplayName("Verificar o tanto de comidas no estoque.")
    void verificarEtqComida() {
        double comidasEstoque = Produto.getEtqComidas();
        Assertions.assertEquals(comidasEstoque, 0);
    }

    @Test
    @DisplayName("Verificar o tanto de bebidas no estoque.")
    void verificarEtqBebida() {
        double bebidasEstoque = Produto.getEtqBebidas();
        Assertions.assertEquals(bebidasEstoque, 0);
    }


}
