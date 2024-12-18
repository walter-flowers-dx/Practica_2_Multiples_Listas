package Ejercicio_2;

public class NodoInmueble {
	private String idCasa;
	private double tamañoEnMT2;
	private String ubicacion;
	private LS_CircularHabitaciones ls_CircularHabitaciones;
	private NodoInmueble ant;
	private NodoInmueble sig;
	
	NodoInmueble(){
		this.sig = null;
		this.ant = null;
	}
	

	public String getIdCasa() {
		return idCasa;
	}


	public void setIdCasa(String idCasa) {
		this.idCasa = idCasa;
	}


	public double getTamañoEnMT2() {
		return tamañoEnMT2;
	}


	public void setTamañoEnMT2(double tamañoEnMT2) {
		this.tamañoEnMT2 = tamañoEnMT2;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public LS_CircularHabitaciones getLs_CircularHabitaciones() {
		return ls_CircularHabitaciones;
	}


	public void setLs_CircularHabitaciones(LS_CircularHabitaciones ls_CircularHabitaciones) {
		this.ls_CircularHabitaciones = ls_CircularHabitaciones;
	}


	public NodoInmueble getAnt() {
		return ant;
	}

	public void setAnt(NodoInmueble ant) {
		this.ant = ant;
	}

	public NodoInmueble getSig() {
		return sig;
	}

	public void setSig(NodoInmueble sig) {
		this.sig = sig;
	}
	
}
