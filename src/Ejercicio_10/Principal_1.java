package Ejercicio_10;

public class Principal_1 {

    public static void main(String[] args) {
        // Crear lista de cultivos
        LS_NormalCulti listaCultivos = new LS_NormalCulti();
        listaCultivos.adiFinal(1, "Cereal", "Trigo");
        listaCultivos.adiFinal(2, "Fruta", "Manzana");
        listaCultivos.adiFinal(3, "Leguminosa", "Soya");
        listaCultivos.adiFinal(4, "Verdura", "Zanahoria");
        listaCultivos.adiFinal(5, "Tubérculo", "Papa");
        
        // Crear lista de departamentos
        LD_NormalDep listaDepartamentos = new LD_NormalDep();

        // Crear 9 departamentos, cada uno con 2 zonas productoras
        String[] nombresDepartamentos = {
            "La Paz", "Cochabamba", "Santa Cruz", "Oruro", "Potosí",
            "Tarija", "Chuquisaca", "Beni", "Pando"
        };

        for (int i = 0; i < 9; i++) {
            LD_NormalProductora productoras = new LD_NormalProductora();
            // Crear 2 zonas productoras para cada departamento
            for (int j = 1; j <= 2; j++) {

                // Crear lista de producciones para cada productora
                LS_NormalPro listaProduccion = new LS_NormalPro();
                
                // Agregar 4 producciones
                for (int k = 1; k <= 4; k++) {
                    listaProduccion.adiFinal(k, 10*k, 5*k );
                }

                // Crear lista de tecnología para cada productora
                LS_NormalTec listaTecnologia = new LS_NormalTec();
                
                // Agregar 3 tecnologías
                for (int l = 1; l <= 3; l++) {
                    listaTecnologia.adiFinal("Tecnología " + l, "Descripción de Tecnología " + l);
                }
                productoras.adiFinal("Productora " + j + " de " + nombresDepartamentos[i], listaProduccion, listaTecnologia);
            }
            
            listaDepartamentos.adiFinal(nombresDepartamentos[i], productoras);
            // Añadir el departamento a la lista de departamentos
        }

     // Mostrando resultados
        System.out.println("----- CULTIVOS -----");
        listaCultivos.mostrar();
        System.out.println("\n----- DEPARTAMENTOS Y PRODUCTORAS -----");
        listaDepartamentos.mostrar();

        // Resolviendo Incisos

        System.out.println("\na)");
        obtenerTotalToneladasPorCultivo(listaCultivos, listaDepartamentos);

        System.out.println("\nb)");
        determinarMayorHectareasCultivadas(listaDepartamentos);
    }
 // Función para obtener el total de toneladas por tipo de cultivo
    public static void obtenerTotalToneladasPorCultivo(LS_NormalCulti listaCultivos, LD_NormalDep listaDepartamentos) {
        NodoCulti nodoCultivo = listaCultivos.getP();
        System.out.println("\nTOTAL DE TONELADAS POR TIPO DE CULTIVO EN CADA DEPARTAMENTO:");
        while (nodoCultivo != null) {
            String nombreCultivo = nodoCultivo.getNombre();
            int idCultivo = nodoCultivo.getIdCultivo();
            NodoDep nodoDepartamento = listaDepartamentos.getP();
            System.out.println("Cultivo: " + nombreCultivo);

            while (nodoDepartamento != null) {
                double totalToneladas = 0;
                NodoProductora nodoProductora = nodoDepartamento.getLPROD().getP();
                while (nodoProductora != null) {
                    NodoPro nodoProduccion = nodoProductora.getLP().getP();
                    while (nodoProduccion != null) {
                        if (nodoProduccion.getIdCultivo() == idCultivo) {
                            totalToneladas += nodoProduccion.getToneladas();
                        }
                        nodoProduccion = nodoProduccion.getSig();
                    }
                    nodoProductora = nodoProductora.getSig();
                }
                System.out.println("  Departamento " + nodoDepartamento.getNombre() + ": " + totalToneladas + " toneladas");
                nodoDepartamento = nodoDepartamento.getSig();
            }
            nodoCultivo = nodoCultivo.getSig();
        }
    }

    // Función para determinar el departamento con mayor cantidad de hectáreas cultivadas
    public static void determinarMayorHectareasCultivadas(LD_NormalDep listaDepartamentos) {
        NodoDep nodoDepartamento = listaDepartamentos.getP();
        String departamentoMayor = "";
        double maxHectareas = 0;

        while (nodoDepartamento != null) {
            double totalHectareas = 0;
            NodoProductora nodoProductora = nodoDepartamento.getLPROD().getP();
            while (nodoProductora != null) {
                NodoPro nodoProduccion = nodoProductora.getLP().getP();
                while (nodoProduccion != null) {
                    totalHectareas += nodoProduccion.getHectareas();
                    nodoProduccion = nodoProduccion.getSig();
                }
                nodoProductora = nodoProductora.getSig();
            }
            if (totalHectareas > maxHectareas) {
                maxHectareas = totalHectareas;
                departamentoMayor = nodoDepartamento.getNombre();
            }
            nodoDepartamento = nodoDepartamento.getSig();
        }
        System.out.println("\nDEPARTAMENTO CON MAYOR CANTIDAD DE HECTÁREAS CULTIVADAS:");
        System.out.println("Departamento: " + departamentoMayor + " con " + maxHectareas + " hectáreas.");
    }
    
}