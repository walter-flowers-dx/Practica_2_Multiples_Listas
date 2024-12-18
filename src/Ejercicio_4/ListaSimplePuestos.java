package Ejercicio_4;

public class ListaSimplePuestos {
	protected NodoPuestos P;  //raiz de la lista
	
	public ListaSimplePuestos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoPuestos getP() {
		return P;
	}

	public void setP(NodoPuestos p) {
		P = p;
	}
	
}
