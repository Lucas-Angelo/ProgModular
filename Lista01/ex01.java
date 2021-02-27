private static String verificarAprovacao() {

	double notaFinal=0.0;

	String status = new String();

	for(int i=0; i<nota.length; i++)
		notaFinal+=nota[i];

	// Verificar primeiramente o 0.75, com intuito de diminuir a quantidade de comparações 
	if(frequencia<0.75)
		status="Reprovado";
	else
		if(notaFinal>=60)
			status="Aprovado";
		else
			status="Reavalição";

	return status;
}

/*

	- Função ser privada pelo Fator de Integridade
	
	- Nome da funcao alterada para Fator de Legibilidade
	
	- Somatório (variável notaFinal) da notaFinal ser double para o Fator de Robustez 
	caso a nota não seja exata e iniciada com 0.
	
	- Com objetivo de diminuir a quantiade de comparacões, utilizei o frequência como condição
    principal, já que se a frequência for menor que 0.75 não precisa fazer mais comparações,
	já está reprovado. Mudança feita para agregar um mínimo Fator de Eficiência

*/
