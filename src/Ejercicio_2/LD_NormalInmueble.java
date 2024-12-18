package Ejercicio_2;

public class LD_NormalInmueble extends ListaDobleInmueble{
	public LD_NormalInmueble() {
		super();
	}
	boolean esVacia() {
		if(this.P == null)
			return true;
		return false;
	}
	int nroNodos() {
		int c = 0;
		NodoInmueble R = this.P;
		while(R != null) {
			c++;
			R = R.getSig();
		}
		return c;
	}
	void adiPrimero(String idCasa, double tamañoEnMT2, String ubicacion, LS_CircularHabitaciones ls_CircularHabitaciones){
		NodoInmueble nuevo = new NodoInmueble();
		nuevo.setIdCasa(idCasa);
		nuevo.setTamañoEnMT2(tamañoEnMT2);
		nuevo.setUbicacion(ubicacion);
		nuevo.setLs_CircularHabitaciones(ls_CircularHabitaciones);
		if(esVacia())
			P = nuevo;
		else {
			nuevo.setSig(P);
			P.setAnt(nuevo);
			P = nuevo;
		}
	}
	void mostrar() {
		NodoInmueble R = P;
		while(R != null) {
			System.out.println(R.getIdCasa() + " - " + R.getTamañoEnMT2() + " - " + R.getUbicacion() + " - " + R.getLs_CircularHabitaciones());
			R = R.getSig();
		}
	}
	void adiFinal(String idCasa, double tamañoEnMT2, String ubicacion, LS_CircularHabitaciones ls_CircularHabitaciones) {
		NodoInmueble nuevo = new NodoInmueble();
		nuevo.setIdCasa(idCasa);
		nuevo.setTamañoEnMT2(tamañoEnMT2);
		nuevo.setUbicacion(ubicacion);
		nuevo.setLs_CircularHabitaciones(ls_CircularHabitaciones);
		if(esVacia())
			P = nuevo;
		else {
			NodoInmueble R = P;
			while(R.getSig() != null) {
				R = R.getSig();
			}
			R.setSig(nuevo);
			nuevo.setAnt(R);
		}
	}
	
	NodoInmueble eliPrimero() {
		NodoInmueble x = new NodoInmueble();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;
				P = null;
			}else {
				x = P;
				P = P.getSig();
				P.setAnt(null);
				x.setSig(null);
			}
		}
		return x;
	}
	
	NodoInmueble eliFinal() {
		NodoInmueble x = new NodoInmueble();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;
				P = null;
			}else {
				NodoInmueble R = P;
				while(R.getSig() != null) {
					R = R.getSig();
				}
				x = R;
				NodoInmueble aux = R.getAnt();
				aux.setSig(null);
				x.setAnt(null);
			}
		}
		return x;
	}
}
