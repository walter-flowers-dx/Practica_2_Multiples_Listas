package Ejercicio_8;

public class LS_NormalInscritos extends ListaSimpleInscritos{

	public LS_NormalInscritos() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(String nombre, int ci) {
		NodoInscritos nuevo = new NodoInscritos();
		nuevo.setNombre(nombre);
		nuevo.setCi(ci);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(String nombre, int ci) {
		NodoInscritos nuevo = new NodoInscritos();
		nuevo.setNombre(nombre);
		nuevo.setCi(ci);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoInscritos R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoInscritos R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println(R.getNombre() + " - " + R.getCi());
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoInscritos R = P;
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
	
	public NodoInscritos eliPrincipio() {
		NodoInscritos x = new NodoInscritos();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoInscritos eliFinal() {
		NodoInscritos x = new NodoInscritos();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoInscritos R = P;
				NodoInscritos S = P;
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
