package Ejercicio_10;
public class Principal_2 {
    public static void main(String[] args) {
        LS_NormalCulti listaCultivos = new LS_NormalCulti();
        listaCultivos.adiFinal(1, "Cereal", "Trigo");
        listaCultivos.adiFinal(2, "Fruta", "Manzana");
        listaCultivos.adiFinal(3, "Leguminosa", "Soya");
        listaCultivos.adiFinal(4, "Verdura", "Zanahoria");
        listaCultivos.adiFinal(5, "Tubérculo", "Papa");
        
        LD_NormalDep listaDepartamentos = new LD_NormalDep();
        
        String[] nombresDepartamentos = {
            "La Paz", "Cochabamba", "Santa Cruz", "Oruro", "Potosí",
            "Tarija", "Chuquisaca", "Beni", "Pando"
        };

        for (int i = 0; i < 9; i++) {
            LD_NormalProductora productoras = new LD_NormalProductora();
            
            for (int j = 1; j <= 2; j++) {
                LS_NormalPro listaProduccion = new LS_NormalPro();
                
                listaProduccion.adiFinal(1, 10 * j, 5 * j);
                listaProduccion.adiFinal(2, 8 * j, 4 * j);
                listaProduccion.adiFinal(3, 6 * j, 3 * j);
                
                LS_NormalTec listaTecnologia = new LS_NormalTec();
                listaTecnologia.adiFinal("Tractor", "Equipamiento agrícola");
                listaTecnologia.adiFinal("Riego", "Sistema de riego automatizado");
                productoras.adiFinal("Zona Productora " + j, listaProduccion, listaTecnologia);
            }
            listaDepartamentos.adiFinal(nombresDepartamentos[i], productoras);
        }

        System.out.println("Lista de Departamentos con Zonas Productoras:");
        listaDepartamentos.mostrar();

        System.out.println("\n A: Departamento con mayor producción total");
        mostrarDepartamentoMayorProduccion(listaDepartamentos);

        System.out.println("\n B: Tecnología más común en las zonas productoras");
        mostrarTecnologiaMasComun(listaDepartamentos);

        System.out.println("\n C: Total de hectáreas cultivadas por tipo de cultivo");
        mostrarHectareasPorCultivo(listaCultivos, listaDepartamentos);
    }

    // a.
    public static void mostrarDepartamentoMayorProduccion(LD_NormalDep listaDepartamentos) {
        NodoDep departamentoActual = listaDepartamentos.getP();
        String departamentoMayor = "";
        double maxProduccion = 0;

        while (departamentoActual != null) {
            double produccionTotal = 0;
            NodoProductora productoraActual = departamentoActual.getLPROD().getP();

            while (productoraActual != null) {
                NodoPro produccionActual = productoraActual.getLP().getP();

                while (produccionActual != null) {
                    produccionTotal += produccionActual.getToneladas();
                    produccionActual = produccionActual.getSig();
                }

                productoraActual = productoraActual.getSig();
            }

            if (produccionTotal > maxProduccion) {
                maxProduccion = produccionTotal;
                departamentoMayor = departamentoActual.getNombre();
            }

            departamentoActual = departamentoActual.getSig();
        }

        System.out.println("Departamento con mayor producción: " + departamentoMayor + " (" + maxProduccion + " toneladas)");
    }
    
    // b.
    public static void mostrarTecnologiaMasComun(LD_NormalDep listaDepartamentos) {
        String[] tecnologias = new String[100]; 
        int[] conteo = new int[100]; 
        int totalTecnologias = 0; 

        NodoDep departamentoActual = listaDepartamentos.getP();
        while (departamentoActual != null) {
            NodoProductora productoraActual = departamentoActual.getLPROD().getP();

            while (productoraActual != null) {
                NodoTec tecnologiaActual = productoraActual.getLT().getP();

                while (tecnologiaActual != null) {
                    String nombreTec = tecnologiaActual.getNombre();
                    boolean encontrada = false;
                    for (int i = 0; i < totalTecnologias; i++) {
                        if (tecnologias[i].equals(nombreTec)) {
                            conteo[i]++;
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        tecnologias[totalTecnologias] = nombreTec;
                        conteo[totalTecnologias] = 1;
                        totalTecnologias++;
                    }

                    tecnologiaActual = tecnologiaActual.getSig();
                }

                productoraActual = productoraActual.getSig();
            }

            departamentoActual = departamentoActual.getSig();
        }
        String tecnologiaMasComun = "";
        int maxConteo = 0;
        for (int i = 0; i < totalTecnologias; i++) {
            if (conteo[i] > maxConteo) {
                maxConteo = conteo[i];
                tecnologiaMasComun = tecnologias[i];
            }
        }

        System.out.println("Tecnología más común: " + tecnologiaMasComun + " (" + maxConteo + " usos)");
    }


    // c.
    public static void mostrarHectareasPorCultivo(LS_NormalCulti listaCultivos, LD_NormalDep listaDepartamentos) {
        int[] idsCultivos = new int[100]; 
        double[] hectareasTotales = new double[100];
        int totalCultivos = 0; 

        NodoDep departamentoActual = listaDepartamentos.getP();
        while (departamentoActual != null) {
            NodoProductora productoraActual = departamentoActual.getLPROD().getP();

            while (productoraActual != null) {
                NodoPro produccionActual = productoraActual.getLP().getP();

                while (produccionActual != null) {
                    int idCultivo = produccionActual.getIdCultivo();
                    double hectareas = produccionActual.getHectareas();
                    boolean encontrado = false;
                    for (int i = 0; i < totalCultivos; i++) {
                        if (idsCultivos[i] == idCultivo) {
                            hectareasTotales[i] += hectareas;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        idsCultivos[totalCultivos] = idCultivo;
                        hectareasTotales[totalCultivos] = hectareas;
                        totalCultivos++;
                    }

                    produccionActual = produccionActual.getSig();
                }

                productoraActual = productoraActual.getSig();
            }

            departamentoActual = departamentoActual.getSig();
        }
        NodoCulti cultivoActual = listaCultivos.getP();
        while (cultivoActual != null) {
            int idCultivo = cultivoActual.getIdCultivo();
            String nombreCultivo = cultivoActual.getNombre();
            double hectareas = 0;
            for (int i = 0; i < totalCultivos; i++) {
                if (idsCultivos[i] == idCultivo) {
                    hectareas = hectareasTotales[i];
                    break;
                }
            }

            System.out.println(nombreCultivo + ": " + hectareas + " hectáreas");
            cultivoActual = cultivoActual.getSig();
        }
    }

}
