package Ejercicio_4;

public class LS_CircularProductos extends ListaSimpleProductos{
	public LS_CircularProductos() {
        super(); // Constructor de la clase padre
    }
    
    public boolean esVacia() {
        return P == null; 
    }

    public int nroNodos() {
        int c = 0;
        if (P != null) {
            NodoProductos R = P;
            do {
                c++;
                R = R.getSig();
            } while (R != P);
        }
        return c;
    }

    public void adiFinal(String nomProducto, double precio) {
        NodoProductos nuevo = new NodoProductos();
        nuevo.setNomProducto(nomProducto);
        nuevo.setPrecio(precio);

        if (P == null) {
            P = nuevo;
            P.setSig(P); // Lista circular
        } else {
            NodoProductos R = P;
            while (R.getSig() != P) {
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
        }
    }

    public void adiPrincipio(String nomProducto, double precio) {
    	NodoProductos nuevo = new NodoProductos();
        nuevo.setNomProducto(nomProducto);
        nuevo.setPrecio(precio);

        if (P == null) {
            P = nuevo;
            P.setSig(P);
        } else {
            NodoProductos R = P;
            while (R.getSig() != P) {
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
            P = nuevo;
        }
    }

    public void mostrar() {
        if (!esVacia()) {
            NodoProductos R = P;
            do {
                System.out.println(R.getNomProducto() + " - " + R.getPrecio()); // Muestra cada Hechizos
                R = R.getSig();
            } while (R != P);
        }
    }

    public NodoProductos eliPrincipio() {
        NodoProductos x = null;
        if (!esVacia()) {
            if (P.getSig() == P) {
                x = P;
                P = null;
            } else {
                x = P;
                NodoProductos R = P;
                while (R.getSig() != P) {
                    R = R.getSig();
                }
                P = P.getSig();
                R.setSig(P);
            }
        }
        return x;
    }
}