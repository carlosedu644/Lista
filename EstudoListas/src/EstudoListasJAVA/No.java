
package EstudoListasJAVA;


public class No {
private No inicio;
private No fim;
private No anterior;
private No proximo;
private int elemento;



public void no(No inicio, No fim){
this.inicio = inicio;
this.fim = fim;
}
public void no(int elemento){
    this.elemento = elemento;
}

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "no{" + "elemento=" + elemento + '}';
    }
    
       
}

