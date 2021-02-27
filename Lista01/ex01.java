private static String verificarAprovacao() {

	double notaFinal=0.0;

	String status = new String();

	for(int i=0; i<nota.length; i++)
		notaFinal+=nota[i];

	// Verificar primeiramente o 0.75, com intuito de diminuir a quantidade de compara��es 
	if(frequencia<0.75)
		status="Reprovado";
	else
		if(notaFinal>=60)
			status="Aprovado";
		else
			status="Reavali��o";

	return status;
}

/*

	- Fun��o ser privada pelo Fator de Integridade
	
	- Nome da funcao alterada para Fator de Legibilidade
	
	- Somat�rio (vari�vel notaFinal) da notaFinal ser double para o Fator de Robustez 
	caso a nota n�o seja exata e iniciada com 0.
	
	- Com objetivo de diminuir a quantiade de comparac�es, utilizei o frequ�ncia como condi��o
    principal, j� que se a frequ�ncia for menor que 0.75 n�o precisa fazer mais compara��es,
	j� est� reprovado. Mudan�a feita para agregar um m�nimo Fator de Efici�ncia

*/
