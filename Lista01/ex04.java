private static double calcDesconto(int idade, boolean estudante, boolean assinante) {
	double desconto;

	if(idade>=65 || estudante==true)
		desconto = 0.5;
	else if(assinante==true)
		desconto = 0.2;
	else
		desconto = 0.0;

	return desconto;
}

/*

	- Função privada para o Fator de Integridade/Segurança

	- Função que retorna double, pois o desconto é com casa decimal, fator de Robustez

	- Função Modularizada aumentando a qualidade, por meio do recebimento dos parâmetros

	- Fator de Eficiência pois diminui a quantidade de comparações verificar a idade e estudante
	primeiro, pois são os maiores descontos. Fator de Legibilidade e Inteligibilidade aprimorados.

*/
