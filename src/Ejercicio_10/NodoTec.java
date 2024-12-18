package Ejercicio_10;
public class NodoTec {
	private String nombre, descripcion;
	private NodoTec sig; //definiendo el campo enlace sig
	
	public NodoTec() {  //constructor
		sig = null;
	}

	public NodoTec getSig() {
		return sig;
	}

	public void setSig(NodoTec sig) {
		this.sig = sig;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	
}
