package Ejercicio_10;

public class ListaDobleDep {
     protected NodoDep P;  //raiz de la lista
	
	public ListaDobleDep() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

    public NodoDep getP() {
        return P;
    }

    public void setP(NodoDep P) {
        this.P = P;
    }
        

}
