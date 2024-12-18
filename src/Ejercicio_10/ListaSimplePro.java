package Ejercicio_10;
public class ListaSimplePro {
	protected NodoPro P;  //raiz de la lista
	
	public ListaSimplePro() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoPro getP() {
		return P;
	}

	public void setP(NodoPro p) {
		P = p;
	}
	
}
