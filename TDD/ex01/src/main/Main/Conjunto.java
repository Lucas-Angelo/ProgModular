public class Conjunto {

    private int N;
    private int tamanho;
    private Object[] objetos;

    public Conjunto(int N) {
        this.N=N;
        this.tamanho=0;
        this.objetos = new Object[N];
        for(int i=0; i<N; i++)
            this.objetos[i] = new Object();
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean addObjeto(Object objeto) {
        boolean existe = procurarObjeto(objeto);
        boolean adicionado = false;
        if(this.tamanho!=N && !existe){
            this.objetos[this.tamanho]=objeto;
            this.tamanho++;
            adicionado = true;
        }
        return adicionado;
    }

    public boolean procurarObjeto(Object objetoZero) {
        boolean existe=false;
        for(int i=0; i<this.N; i++) {
            if(this.objetos[i].equals(objetoZero))
                existe=true;
        }
        return existe;
    }
}
