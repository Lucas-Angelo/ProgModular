import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Data comum (30/10/2001): " + validarData("30/10/2001"));
        System.out.println("Data inválida (32/10/2001): " + validarData("32/10/2001"));
        System.out.println("Data válida ano bissexto (29/02/1904): " + validarData("29/02/1904"));
        System.out.println("Data inválida ano não bissexto (29/02/1900): " + validarData("29/02/1900"));
        System.out.println("Data não formatada (1990b/01): " + validarData("1990b/01"));

    }

    // Melhorando o Fator da Legibilidade, especificando melhor o objetivo pelo nome da função
    // Função privada por Fator de Integridade/Segurança
    // Recebendo a data no padrão comum dia/mm/aaaa para o Fator de Facilidade de Uso
    // Pode entrar com várias datas e melhorar o Fator de Verificabilidade
    private static boolean validarData(String data) {
        // Tratando exceção caso o usuário digite um data fora do padrão dia/mm/aaaa, garantindo Fator de Robustez
        try {
            String dataDividida[] = data.split("/", 3);

            // Melhorando o Fator de Legibilidade usando as variáveis com nomes de dados de datas
            int dia = Integer.parseInt(dataDividida[0]);
            int mes = Integer.parseInt(dataDividida[1]);
            int ano = Integer.parseInt(dataDividida[2]);

            // Aumentando o Fator de Eficiência descartando várias comparações caso data seja inválida
            if(mes<1 || mes>12 || ano<=0)
                return false;

            // Melhorando a Legibilidade e Inteligibilidade
            int ultimoDia=0;
            int mesesCom31Dias[] = {1, 3, 5, 7, 8, 10, 12};
            boolean tem31Dias=false;

            // Melhorando Fator de Eficiência gastando menos comparações para encontrar se é um mês de 31 dias
            // Melhorando Fatores Legibilidade e Inteligibilidade diminuindo o código e usando variáveis com nomes claros
            for(int i=0; i<mesesCom31Dias.length; i++)
                if(mes==mesesCom31Dias[i])
                    tem31Dias=true;

            if (tem31Dias)
                ultimoDia=31;
            else if(mes==2)
                // Agregando Fator de Integridade para detectar se a data é válida em anos bissextos ou não
                if ((ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0))
                    ultimoDia = 29;
                else
                    ultimoDia = 28;
            else
                // Caso ainda não tenha encontrado o último dia, sobrou apenas os meses com 31 dias
                ultimoDia = 30;

            // Valindo se o dia está dentro do número de dias do mês, melhorando Fator de Integridade
            if(dia<1 || dia> ultimoDia)
                return false;

            return true;
        } catch (Exception e) {
            // Garantindo o fator de Robustez
            System.out.print("Data inválida! Escreva no formato dd/mm/aaaa - ");
            return false;
        }
    }
}
