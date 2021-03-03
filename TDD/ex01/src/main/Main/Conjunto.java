public class Conjunto {

    private int N;
    private int tamanho;
    private Object[] objetos;

    public Conjunto(int N) {
        this.N=N;
        this.tamanho=0;
        this.objetos = new Object[N];
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean addObjeto(Object objeto) {
        boolean existe = procurarObjeto(objeto);
        boolean cheio = cheio();
        boolean adicionado = false;
        if(!cheio && !existe){
            this.objetos[this.tamanho]=objeto;
            this.tamanho++;
            adicionado = true;
        }
        return adicionado;
    }

    public boolean cheio() {
        boolean cheio;
        if(this.tamanho==N)
            cheio = true;
        else
            cheio=false;
        return cheio;
    }

    public boolean procurarObjeto(Object objetoZero) {
        boolean existe=false;
        for(int i=0; i<this.tamanho; i++) {
            if(this.objetos[i].equals(objetoZero))
                existe=true;
        }
        return existe;
    }
}
