public class Main {

    public static void main(String[] args) {
        double notas[] = new double[4];

        for(int i=0; i<notas.length; i++)
            notas[i] = 10;
	    Turma turma1 = new Turma(notas);
        System.out.println("Média turma 1: " + calcularMedia(turma1.notas));

        for(int i=0; i<notas.length; i++)
            notas[i] = 7;
        Turma turma2 = new Turma(notas);
        System.out.println("Média turma 2: " + calcularMedia(turma2.notas));

        for(int i=0; i<notas.length; i++)
            notas[i] = 5;
        Turma turma3 = new Turma(notas);
        System.out.println("Média turma 3: " + calcularMedia(turma3.notas));

        double semNotas[] = new double[0];
        for(int i=0; i<0; i++)
            semNotas[i] = 5;
        Turma turma4 = new Turma(semNotas);
        System.out.println("Média turma 4: " + calcularMedia(turma4.notas));
    }

    // Função privada por fator de Integridade
    // Função recebe por parâmetro os dados que podem ser enviados de forma modularizada
    // Função retornando a média em double, com isso aumentando a Modularidade podendo tratar o retorno
    private static double calcularMedia(double notas[]){
        double mediaTurma;
        // Para tratar a exessão de divisão por 0, aumentando Fator de Robustez
        if(notas.length!=0) {
            // Por Fator de Robustez, notas e somas são em double para caso exista uma nota não exata
            double somatorio = 0;
            // Apenas um for pois agora é Modularizado
            for (int i = 0; i < notas.length; i++) {
                somatorio += notas[i];
            }
            // Casting double para aumentar o Fator de Robustez
            mediaTurma = somatorio / ((double) notas.length);
        } else {
            mediaTurma=0;
            System.out.print("Não é possível efetuar a média sem notas! - ");
        }

        return mediaTurma;
    }
}

class Turma {
    double notas[];

    public Turma(double notas[]){
        this.notas = notas;
    }
}