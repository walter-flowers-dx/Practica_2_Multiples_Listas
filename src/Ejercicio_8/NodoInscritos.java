package Ejercicio_8;

public class NodoInscritos {
	private String nombre;
	private int ci;
	private NodoInscritos sig; //definiendo el campo enlace sig
	
	public NodoInscritos() {  //constructor
		sig = null;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCi() {
		return ci;
	}


	public void setCi(int ci) {
		this.ci = ci;
	}


	public NodoInscritos getSig() {
		return sig;
	}

	public void setSig(NodoInscritos sig) {
		this.sig = sig;
	}
	
}
