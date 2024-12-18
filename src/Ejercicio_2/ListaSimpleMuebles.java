package Ejercicio_2;

public class ListaSimpleMuebles {
    protected NodoMuebles P; 
    
    public ListaSimpleMuebles() {
        P = null;       
    }

    public NodoMuebles getP() {
        return P;
    }

    public void setP(NodoMuebles p) {
        P = p;
    }
}