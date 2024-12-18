package Ejercicio_8;

public class LS_NormalParalelos extends ListaSimpleParalelos{

	public LS_NormalParalelos() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(String docente, String paralelo, LS_NormalInscritos ls_NormalInscritos) {
		NodoParalelos nuevo = new NodoParalelos();
		nuevo.setDocente(docente);
		nuevo.setParalelo(paralelo);
		nuevo.setLs_NormalInscritos(ls_NormalInscritos);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(String docente, String paralelo, LS_NormalInscritos ls_NormalInscritos) {
	    NodoParalelos nuevo = new NodoParalelos();
	    nuevo.setDocente(docente);
	    nuevo.setParalelo(paralelo);
	    nuevo.setLs_NormalInscritos(ls_NormalInscritos);
	    nuevo.setSig(null); // Asegurarse de que el último nodo apunte a null
	    
	    if (esVacia())
	        P = nuevo; // P apunta al nuevo nodo si la lista está vacía
	    else {
	        NodoParalelos R = P;
	        while (R.getSig() != null) {
	            R = R.getSig(); // Avanzar hasta el último nodo
	        }
	        R.setSig(nuevo); // Enlazar el último nodo al nuevo
	    }
	}

	
	
	public void mostrar() {
		NodoParalelos R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println(R.getDocente() + " - " + R.getParalelo());
			R.getLs_NormalInscritos().mostrar();
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoParalelos R = P;
		int c = 0;
		if(this.esVacia())
			return 0;
		else {
			while(R != null) {
				c++;
				R = R.getSig();
			}
		}
		return c;
	}
	
	public NodoParalelos eliPrincipio() {
		NodoParalelos x = new NodoParalelos();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoParalelos eliFinal() {
	    NodoParalelos x = null;
	    if (!esVacia()) {
	        if (nroNodos() == 1) { // Si solo hay un nodo
	            x = P;
	            P = null; // La lista queda vacía
	        } else {
	            NodoParalelos R = P;
	            NodoParalelos S = null;
	            while (R.getSig() != null) {
	                S = R;
	                R = R.getSig(); // Avanzar al último nodo
	            }
	            x = R; // Guardar referencia del nodo eliminado
	            if (S != null) {
	                S.setSig(null); // El nuevo último nodo apunta a null
	            }
	        }
	    }
	    return x;
	}
	
	public void eliminarParalelo(String paralelo) {
	    if (P == null) return;

	    // Si el paralelo a eliminar está en la cabeza
	    if (P.getParalelo().equals(paralelo)) {
	        P = P.getSig();
	        return;
	    }

	    // Buscar el paralelo a eliminar
	    NodoParalelos actual = P;
	    while (actual.getSig() != null) {
	        if (actual.getSig().getParalelo().equals(paralelo)) {
	            actual.setSig(actual.getSig().getSig());
	            return;
	        }
	        actual = actual.getSig();
	    }
	}


}
