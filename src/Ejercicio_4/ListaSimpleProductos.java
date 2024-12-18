package Ejercicio_4;

public class ListaSimpleProductos {
	protected NodoProductos P;  //raiz de la lista
	
	public ListaSimpleProductos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoProductos getP() {
		return P;
	}

	public void setP(NodoProductos p) {
		this.P = p;
	}
}
