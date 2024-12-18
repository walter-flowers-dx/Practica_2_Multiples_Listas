package Ejercicio_4;

public class LS_NormalPuestos extends ListaSimplePuestos{

	public LS_NormalPuestos() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(int nroPuesto, String nomProducto, LS_CircularProductos ls_CircularProductos) {
		NodoPuestos nuevo = new NodoPuestos();
		nuevo.setNroPuesto(nroPuesto);
		nuevo.setNomProductor(nomProducto);
		nuevo.setLs_CircularProductos(ls_CircularProductos);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(int nroPuesto, String nomProducto, LS_CircularProductos ls_CircularProductos) {
		NodoPuestos nuevo = new NodoPuestos();
		nuevo.setNroPuesto(nroPuesto);
		nuevo.setNomProductor(nomProducto);
		nuevo.setLs_CircularProductos(ls_CircularProductos);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoPuestos R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoPuestos R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println(R.getNroPuesto() + " - " + R.getNomProductor() );
			R.getLs_CircularProductos().mostrar();
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoPuestos R = P;
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
	
	public NodoPuestos eliPrincipio() {
		NodoPuestos x = new NodoPuestos();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoPuestos eliFinal() {
		NodoPuestos x = new NodoPuestos();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoPuestos R = P;
				NodoPuestos S = P;
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
