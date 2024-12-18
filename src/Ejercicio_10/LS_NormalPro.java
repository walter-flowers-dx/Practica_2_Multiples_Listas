package Ejercicio_10;
public class LS_NormalPro extends ListaSimplePro{

	public LS_NormalPro() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(int id, double t, double h) {
		NodoPro nuevo = new NodoPro();
		nuevo.setIdCultivo(id);
                nuevo.setToneladas(t);
                nuevo.setHectareas(h);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(int id, double t, double h) {
		NodoPro nuevo = new NodoPro();
		nuevo.setIdCultivo(id);
                nuevo.setToneladas(t);
                nuevo.setHectareas(h);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoPro R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoPro R = P;   //R apunta  a la raiz P
		while(R != null) {
                    System.out.println("---> PRODUCCION: ");
                    System.out.println("idCultivo: "+R.getIdCultivo());
                    System.out.println("Toneladas: "+R.getToneladas());
                    System.out.println("Hectareas: "+R.getHectareas());
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoPro R = P;
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
	
	public NodoPro eliPrincipio() {
		NodoPro x = new NodoPro();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoPro eliFinal() {
		NodoPro x = new NodoPro();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoPro R = P;
				NodoPro S = P;
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
