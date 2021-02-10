public class Main {

    public static void main(String[] args) {

        Pessoa pessoaAssinante = new Pessoa(20, true, false);
        Pessoa pessoaIdosa = new Pessoa(66, false, false);
        Pessoa pessoaEstudante = new Pessoa(20, false, true);
        Pessoa pessoa = new Pessoa(20, false, false);

        System.out.println("Desconto de pessoa assinante: " + calcDesconto(pessoaAssinante)*100+"%");
        System.out.println("Desconto de pessoa idosa: " + calcDesconto(pessoaIdosa)*100+"%");
        System.out.println("Desconto de pessoa estudante: " + calcDesconto(pessoaEstudante)*100+"%");
        System.out.println("Desconto de pessoa comum: " + calcDesconto(pessoa)*100+"%");

    }

    // Função privada para o Fator de Integridade/Segurança
    // Função que retorna double, pois o desconto é com casa decimal, fator de Robustez
    // Função Modularizada aumentando a qualidade
    private static double calcDesconto(Pessoa pessoa) {
        double desconto;

        // Fato de Eficiência pois diminui a quantidade de comparações
        // Fator de Legibilidade e Inteligibilidade aprimorados
        // O desconto maior é para idosos ou estudantes, então condição principal é essa. Fator de Correção
        if(pessoa.idade>=65 || pessoa.estudante==true)
            desconto = 0.5;
        else if(pessoa.assinante==true)
            desconto = 0.2;
        else
            desconto = 0;

        return desconto;
    }
}
class Pessoa {
    int idade;
    boolean assinante;
    boolean estudante;

    public Pessoa(int idade, boolean assinante, boolean estudante) {
        this.idade = idade;
        this.assinante = assinante;
        this.estudante = estudante;
    }
}
