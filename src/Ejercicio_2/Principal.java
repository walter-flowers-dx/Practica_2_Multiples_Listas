package Ejercicio_2;

public class Principal {

    public static void main(String[] args) {
        // LISTA DE MUEBLES
        LS_NormalMuebles lsnm1 = new LS_NormalMuebles();
        lsnm1.adiFinal(2, "Ropero");
        lsnm1.adiFinal(1, "Mesa");
        
        LS_NormalMuebles lsnm2 = new LS_NormalMuebles();
        lsnm2.adiFinal(3, "Escritorios");
        lsnm2.adiFinal(1, "Vitrinas");
        
        LS_NormalMuebles lsnm3 = new LS_NormalMuebles();
        lsnm3.adiFinal(1, "Ropero");
        lsnm3.adiFinal(1, "Vitrinas");
        
        System.out.println("LISTA DE MUEBLES: ");
		lsnm1.mostrar();
		lsnm2.mostrar();
		lsnm3.mostrar();
        
        // LISTA DE HABITACIONES
        LS_CircularHabitaciones lsch1 = new LS_CircularHabitaciones();
        lsch1.adiFinal("Dormitorio", "Verde", 20, lsnm1);
        lsch1.adiFinal("Sala", "Turqueza", 40, lsnm3);
        lsch1.adiFinal("Cocina", "Rojo", 60, lsnm2);
        
        LS_CircularHabitaciones lsch2 = new LS_CircularHabitaciones();
        lsch2.adiFinal("Dormitorio", "Verde", 50, lsnm1);
        lsch2.adiFinal("Sala", "Amarillo", 550, lsnm2);
        
        LS_CircularHabitaciones lsch3 = new LS_CircularHabitaciones();
        lsch3.adiFinal("Dormitorio", "Negro", 20, lsnm1);
        lsch3.adiFinal("Sala", "Cafe", 25, lsnm3);
        lsch3.adiFinal("Dormitorio", "Azul", 30, lsnm2);
        
        System.out.println("\nLISTA DE HABITACIONES: ");
		System.out.println("Habitacion 1.- ");
		lsch1.mostrar();
		System.out.println("Habitacion 2.- ");
		lsch2.mostrar();
		System.out.println("Habitacion 3.- ");
		lsch3.mostrar();
        
        // LISTA DE INMUEBLES
        LD_NormalInmueble lsni1 = new LD_NormalInmueble();
        lsni1.adiFinal("01", 150, "Miraflores", lsch1);
        lsni1.adiFinal("02", 250, "Irpavi", lsch2);
        lsni1.adiFinal("03", 350, "Sopocachi", lsch3);
        
        LD_NormalInmueble  lsni2 = new LD_NormalInmueble();
		lsni2.adiFinal("06", 100, "Zona Sur", lsch2);
		lsni2.adiFinal("07", 200, "Calacoto", lsch2);
		lsni2.adiFinal("08", 150, "Villa el Carmen", lsch3);
		
		LD_NormalInmueble  lsni3 = new LD_NormalInmueble();
		lsni3.adiFinal("11", 75, "Miraflores", lsch3);
		lsni3.adiFinal("12", 125, "Sopocachi", lsch2);
		lsni3.adiFinal("13", 80, "Calacoto", lsch1);
        
        System.out.println("\nLISTA DE INMUEBLES: ");
		System.out.println("Inmueble 1.- ");
		lsni1.mostrar();
		System.out.println("Inmueble 2.- ");
		lsni2.mostrar();
		System.out.println("Inmueble 3.- ");
		lsni3.mostrar();
        
        System.out.println("\na) Mostrar el bien inmueble que tenga mas muebles "
        		+ "\nen las habitaciones de tipo 'Dormitorio'");
        mostrarInmuebleMayorHabitaciones(lsni1);

		System.out.println("\nb) Del bien inmueble mas grande eliminar las habitaciones "
				+ "\nque tengan X muebles. Donde X es un numero primo");
        calcularTotalMueblesPorTipo(lsni1);

        System.out.println("\nc) Añadir un mueble a cada habitacion de un bien inmueble "
        		+ "\nque este en la ubicacion Y");
        cambiarColorHabitaciones(lsni1, "Dormitorio", "Blanco");
        lsni1.mostrar();
    }

    // a.
    public static void mostrarInmuebleMayorHabitaciones(LD_NormalInmueble lista) {
        NodoInmueble maxInmueble = null;
        int maxHabitaciones = 0;

        NodoInmueble actual = lista.getP();
        while (actual != null) {
            int nroHabitaciones = actual.getLs_CircularHabitaciones().nroNodos();
            if (nroHabitaciones > maxHabitaciones) {
                maxHabitaciones = nroHabitaciones;
                maxInmueble = actual;
            }
            actual = actual.getSig();
        }

        if (maxInmueble != null) {
            System.out.println(maxInmueble.getIdCasa() + " - " + maxInmueble.getUbicacion() +
                " con " + maxHabitaciones + " habitaciones.");
        }
    }

    // b.
    public static void calcularTotalMueblesPorTipo(LD_NormalInmueble lista) {
        NodoInmueble actual = lista.getP();
        while (actual != null) {
            LS_CircularHabitaciones habitaciones = actual.getLs_CircularHabitaciones();
            NodoHabitaciones habActual = habitaciones.getP();

            if (habActual != null) {
                do {
                    LS_NormalMuebles muebles = habActual.getLs_NormalMuebles();
                    NodoMuebles muebleActual = muebles.getP();
                    while (muebleActual != null) {
                        System.out.println("Mueble: " + muebleActual.getNombre() + ", Cantidad: " + muebleActual.getCantidad());
                        muebleActual = muebleActual.getSig();
                    }
                    habActual = habActual.getSig();
                } while (habActual != habitaciones.getP());
            }
            actual = actual.getSig();
        }
    }

    // c.
    public static void cambiarColorHabitaciones(LD_NormalInmueble lista, String tipoHabitacion, String nuevoColor) {
        NodoInmueble actual = lista.getP();
        while (actual != null) {
            LS_CircularHabitaciones habitaciones = actual.getLs_CircularHabitaciones();
            NodoHabitaciones habActual = habitaciones.getP();

            if (habActual != null) {
                do {
                    if (habActual.getTipoHabitacion().equals(tipoHabitacion)) {
                        habActual.setColor(nuevoColor);
                    }
                    habActual = habActual.getSig();
                } while (habActual != habitaciones.getP());
            }
            actual = actual.getSig();
        }
    }
}
