package Ejercicio_2;

public class NodoMuebles {
    private int cantidad;
    private String nombre;
    private NodoMuebles sig;
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public NodoMuebles getSig() {
		return sig;
	}
	public void setSig(NodoMuebles sig) {
		this.sig = sig;
	} 
    
    
    
}