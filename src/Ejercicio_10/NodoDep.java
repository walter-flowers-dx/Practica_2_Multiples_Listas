package Ejercicio_10;

public class NodoDep {
    private
        String nombre;
        LD_NormalProductora LPROD;
        NodoDep sig;
        NodoDep ant;
    public NodoDep(){
    	sig=null;
        ant=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LD_NormalProductora getLPROD() {
        return LPROD;
    }

    public void setLPROD(LD_NormalProductora LPROD) {
        this.LPROD = LPROD;
    }

    public NodoDep getSig() {
        return sig;
    }

    public void setSig(NodoDep sig) {
        this.sig = sig;
    }

    public NodoDep getAnt() {
        return ant;
    }

    public void setAnt(NodoDep ant) {
        this.ant = ant;
    }

}
