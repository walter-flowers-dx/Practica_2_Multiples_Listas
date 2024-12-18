package Ejercicio_2;

import java.util.Scanner;

public class LS_CircularHabitaciones extends ListaSimpleHabitaciones{

	public LS_CircularHabitaciones() {
		super();  //constructor de la clase padre ListaSimplePer
	}

	public boolean esVacia() {
		if(P == null)
			return true;   //lista vacia
		return false;      //lista NO vacia
	}
	
	public int nroNodos() {
		int c = 0;
		if(P != null) {
			NodoHabitaciones R = P;
			while(R.getSig() != P) {
				c++;
				R = R.getSig();
			}
			c++;  //para contar el ultimo nodo
		}
		return c;
	}
	public void adiFinal(String tipoHabitacion, String color, int tamaño, LS_NormalMuebles ls_NormalMuebles) {
		NodoHabitaciones nuevo = new NodoHabitaciones();
		nuevo.setTipoHabitacion(tipoHabitacion);
		nuevo.setColor(color);
		nuevo.setTamaño(tamaño);
		nuevo.setLs_NormalMuebles(ls_NormalMuebles);
		
		if(P == null) {
			P = nuevo;   //p apunta a nuevo
			P.setSig(P);
		}
		else {
			NodoHabitaciones R = P;
			while( R.getSig() != P){
			     R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setSig(P);
		}
	}
	
	public void adiPrincipio(String tipoHabitacion, String color, int tamaño, LS_NormalMuebles ls_NormalMuebles) {
		NodoHabitaciones nuevo = new NodoHabitaciones();
		nuevo.setTipoHabitacion(tipoHabitacion);
		nuevo.setColor(color);
		nuevo.setTamaño(tamaño);
		nuevo.setLs_NormalMuebles(ls_NormalMuebles);
		if(P == null) {
			P = nuevo;
			P.setSig(P);
		}else {
			NodoHabitaciones R = P;
			while(R.getSig() != P) {
				R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setSig(P);
			P = nuevo;
		}
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    NodoHabitaciones R = P;
	    if (R != null) {
	        do {
	            sb.append(R.getTipoHabitacion()).append(" - ").append(R.getColor())
	              .append(" - ").append(R.getTamaño()).append("\n");
	            R = R.getSig();
	        } while (R != P);
	    }
	    return sb.toString();
	}

	
	public void mostrar() {
	    if (P == null) {
	        System.out.println("La lista está vacía.");
	        return;
	    }
	    NodoHabitaciones R = P;
	    do {
	        System.out.println(R.getTipoHabitacion() + " - " + R.getColor() + " - " + R.getTamaño() + " - " + R.getLs_NormalMuebles());
	        R = R.getSig();
	    } while (R != P);
	}

	
	public NodoHabitaciones eliPrincipio() {
		NodoHabitaciones x = null;    
		if(!esVacia()) {
			if(P.getSig() == P) {
				x = P;
				x.setSig(null);
				P = null;
			}else {
				x = P ;     // x apunta a la raiz P
				NodoHabitaciones R = P;
				while(R.getSig() != P) {
					R = R.getSig();
				}
				P = P.getSig();
				R.setSig(P);
				x.setSig(null);
			}
		}
		return x;
	}
	
	public NodoHabitaciones eliFinal() {
		NodoHabitaciones x = new NodoHabitaciones();
		if(P != null) {
			if(P.getSig() == P) {
				x = P; 
				x.setSig(null);
				P = null;
			}else {
				NodoHabitaciones S = new NodoHabitaciones();
				NodoHabitaciones R = P;
				while(R.getSig() != P) {
					S = R;         //S apunta a R
					R = R.getSig(); //R apunta al siguiente de R
				}
				x = R;
				x.setSig(null);
				S.setSig(P);
			}
		}
		return x;
	}
}
