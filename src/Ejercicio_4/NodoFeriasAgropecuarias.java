package Ejercicio_4;

public class NodoFeriasAgropecuarias {
	private String nomFeria;
	private String fecha;
	private String lugar;
	private LS_NormalPuestos ls_NormalPuestos;
	private NodoFeriasAgropecuarias sig; //definiendo el campo enlace sig
	
	public NodoFeriasAgropecuarias() {  //constructor
		sig = null;
	}
	

	public String getNomFeria() {
		return nomFeria;
	}


	public void setNomFeria(String nomFeria) {
		this.nomFeria = nomFeria;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public LS_NormalPuestos getLs_NormalPuestos() {
		return ls_NormalPuestos;
	}


	public void setLs_NormalPuestos(LS_NormalPuestos ls_NormalPuestos) {
		this.ls_NormalPuestos = ls_NormalPuestos;
	}


	public NodoFeriasAgropecuarias getSig() {
		return sig;
	}

	public void setSig(NodoFeriasAgropecuarias sig) {
		this.sig = sig;
	}
	
}
