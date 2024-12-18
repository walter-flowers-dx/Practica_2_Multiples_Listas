package Ejercicio_6;

public class NodoEstudiantes {
	private String nombreEstudiante;
	private LS_NormalMateria ls_NormalMateria;
	private String semestre;
	private String gestion;
	private NodoEstudiantes sig; //definiendo el campo enlace sig
	
	public NodoEstudiantes() {  //constructor
		sig = null;
	}
	

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}


	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}


	public LS_NormalMateria getLs_NormalMateria() {
		return ls_NormalMateria;
	}


	public void setLs_NormalMateria(LS_NormalMateria ls_NormalMateria) {
		this.ls_NormalMateria = ls_NormalMateria;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


	public String getGestion() {
		return gestion;
	}


	public void setGestion(String gestion) {
		this.gestion = gestion;
	}


	public NodoEstudiantes getSig() {
		return sig;
	}

	public void setSig(NodoEstudiantes sig) {
		this.sig = sig;
	}
	
}
