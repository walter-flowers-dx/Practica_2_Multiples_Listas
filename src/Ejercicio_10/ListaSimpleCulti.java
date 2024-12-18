package Ejercicio_10;
public class ListaSimpleCulti {
	protected NodoCulti P;  //raiz de la lista
	
	public ListaSimpleCulti() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoCulti getP() {
		return P;
	}

	public void setP(NodoCulti p) {
		P = p;
	}
	
}
