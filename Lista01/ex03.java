private static double calcularMedia(double notas[]){
	double mediaTurma;
	
	if(notas.length!=0) {
		double somatorio = 0;
		for (int i = 0; i < notas.length; i++) {
			somatorio += notas[i];
		}
		
		// Casting double para aumentar o Fator de Robustez
		mediaTurma = somatorio / ((double) notas.length);
	} else {
		mediaTurma=0.0;
		System.out.println("Não é possível efetuar a média sem notas!");
	}

	return mediaTurma;
}

/*

	- Função privada por fator de Integridade

	- Função recebe por parâmetro os dados que podem ser enviados de forma modularizada

	- Função retornando a média em double, com isso aumentando a Modularidade podendo 
	tratar o retorno

	- Para tratar a exessão de divisão por 0, aumentando Fator de Robustez, foi 
	feito o if(notas.length!=0)

	- Por Fator de Robustez, notas e somas são em double para caso exista uma nota não exata

	- Apenas um for para somar notas pois agora é Modularizado, e pode chamar para calcular
	média de quantas turmas for necessário

	- Casting double para aumentar o Fator de Robustez na divisão pela quantidade de notas

*/
