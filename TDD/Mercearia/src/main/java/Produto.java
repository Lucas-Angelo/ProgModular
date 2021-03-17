public class Produto {
    private String tipo;
    private double precoDeCusto;
    private double margemDeVenda;
    private int estoque;

    private double precoDeVenda;
    private double porcImposto;

    private static int totalVendido=0;

    private void init(String tipo, double preco, double margemDeVenda, int estoque) throws Exception {
        if(tipo.equals("bebidas") || tipo.equals("comidas") || tipo.equals("material escolar"))
            this.tipo = tipo;
        else
            throw new Exception("Tipo de produto inválido!");

        if(margemDeVenda>=20.0 && margemDeVenda<=50.0)
            this.margemDeVenda = margemDeVenda;
        else
            throw new Exception("Margem de venda inválida!");

        this.precoDeCusto = preco;
        this.estoque = estoque;

        initValores();
    }

    private void initValores() {
        if(tipo.equals("comidas")){
            this.porcImposto = 0.18;
        }
        else if(tipo.equals("bebidas")){
            this.porcImposto = 0.45;
        }
        else if(tipo.equals("material escolar")){
            this.porcImposto = 0.21;
        }

        double aux = (this.precoDeCusto + (this.precoDeCusto*(margemDeVenda/100)));
        this.precoDeVenda = aux + (aux*porcImposto);
    }

    public Produto(String tipo, double preco, double margemDeVenda, int estoque) throws Exception {
        init(tipo, preco, margemDeVenda, estoque);
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public double getMargemDeVenda() {
        return margemDeVenda;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public double getPorcImposto() {
        return porcImposto;
    }

    public static int getTotalVendido() { return totalVendido; }

    public int getEstoque() { return estoque; }

    public void vender() throws Exception {
        totalVendido++;

        if(this.estoque==0)
            throw new Exception("Estoque não pode ser negativo.");
        else
            estoque--;
    }
}
