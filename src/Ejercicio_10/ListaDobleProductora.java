package Ejercicio_10;

public class ListaDobleProductora {
     protected NodoProductora P;  //raiz de la lista
	
	public ListaDobleProductora() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

    public NodoProductora getP() {
        return P;
    }

    public void setP(NodoProductora P) {
        this.P = P;
    }
        

}
