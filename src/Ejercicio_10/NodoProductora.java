package Ejercicio_10;

public class NodoProductora {
    private
        String nombre;
        LS_NormalPro LP;
        LS_NormalTec LT;
        NodoProductora sig, ant;
    public NodoProductora(){
    	sig=null;
        ant=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LS_NormalPro getLP() {
        return LP;
    }

    public void setLP(LS_NormalPro LP) {
        this.LP = LP;
    }

    public LS_NormalTec getLT() {
        return LT;
    }

    public void setLT(LS_NormalTec LT) {
        this.LT = LT;
    }

    public NodoProductora getSig() {
        return sig;
    }

    public void setSig(NodoProductora sig) {
        this.sig = sig;
    }

    public NodoProductora getAnt() {
        return ant;
    }

    public void setAnt(NodoProductora ant) {
        this.ant = ant;
    }
    
	    
}
