private static boolean validarData(String data) {
	boolean valida;
	try {
		String dataDividida[] = data.split("/", 3);
		int dia = Integer.parseInt(dataDividida[0]);
		int mes = Integer.parseInt(dataDividida[1]);
		int ano = Integer.parseInt(dataDividida[2]);

		if(mes<1 || mes>12 || ano<=0 || dia<1)
			valida = false;
		
		int ultimoDia;

		// Encontra a quantidade de dias do mês inserido
		if (mes==4 || mes==6 || mes==9 || mes==11)
			ultimoDia=30;
		else if(mes==2)
			if ((ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0))
				ultimoDia = 29;
			else
				ultimoDia = 28;
		else
			ultimoDia = 31;

		// Se o dia inserido for maior que o dia do mês também inserido, é inválida
		if(dia>ultimoDia)
			valida = false;

		valida = true;
	} catch (Exception e) {
		System.out.println("Data inválida! Escreva no formato dd/mm/aaaa");
		valida = false;
	}
	return valida;
}

/*

	- Melhorando o Fator da Legibilidade, especificando melhor o objetivo pelo nome da função
	
	- Função privada por Fator de Integridade/Segurança
	
	- Recebendo a data no padrão comum dia/mm/aaaa para o Fator de Facilidade de Uso
	
	- Tratando exceção caso o usuário digite um data fora do padrão dia/mm/aaaa,
	garantindo Fator de Robustez, por meio do try catch.
	
	- Melhorando o Fator de Legibilidade usando as variáveis com nomes de dados de datas
	
	- Aumentando o Fator de Eficiência descartando várias comparações caso data seja inválidas
	para dias negativos, meses negativos ou maiores que 12 e anos menor ou igual a 0.
	
	- Verificar os meses com 30 dias pois são menos comparações que dos meses com 31 dias,
	para encontrar o máximo de dias do mês que foi inserido
	
	- Agregando Fator de Integridade para detectar se a data é válida em anos bissextos ou não,
	no momento de verificar o mês de fevereiro
	
	- Por último, se não houver encontrado nos ifs anteriores, o máximo de dias do mês inserido 
	é 31
	
	- Valindo se o dia está dentro do número de dias máximo do mês, melhorando Fator de 
	Integridade

*/
