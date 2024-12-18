package Ejercicio_6;

public class LS_NormalMateria extends ListaSimpleMateria{

	public LS_NormalMateria() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(Materia z) {
		NodoMateria nuevo = new NodoMateria();
		nuevo.setQ(z);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(Materia z, int parcial1, int parcial2, int exFinal, int notaAux) {
		NodoMateria nuevo = new NodoMateria();
		nuevo.setQ(z);
		nuevo.setParcial1(parcial1);
		nuevo.setParcial2(parcial2);
		nuevo.setExFinal(exFinal);
		nuevo.setNotaAux(notaAux);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoMateria R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoMateria R = P;   //R apunta  a la raiz P
		while(R != null) {
			R.getQ().mostrar();
			System.out.println(R.getParcial1() + " - " + R.getParcial2() + " - " + R.getExFinal() + " - " + R.getNotaAux());
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoMateria R = P;
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
	
	public NodoMateria eliPrincipio() {
		NodoMateria x = new NodoMateria();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoMateria eliFinal() {
		NodoMateria x = new NodoMateria();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoMateria R = P;
				NodoMateria S = P;
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
