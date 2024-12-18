package Ejercicio_2;

public class ListaSimpleHabitaciones {
	protected NodoHabitaciones P;  //raiz de la lista
	
	public ListaSimpleHabitaciones() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public NodoHabitaciones getP() {
		return P;
	}

	public void setP(NodoHabitaciones p) {
		this.P = p;
	}
	
}
