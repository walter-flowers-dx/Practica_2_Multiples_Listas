package Ejercicio_4;

public class NodoProductos {
	private String nomProducto;
	private double precio;
	private NodoProductos sig; //definiendo el campo enlace sig
	
	public NodoProductos() {  //constructor
		sig = null;
	}


	public String getNomProducto() {
		return nomProducto;
	}


	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public NodoProductos getSig() {
		return sig;
	}

	public void setSig(NodoProductos sig) {
		this.sig = sig;
	}

	
}
