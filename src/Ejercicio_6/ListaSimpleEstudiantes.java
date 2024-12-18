package Ejercicio_6;

public class ListaSimpleEstudiantes {
	protected NodoEstudiantes P;  //raiz de la lista
	
	public ListaSimpleEstudiantes() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoEstudiantes getP() {
		return P;
	}

	public void setP(NodoEstudiantes p) {
		P = p;
	}
	
}
