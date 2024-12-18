package Ejercicio_2;

public class NodoHabitaciones {
	private String tipoHabitacion;  //define el dato objeto persona
	private String color;
	private int tamaño;
	private LS_NormalMuebles ls_NormalMuebles;
	
	private NodoHabitaciones sig; //definiendo el campo enlace sig
	
	public NodoHabitaciones() {  //constructor
		sig = null;
	}
	
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public LS_NormalMuebles getLs_NormalMuebles() {
		return ls_NormalMuebles;
	}

	public void setLs_NormalMuebles(LS_NormalMuebles ls_NormalMuebles) {
		this.ls_NormalMuebles = ls_NormalMuebles;
	}

	public NodoHabitaciones getSig() {
		return sig;
	}

	public void setSig(NodoHabitaciones sig) {
		this.sig = sig;
	}
	
	
}