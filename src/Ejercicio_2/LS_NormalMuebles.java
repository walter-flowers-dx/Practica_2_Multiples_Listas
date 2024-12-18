package Ejercicio_2;

public class LS_NormalMuebles extends ListaSimpleMuebles {
    public LS_NormalMuebles() {
        super();
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adiPrincipio(int cantidad, String nombre) {
        NodoMuebles nuevo = new NodoMuebles();
        nuevo.setCantidad(cantidad);
        nuevo.setNombre(nombre);
        nuevo.setSig(P);
        P = nuevo;
    }

    public void adiFinal(int cantidad, String nombre) {
        NodoMuebles nuevo = new NodoMuebles();
        nuevo.setCantidad(cantidad);
        nuevo.setNombre(nombre);

        if (esVacia()) {
            P = nuevo;
        } else {
            NodoMuebles R = P;
            while (R.getSig() != null) {
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoMuebles R = P;
        while (R != null) {
            sb.append(R.getCantidad()).append(" - ").append(R.getNombre()).append("\n");
            R = R.getSig();
        }
        return sb.toString();
    }


    public void mostrar() {
        NodoMuebles R = P;
        while (R != null) {
            System.out.print(R.getCantidad() + " - " + R.getNombre() + "\n");
            R = R.getSig();
        }
        System.out.println();
    }

    public int nroNodos() {
        NodoMuebles R = P;
        int count = 0;
        while (R != null) {
            count++;
            R = R.getSig();
        }
        return count;
    }

    public String eliPrincipio() {
        if (esVacia()) {
            return null;
        } else {
            String idioma = P.getNombre();
            P = P.getSig();
            return idioma;
        }
    }

    public String eliFinal() {
        if (esVacia()) {
            return null;
        } else if (nroNodos() == 1) {
            String idioma = P.getNombre();
            P = null;
            return idioma;
        } else {
            NodoMuebles R = P;
            NodoMuebles S = null;
            while (R.getSig() != null) {
                S = R;
                R = R.getSig();
            }
            String idioma = R.getNombre();
            S.setSig(null);
            return idioma;
        }
    }
}