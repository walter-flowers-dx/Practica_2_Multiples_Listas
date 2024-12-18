package Ejercicio_8;

public class LS_NormalMaterias extends ListaSimpleMaterias{

	public LS_NormalMaterias() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(String sigla, String nombre, LS_NormalParalelos ls_NormalParalelos) {
		NodoMaterias nuevo = new NodoMaterias();
		nuevo.setSigla(sigla);
		nuevo.setNombre(nombre);
		nuevo.setLs_NormalParalelos(ls_NormalParalelos);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(String sigla, String nombre, LS_NormalParalelos ls_NormalParalelos) {
		NodoMaterias nuevo = new NodoMaterias();
		nuevo.setSigla(sigla);
		nuevo.setNombre(nombre);
		nuevo.setLs_NormalParalelos(ls_NormalParalelos);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoMaterias R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoMaterias R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println("\n" + R.getSigla() + " - " + R.getNombre());
			R.getLs_NormalParalelos().mostrar();
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoMaterias R = P;
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
	
	public NodoMaterias eliPrincipio() {
		NodoMaterias x = new NodoMaterias();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoMaterias eliFinal() {
		NodoMaterias x = new NodoMaterias();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoMaterias R = P;
				NodoMaterias S = P;
				while(R.getSig() != null) {
					S = R;         //S apunta a R
					R = R.getSig(); //R apunta al siguiente de R
				}
				x = R;
				S.setSig(null);
			}
		}
		return x;
	}
}
