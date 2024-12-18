package Ejercicio_10;
public class NodoCulti {
    private int idCultivo;
    private String tipo, nombre;
    private NodoCulti sig; //definiendo el campo enlace sig

    public NodoCulti() {  //constructor
            sig = null;
    }

    public NodoCulti getSig() {
            return sig;
    }

    public void setSig(NodoCulti sig) {
            this.sig = sig;
    }

    public int getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(int idCultivo) {
        this.idCultivo = idCultivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
}
