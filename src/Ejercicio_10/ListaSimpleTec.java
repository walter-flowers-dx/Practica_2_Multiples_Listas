package Ejercicio_10;
public class ListaSimpleTec {
	protected NodoTec P;  //raiz de la lista
	
	public ListaSimpleTec() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoTec getP() {
		return P;
	}

	public void setP(NodoTec p) {
		P = p;
	}
	
}
