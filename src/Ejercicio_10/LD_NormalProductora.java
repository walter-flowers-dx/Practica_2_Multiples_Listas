package Ejercicio_10;
import java.util.Scanner;

public class LD_NormalProductora extends ListaDobleProductora{
    
   public LD_NormalProductora() {
        super(); // Llama al constructor de ListaDobleP
    }

    // Método para verificar si la lista está vacía
    public boolean esVacia() {
        return P == null;
    }

    // Método para contar el número de nodos en la lista
    public int nroNodos() {
        int contador = 0;
        NodoProductora actual = P;
        while (actual != null) {
            contador++;
            actual = actual.sig;
        }
        return contador;
    }

    // Método para mostrar todos los proyectos en la lista
    public void mostrar() {
        if (esVacia()) {
            System.out.println("La lista está vacía.");
        } else {
            NodoProductora actual = P;
            while (actual != null) {
                System.out.println("+--------- "+actual.getNombre()+"-------+");
                System.out.println("** PRODUCCION");
                actual.getLP().mostrar();
                System.out.println("** TECNOLOGIA");
                actual.getLT().mostrar();
                actual = actual.sig;
            }
        }
    }

    // Método para añadir un proyecto al inicio de la lista
    public void adiPrimero(String l,LS_NormalPro p, LS_NormalTec t) {
        NodoProductora nuevo = new NodoProductora();
        nuevo.setNombre(l);
        nuevo.setLP(p);
        nuevo.setLT(t);
        if (esVacia()) {
            P = nuevo;
        } else {
            nuevo.sig = P;
            P.ant = nuevo;
            P = nuevo;
        }
    }

    // Método para añadir un proyecto al final de la lista
    public void adiFinal(String l,LS_NormalPro p, LS_NormalTec t) {
        NodoProductora nuevo = new NodoProductora();
        nuevo.setNombre(l);
        nuevo.setLP(p);
        nuevo.setLT(t);
        if (esVacia()) {
            P = nuevo;
        } else {
            NodoProductora actual = P;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = nuevo;
            nuevo.ant = actual;
        }
    }

    // Método para eliminar el primer nodo de la lista
    public void eliPrimero() {
        if (!esVacia()) {
            if (P.sig == null) {
                P = null;
            } else {
                P = P.sig;
                P.ant = null;
            }
        }
    }

    // Método para eliminar el último nodo de la lista
    public void eliFinal() {
        if (!esVacia()) {
            if (P.sig == null) {
                P = null;
            } else {
                NodoProductora actual = P;
                while (actual.sig != null) {
                    actual = actual.sig;
                }
                actual.ant.sig = null;
            }
      }
    }
}
