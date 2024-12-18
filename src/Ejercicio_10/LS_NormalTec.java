package Ejercicio_10;
public class LS_NormalTec extends ListaSimpleTec{

	public LS_NormalTec() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(String nom, String desc) {
		NodoTec nuevo = new NodoTec();
		nuevo.setNombre(nom);
                nuevo.setDescripcion(desc);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(String nom, String desc) {
		NodoTec nuevo = new NodoTec();
		nuevo.setNombre(nom);
                nuevo.setDescripcion(desc);
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoTec R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoTec R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println("---> TECNOLOGIA: ");
                        System.out.println("idCultivo: "+R.getNombre());
                        System.out.println("Tipo: "+R.getDescripcion());
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoTec R = P;
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
	
	public NodoTec eliPrincipio() {
		NodoTec x = new NodoTec();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoTec eliFinal() {
		NodoTec x = new NodoTec();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoTec R = P;
				NodoTec S = P;
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
