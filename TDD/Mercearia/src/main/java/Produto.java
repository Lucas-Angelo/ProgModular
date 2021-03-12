public class Produto {
    private String tipo;
    private double precoDeCusto;
    private double margemDeVenda;

    private double precoDeVenda;
    private double porcImposto;

    private static int totalVendido=0;

    private static int etqComidas;
    private static int etqBebidas;
    private static int etqMaterialEscolar;


    private void init(String tipo, double preco, double margemDeVenda) throws Exception {
        if(tipo.equals("bebidas") || tipo.equals("comidas") || tipo.equals("material escola"))
            this.tipo = tipo;
        else
            throw new Exception("Tipo de produto inválido!");

        if(margemDeVenda>=20 && margemDeVenda<=50)
            this.margemDeVenda = margemDeVenda;
        else
            throw new Exception("Margem de venda inválida!");

        this.precoDeCusto = preco;

        initValores();
    }

    public Produto(String tipo, double preco, double margemDeVenda) throws Exception {
        init(tipo, preco, margemDeVenda);
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

    private void initValores() {
        if(tipo.equals("comidas"))
            this.porcImposto = 0.18;
        else if(tipo.equals("bebidas"))
            this.porcImposto = 0.18;
        else if(tipo.equals("material escolar"))
            this.porcImposto = 0.18;

        double aux = (this.precoDeCusto + (this.precoDeCusto*(margemDeVenda/100)));
        this.precoDeVenda = aux + (aux*porcImposto);
    }
}
