package Ejercicio_4;
public class Principal {
	public static void main(String[] args) {
		// LISTA DE PRODUCTOS
		LS_CircularProductos lscp1 = new LS_CircularProductos();
		lscp1.adiFinal("Manzanas", 50);
		lscp1.adiFinal("Peras", 100);
		lscp1.adiFinal("Uvas", 75);
		lscp1.adiFinal("Platanos", 35);
		
		LS_CircularProductos lscp2 = new LS_CircularProductos();
		lscp2.adiFinal("Leche", 60);
		lscp2.adiFinal("Carne de Res", 200);
		lscp2.adiFinal("Huevos de gallina", 85);
		
		LS_CircularProductos lscp3 = new LS_CircularProductos();
		lscp3.adiFinal("Mermeladas", 40);
		lscp2.adiFinal("Leche", 60);
		lscp3.adiFinal("Harinas", 100);
		
		System.out.println("LISTA DE PRODUCTOS: ");
		System.out.println("Lista 1.- ");
		lscp1.mostrar();
		System.out.println("Lista 2.- ");
		lscp2.mostrar();
		System.out.println("Lista 3.- ");
		lscp3.mostrar();
		
		
		// LISTA DE PUESTOS
		LS_NormalPuestos lsnp1 = new LS_NormalPuestos();
		lsnp1.adiFinal(5, "Productos Agricolas", lscp1);
		lsnp1.adiFinal(3, "Productos De Ganaderia", lscp2);
		lsnp1.adiFinal(2, "Productos Transformados", lscp3);
		
		LS_NormalPuestos lsnp2 = new LS_NormalPuestos();
		lsnp2.adiFinal(6, "Productos De Ganaderia", lscp2);
		
		LS_NormalPuestos lsnp3 = new LS_NormalPuestos();
		lsnp3.adiFinal(4, "Productos Agricolas", lscp1);
		lsnp3.adiFinal(9, "Productos Transformados", lscp3);
		
		System.out.println("\nLISTA DE PUESTOS: ");
		System.out.println("Puesto 1.- ");
		lsnp1.mostrar();
		System.out.println("Puesto 2.- ");
		lsnp2.mostrar();
		System.out.println("Puesto 3.- ");
		lsnp3.mostrar();
		
		
		// LISTA DE FERIAS AGRICOLAS
		LS_NormalFeriasAgropecuarias lsnfa1 = new LS_NormalFeriasAgropecuarias();
		lsnfa1.adiFinal("Feria 5", "10-12-2023", "Miraflores", lsnp1);
		lsnfa1.adiFinal("Feria 1", "05-01-2021", "Sopocachi", lsnp2);
		lsnfa1.adiFinal("Feria 4", "31-12-2022", "Irpavi", lsnp3);
		
		LS_NormalFeriasAgropecuarias lsnfa2 = new LS_NormalFeriasAgropecuarias();
		lsnfa2.adiFinal("Feria 7", "15-01-2021", "Sopocachi", lsnp2);
		
		LS_NormalFeriasAgropecuarias lsnfa3 = new LS_NormalFeriasAgropecuarias();
		lsnfa3.adiFinal("Feria 3", "22-03-2023", "Miraflores", lsnp1);
		lsnfa3.adiFinal("Feria 9", "10-06-2022", "Irpavi", lsnp3);
		lsnfa1.adiFinal("Feria 1", "05-01-2021", "Sopocachi", lsnp2);
		
		System.out.println("\nLISTA DE FERIAS AGROPECUARIAS");
		System.out.println("Primera Feria");
		lsnfa1.mostrar();
		System.out.println("Segunda Feria");
		lsnfa2.mostrar();
		System.out.println("Tercera Feria");
		lsnfa3.mostrar();
		
		System.out.println("\na) Mostrar el producto más vendido en las ferias de nombre Y");
        mostrarProductoMasVendido("Feria 5", lsnfa1); 

        System.out.println("\nb) De cada feria contar, cuál es el puesto que tiene más productos");
        System.out.println("Primera Feria: ");
        mostrarPuestoConMasProductos(lsnfa1);
        System.out.println("Segunda Feria: ");
        mostrarPuestoConMasProductos(lsnfa2);
        System.out.println("Tercera Feria: ");
        mostrarPuestoConMasProductos(lsnfa3);

        System.out.println("\nc) De la feria con lugar Z, eliminar a los puestos que tengan productos "
        		+ "\ncon precio mayor a Y");
        eliminarPuestosPorPrecio("Miraflores", 50, lsnfa1);
        System.out.println("Lista de ferias tras eliminación:");
        lsnfa1.mostrar();
	}
	// a.
    public static void mostrarProductoMasVendido(String feriaNombre, LS_NormalFeriasAgropecuarias ferias) {
        NodoFeriasAgropecuarias R = ferias.getP();
        while (R != null) {
            if (R.getNomFeria().equals(feriaNombre)) {
                NodoPuestos puesto = R.getLs_NormalPuestos().getP();
                NodoProductos productoMasVendido = null;
                double precioTotalMayor = 0;
                while (puesto != null) {
                    NodoProductos producto = puesto.getLs_CircularProductos().getP();
                    double precioTotal = 0;
                    if (producto != null) {
                        NodoProductos temp = producto;
                        do {
                            precioTotal += temp.getPrecio();
                            temp = temp.getSig();
                        } while (temp != producto);
                    }
                    if (precioTotal > precioTotalMayor) {
                        precioTotalMayor = precioTotal;
                        productoMasVendido = producto;
                    }
                    puesto = puesto.getSig();
                }
                if (productoMasVendido != null) {
                    System.out.println("Producto más vendido: " + productoMasVendido.getNomProducto());
                } else {
                    System.out.println("No hay productos en esta feria.");
                }
            }
            R = R.getSig();
        }
    }

    // b.
    public static void mostrarPuestoConMasProductos(LS_NormalFeriasAgropecuarias ferias) {
        NodoFeriasAgropecuarias feria = ferias.getP();
        while (feria != null) {
            NodoPuestos puesto = feria.getLs_NormalPuestos().getP();
            NodoPuestos puestoConMasProductos = null;
            int maxProductos = 0;
            while (puesto != null) {
                NodoProductos producto = puesto.getLs_CircularProductos().getP();
                int contador = 0;
                if (producto != null) {
                    NodoProductos temp = producto;
                    do {
                        contador++;
                        temp = temp.getSig();
                    } while (temp != producto);
                }
                if (contador > maxProductos) {
                    maxProductos = contador;
                    puestoConMasProductos = puesto;
                }
                puesto = puesto.getSig();
            }
            if (puestoConMasProductos != null) {
                System.out.println("Feria: " + feria.getNomFeria() + ", Puesto con más productos: " +
                                   puestoConMasProductos.getNroPuesto() + " con " + maxProductos + " productos.");
            } else {
                System.out.println("Feria: " + feria.getNomFeria() + " no tiene productos.");
            }
            feria = feria.getSig();
        }
    }

    // c.
    public static void eliminarPuestosPorPrecio(String lugar, double precioMaximo, LS_NormalFeriasAgropecuarias ferias) {
        NodoFeriasAgropecuarias feria = ferias.getP();
        while (feria != null) {
            if (feria.getLugar().equals(lugar)) {
                NodoPuestos actual = feria.getLs_NormalPuestos().getP();
                NodoPuestos anterior = null;
                while (actual != null) {
                    NodoProductos producto = actual.getLs_CircularProductos().getP();
                    boolean eliminar = false;
                    if (producto != null) {
                        NodoProductos temp = producto;
                        do {
                            if (temp.getPrecio() > precioMaximo) {
                                eliminar = true;
                                break;
                            }
                            temp = temp.getSig();
                        } while (temp != producto);
                    }
                    if (eliminar) {
                        if (anterior == null) { 
                            feria.getLs_NormalPuestos().setP(actual.getSig());
                        } else {
                            anterior.setSig(actual.getSig());
                        }
                    } else {
                        anterior = actual;
                    }

                    actual = actual.getSig();
                }
            }
            feria = feria.getSig();
        }
    }
}