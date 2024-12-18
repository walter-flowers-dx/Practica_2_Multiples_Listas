package Ejercicio_10;
public class LS_NormalCulti extends ListaSimpleCulti{

	public LS_NormalCulti() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(int id, String ti, String nom) {
		NodoCulti nuevo = new NodoCulti();
		nuevo.setIdCultivo(id);
                nuevo.setTipo(ti);
                nuevo.setNombre(nom);
		nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(int id, String ti, String nom) {
		NodoCulti nuevo = new NodoCulti();
		nuevo.setIdCultivo(id);
                nuevo.setTipo(ti);
                nuevo.setNombre(nom);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoCulti R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoCulti R = P;   //R apunta  a la raiz P
		while(R != null) {
                    System.out.println("---> CULTIVO: ");
                    System.out.println("idCultivo: "+R.getIdCultivo());
                    System.out.println("Tipo: "+R.getTipo());
                    System.out.println("Nombre: "+R.getNombre());
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoCulti R = P;
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
	
	public NodoCulti eliPrincipio() {
		NodoCulti x = new NodoCulti();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoCulti eliFinal() {
		NodoCulti x = new NodoCulti();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoCulti R = P;
				NodoCulti S = P;
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
