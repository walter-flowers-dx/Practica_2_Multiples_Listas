package Ejercicio_8;

public class ListaSimpleParalelos {
	protected NodoParalelos P;  //raiz de la lista
	
	public ListaSimpleParalelos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoParalelos getP() {
		return P;
	}

	public void setP(NodoParalelos p) {
		P = p;
	}
	
}
