package Ejercicio_8;

public class NodoMaterias {
	private String sigla;
	private String nombre;
	private LS_NormalParalelos ls_NormalParalelos;
	private NodoMaterias sig; //definiendo el campo enlace sig
	
	public NodoMaterias() {  //constructor
		sig = null;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LS_NormalParalelos getLs_NormalParalelos() {
		return ls_NormalParalelos;
	}

	public void setLs_NormalParalelos(LS_NormalParalelos ls_NormalParalelos) {
		this.ls_NormalParalelos = ls_NormalParalelos;
	}

	public NodoMaterias getSig() {
		return sig;
	}

	public void setSig(NodoMaterias sig) {
		this.sig = sig;
	}
	
}
