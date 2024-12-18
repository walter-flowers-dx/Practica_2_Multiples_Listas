package Ejercicio_4;

public class LS_NormalFeriasAgropecuarias extends ListaSimpleFeriasAgropecuarias{

	public LS_NormalFeriasAgropecuarias() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(String nomFerias, String fecha, String lugar, LS_NormalPuestos ls_NormalPuestos) {
		NodoFeriasAgropecuarias nuevo = new NodoFeriasAgropecuarias();
		nuevo.setNomFeria(nomFerias);
		nuevo.setFecha(fecha);
		nuevo.setLugar(lugar);
		nuevo.setLs_NormalPuestos(ls_NormalPuestos);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(String nomFerias, String fecha, String lugar, LS_NormalPuestos ls_NormalPuestos) {
		NodoFeriasAgropecuarias nuevo = new NodoFeriasAgropecuarias();
		nuevo.setNomFeria(nomFerias);
		nuevo.setFecha(fecha);
		nuevo.setLugar(lugar);
		nuevo.setLs_NormalPuestos(ls_NormalPuestos);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoFeriasAgropecuarias R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoFeriasAgropecuarias R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println(R.getNomFeria() + " - " + R.getFecha() + " - " + R.getLugar());
			R.getLs_NormalPuestos().mostrar();
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoFeriasAgropecuarias R = P;
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
	
	public NodoFeriasAgropecuarias eliPrincipio() {
		NodoFeriasAgropecuarias x = new NodoFeriasAgropecuarias();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoFeriasAgropecuarias eliFinal() {
		NodoFeriasAgropecuarias x = new NodoFeriasAgropecuarias();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoFeriasAgropecuarias R = P;
				NodoFeriasAgropecuarias S = P;
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
