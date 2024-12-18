package Ejercicio_6;

public class LS_NormalEstudiantes extends ListaSimpleEstudiantes{

	public LS_NormalEstudiantes() {
		super();
	}

	public boolean esVacia() {
		if(P == null)
			return true;
		return false;
	}

	public void adiPrincipio(String nombreestudiante, LS_NormalMateria ls_NormalMateria, String semestre, String gestion) {
		NodoEstudiantes nuevo = new NodoEstudiantes();
		nuevo.setNombreEstudiante(nombreestudiante);
		nuevo.setLs_NormalMateria(ls_NormalMateria);
		nuevo.setSemestre(semestre);
		nuevo.setGestion(gestion);
		P = nuevo;      //P apunta a nuevo
	}
	
	public void adiFinal(String nombreestudiante, LS_NormalMateria ls_NormalMateria, String semestre, String gestion) {
		NodoEstudiantes nuevo = new NodoEstudiantes();
		nuevo.setNombreEstudiante(nombreestudiante);
		nuevo.setLs_NormalMateria(ls_NormalMateria);
		nuevo.setSemestre(semestre);
		nuevo.setGestion(gestion);
		
		if(esVacia())
			P = nuevo;   //p apunta a nuevo
		else {
			NodoEstudiantes R = P;
			while( R.getSig() != null ){
			     R = R.getSig();
			}
			R.setSig(nuevo);
		}
	}
	
	
	public void mostrar() {
		NodoEstudiantes R = P;   //R apunta  a la raiz P
		while(R != null) {
			System.out.println(R.getNombreEstudiante() + " - " + R.getSemestre() + " - " + R.getGestion());
			R.getLs_NormalMateria().mostrar();
			R = R.getSig();
		}
	}

	public int nroNodos() {
		NodoEstudiantes R = P;
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
	
	public NodoEstudiantes eliPrincipio() {
		NodoEstudiantes x = new NodoEstudiantes();    
		if(!esVacia()) {
			x = P ;     // x apunta a la raiz P
			P = P.getSig();
			x.setSig(null);
		}
		return x;
	}
	
	public NodoEstudiantes eliFinal() {
		NodoEstudiantes x = new NodoEstudiantes();
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = P;      //x apunta a la raiz P
				P = null;
			}else {
				NodoEstudiantes R = P;
				NodoEstudiantes S = P;
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
