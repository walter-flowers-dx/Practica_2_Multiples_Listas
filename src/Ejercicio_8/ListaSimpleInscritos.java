package Ejercicio_8;

public class ListaSimpleInscritos {
	protected NodoInscritos P;  //raiz de la lista
	
	public ListaSimpleInscritos() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoInscritos getP() {
		return P;
	}

	public void setP(NodoInscritos p) {
		P = p;
	}
	
}
