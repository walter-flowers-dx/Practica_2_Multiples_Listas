package Ejercicio_4;

public class ListaSimpleFeriasAgropecuarias {
	protected NodoFeriasAgropecuarias P;  //raiz de la lista
	
	public ListaSimpleFeriasAgropecuarias() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoFeriasAgropecuarias getP() {
		return P;
	}

	public void setP(NodoFeriasAgropecuarias p) {
		P = p;
	}
	
}
