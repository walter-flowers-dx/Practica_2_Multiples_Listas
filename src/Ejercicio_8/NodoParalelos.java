package Ejercicio_8;

public class NodoParalelos {
	private String docente;
	private String paralelo;
	private LS_NormalInscritos ls_NormalInscritos;
	private NodoParalelos sig; //definiendo el campo enlace sig
	
	public NodoParalelos() {  //constructor
		sig = null;
	}
	
	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public LS_NormalInscritos getLs_NormalInscritos() {
		return ls_NormalInscritos;
	}

	public void setLs_NormalInscritos(LS_NormalInscritos ls_NormalInscritos) {
		this.ls_NormalInscritos = ls_NormalInscritos;
	}

	public NodoParalelos getSig() {
		return sig;
	}

	public void setSig(NodoParalelos sig) {
		this.sig = sig;
	}
	
}
