package Ejercicio_4;

public class NodoPuestos {
	private int nroPuesto;
	private String nomProductor;
	private LS_CircularProductos ls_CircularProductos;
	private NodoPuestos sig; //definiendo el campo enlace sig
	
	public NodoPuestos() {  //constructor
		sig = null;
	}
	
	public int getNroPuesto() {
		return nroPuesto;
	}

	public void setNroPuesto(int nroPuesto) {
		this.nroPuesto = nroPuesto;
	}

	public String getNomProductor() {
		return nomProductor;
	}

	public void setNomProductor(String nomProductor) {
		this.nomProductor = nomProductor;
	}

	public LS_CircularProductos getLs_CircularProductos() {
		return ls_CircularProductos;
	}

	public void setLs_CircularProductos(LS_CircularProductos ls_CircularProductos) {
		this.ls_CircularProductos = ls_CircularProductos;
	}

	public NodoPuestos getSig() {
		return sig;
	}

	public void setSig(NodoPuestos sig) {
		this.sig = sig;
	}
	
}
