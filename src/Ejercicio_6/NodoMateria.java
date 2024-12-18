package Ejercicio_6;

public class NodoMateria {
	private Materia q;  //define el dato objeto Materia
	private int parcial1;
	private int parcial2;
	private int exFinal;
	private int notaAux;
	private NodoMateria sig; //definiendo el campo enlace sig
	
	public NodoMateria() {  //constructor
		sig = null;
	}

	public Materia getQ() {
		return q;
	}

	public void setQ(Materia q) {
		this.q = q;
	}

	public int getParcial1() {
		return parcial1;
	}

	public void setParcial1(int parcial1) {
		this.parcial1 = parcial1;
	}

	public int getParcial2() {
		return parcial2;
	}

	public void setParcial2(int parcial2) {
		this.parcial2 = parcial2;
	}

	public int getExFinal() {
		return exFinal;
	}

	public void setExFinal(int exFinal) {
		this.exFinal = exFinal;
	}

	public int getNotaAux() {
		return notaAux;
	}

	public void setNotaAux(int notaAux) {
		this.notaAux = notaAux;
	}

	public NodoMateria getSig() {
		return sig;
	}

	public void setSig(NodoMateria sig) {
		this.sig = sig;
	}
	
}
