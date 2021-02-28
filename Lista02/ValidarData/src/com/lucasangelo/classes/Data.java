package com.lucasangelo.classes;

public class Data {

    int dia;
    int mes;
    int ano;

    // Questão 5
    public Data(String data) throws Exception {
        init(data);
    }

    public Data() throws Exception {
        String data = lerUltimaData();
        init(data);
    }

    private String lerUltimaData() {
        String linhaLida;

        ArquivoTextoLeitura leitura = new ArquivoTextoLeitura();
        leitura.abrirArquivo("./ultimaData.txt");

        linhaLida = leitura.ler();

        leitura.fecharArquivo();

        return linhaLida;
    }

    private void registrarUltimaData(Data data) {
        String dataStr;
        String dia, mes;
        if (data.dia>=1 && data.dia<=9)
            dia = "0" + data.dia;
        else
            dia = Integer.toString(data.dia);

        if (data.mes>=1 && data.mes<=9)
            mes = "0" + data.mes;
        else
            mes = Integer.toString(data.mes);

        dataStr = dia + "/" + mes + "/" + data.ano;

        ArquivoTextoEscrita escrita = new ArquivoTextoEscrita();

        escrita.abrirArquivo("./ultimaData.txt");
        escrita.escrever(dataStr); // Escreve no arquivo criado o log.
        escrita.fecharArquivo();
    }

    private void init(String data) throws Exception {
        int dataValores[] = dividirData(data);
        int dia = dataValores[0];
        int mes = dataValores[1];
        int ano = dataValores[2];

        boolean dataExiste = validarExistencia(dia, mes, ano);
        boolean anoMinimo = verificarAno(ano);

        // Só são aceitas datas válidas a partir do ano 1900
        if(!dataExiste) {
            throw new Exception("Data inválida!");
        } else if (!anoMinimo) {
            throw new Exception("Data inválida! Somente a partir do ano 1900.");
        } else {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    private int[] dividirData(String data) throws Exception {
        try {
            int valores[] = new int[3];
            String dataComponentes[] = data.split("/", 3);
            for(int i=0; i< dataComponentes.length; i++)
                valores[i] = Integer.parseInt(dataComponentes[i]);
            return valores;
        } catch (Exception err) {
            throw new Exception("Formato de data inválida!\nUse: dd/mm/aaaa.");
        }
    }

    private boolean validarExistencia(int dia, int mes, int ano) {
        boolean diaValido, mesValido, anoValido;
        if(mes<1 || mes>12 || dia<1)
            mesValido = false;
        else
            mesValido = true;

        if(ano<=0)
            anoValido = false;
        else
            anoValido = true;

        int ultimoDiaDoMes = capturarQuantidadeDiasNoMes(mes, ano);

        // Se o dia inserido for maior que o dia do mês também inserido, é inválida
        if(dia>ultimoDiaDoMes || dia<1)
            diaValido = false;
        else
            diaValido = true;

        boolean valida = (mesValido && diaValido && anoValido) ? true : false;
        return valida;
    }

    private int capturarQuantidadeDiasNoMes(int mes, int ano) {
        int qtdDias;

        if (mes==4 || mes==6 || mes==9 || mes==11)
            qtdDias=30;
        else if(mes==2)
            if (anoBissexto(ano))
                qtdDias = 29;
            else
                qtdDias = 28;
        else
            qtdDias = 31;

        return qtdDias;
    }

    private boolean anoBissexto(int ano) {
        if ((ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0))
            return true;
        else
            return false;
    }

    // Questão 1
    private boolean verificarAno(int ano) {
        return (ano>=1900) ? true : false;
    }

    // Questão 2
    public Data adicionarDias(int qtd) {
        Data novaData = this;
        int ultimoDiaDoMes = capturarQuantidadeDiasNoMes(novaData.mes, novaData.ano);

        novaData.dia += qtd;

        if(novaData.dia>ultimoDiaDoMes) {
            novaData.dia = novaData.dia % ultimoDiaDoMes;
            novaData.mes++;
        }

        if(novaData.mes>12){
            novaData.mes = novaData.mes % 12;
            novaData.ano++;
        }

        return novaData;
    }

    // Questão 3
    public int calcularDiferenca(Data data) {
        int dias = 0;
        int qtdAnosBissextos;

        dias += (this.dia) - (data.dia);
        dias += capturarQuantidadeDiasNoMes(this.mes, this.ano) - capturarQuantidadeDiasNoMes(data.mes, data.ano);

        if(this.ano>=data.ano) {
            qtdAnosBissextos = contarQuantidadeBissextosEmPeriodo(data.ano, this.ano);
        } else {
            qtdAnosBissextos = contarQuantidadeBissextosEmPeriodo(this.ano, data.ano);
        }

        dias += this.ano*365 - data.ano*365;
        dias = Math.abs(dias) + qtdAnosBissextos;

        return dias;
    }

    // Questão 4
    public void verificarMaisRecente(Data data) {

        int diasAno1 = 0;
        int diasAno2 = 0;
        int qtdAnosBissextosAno1;
        int qtdAnosBissextosAno2;

        diasAno1 += (this.dia);
        diasAno2 += (data.dia);

        diasAno1 += capturarQuantidadeDiasNoMes(this.mes, this.ano);
        diasAno2 += capturarQuantidadeDiasNoMes(data.mes, data.ano);

        qtdAnosBissextosAno1 = contarQuantidadeBissextosEmPeriodo(data.ano, this.ano);
        qtdAnosBissextosAno2 = contarQuantidadeBissextosEmPeriodo(this.ano, data.ano);

        diasAno1 += this.ano*365;
        diasAno2 += data.ano*365;

        diasAno1 = Math.abs(diasAno1) + qtdAnosBissextosAno1;
        diasAno2 = Math.abs(diasAno2) + qtdAnosBissextosAno2;

        if(diasAno1>diasAno2) {
            System.out.print("A data mais recente é: ");
            this.imprimir();
            registrarUltimaData(this);
        } else {
            System.out.print("A data mais recente é: ");
            data.imprimir();
            registrarUltimaData(data);
        }

    }

    private int contarQuantidadeBissextosEmPeriodo(int anoMenor, int anoMaior) {
        int qtd = 0;
        while (anoMaior > anoMenor) {
            if(anoBissexto(anoMaior))
                qtd++;
            anoMaior--;
        }
        return qtd;
    }

    public void imprimir() {
        String data;
        String dia, mes;
        if (this.dia>=1 && this.dia<=9)
            dia = "0" + this.dia;
        else
            dia = Integer.toString(this.dia);

        if (this.mes>=1 && this.mes<=9)
            mes = "0" + this.mes;
        else
            mes = Integer.toString(this.mes);

        data = dia + "/" + mes + "/" + this.ano;
        System.out.println(data);
    }

}
