class QuickSort {

    public Aluno[] sort(Aluno[] vetor, int n) { // Metodo para chmar ordenacao privada
        int left = 0, rigth = n-1;
        return method(vetor, left, rigth);
    }

    private Aluno[] method(Aluno[] vetor, int left, int rigth) { // Metodo que retorna o vetor Alunoes ordenado por estado
        int pivot;
        pivot = orderbyPivot(vetor, left, rigth);
        if (pivot!= left)
            method(vetor, left, pivot-1);
        if (pivot!=rigth)
            method(vetor, pivot+1, rigth);
        return vetor;
    }

    private int orderbyPivot (Aluno[] vetor, int left, int rigth){

        int i, j, k, n1=0;
        boolean isFirstsNameLesser;

        //descobrindo tamanho dos subveores
        int maxsize = rigth - left ;

        //criando subvetores
        Aluno[] maiores = new Aluno[maxsize];
        Aluno[] menores = new Aluno[maxsize];

        Aluno alunoPivot;
        alunoPivot = vetor[left].clone();
        //Montando dois vetores
        for (i=0,j=0,k=left+1; k<=rigth ; k++){

            isFirstsNameLesser = vetor[k].getNome().compareTo(alunoPivot.getNome()) < 0;

            if (isFirstsNameLesser){
                menores[i] = new Aluno();
                menores[i++] = vetor[k].clone();
            }
            else{
                maiores[j] = new Aluno();
                maiores[j++] = vetor[k].clone();
            }

        }
        n1 = i;

        //Juntando subvetores
        for (k=left; k<n1+left ;k++){
            vetor[k] = menores[k-left].clone();
        }

        int pivot = k;
        vetor[k++] = alunoPivot.clone();

        for (; k<=rigth;k++){
            vetor[k] = maiores[k-n1-left-1].clone();
        }


        return pivot;

    }

}