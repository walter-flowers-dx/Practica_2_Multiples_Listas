package Ejercicio_8;

public class Principal2 {

    public static void main(String[] args) {
        // LISTA DE INSCRITOS
        LS_NormalInscritos lsni1 = new LS_NormalInscritos();
        lsni1.adiFinal("Ana", 4123412);
        lsni1.adiFinal("Luis", 5182934);
        lsni1.adiFinal("Carmen", 7638492);

        LS_NormalInscritos lsni2 = new LS_NormalInscritos();
        lsni2.adiFinal("Lucia", 1293847);
        lsni2.adiFinal("Andres", 4392871);

        LS_NormalInscritos lsni3 = new LS_NormalInscritos();
        lsni3.adiFinal("Oscar", 4273189);
        lsni3.adiFinal("Andrea", 7834219);

        // LISTA DE PARALELOS
        LS_NormalParalelos lsnp1 = new LS_NormalParalelos();
        lsnp1.adiFinal("Marcelo", "A", lsni1);
        lsnp1.adiFinal("Carmen", "B", lsni2);
        lsnp1.adiFinal("Carlos", "C", lsni3);

        // LISTA DE MATERIAS
        LS_NormalMaterias lsnm1 = new LS_NormalMaterias();
        lsnm1.adiFinal("INF-121", "Programacion 2", lsnp1);

        System.out.println("Lista completa de materias:");
        lsnm1.mostrar();
        
        System.out.println("\na) Eliminar el paralelo X de la materia Z y mover inscritos:");
        moverInscritos(lsnm1, "INF-121", "B");
        lsnm1.mostrar();

        System.out.println("\nb) Mostrar la sigla de la materia con el paralelo con más inscritos:");
        String materiaMaxInscritos = obtenerMateriaMayorInscritos(lsnm1);
        System.out.println("Materia con más inscritos: " + materiaMaxInscritos);

        System.out.println("\nc) Crear un nuevo paralelo si los inscritos son mayores a X:");
        crearParaleloSiExcede(lsnm1, "INF-121", 3, "Pedro", "D");
        lsnm1.mostrar();
    }

    // a.
    public static void moverInscritos(LS_NormalMaterias lsnm, String siglaMateria, String paraleloEliminar) {
        NodoMaterias materia = lsnm.getP();
        while (materia != null) {
            if (materia.getSigla().equals(siglaMateria)) {
                LS_NormalParalelos paralelos = materia.getLs_NormalParalelos();
                NodoParalelos nodoParalelo = paralelos.getP();
                NodoParalelos menorParalelo = null;
                NodoParalelos paraleloEliminarNodo = null;

                int menorCantidad = Integer.MAX_VALUE;
                
                while (nodoParalelo != null) {
                    int inscritos = nodoParalelo.getLs_NormalInscritos().nroNodos();
                    if (nodoParalelo.getParalelo().equals(paraleloEliminar)) {
                        paraleloEliminarNodo = nodoParalelo;
                    } else if (inscritos < menorCantidad) {
                        menorCantidad = inscritos;
                        menorParalelo = nodoParalelo;
                    }
                    nodoParalelo = nodoParalelo.getSig();
                }

                if (paraleloEliminarNodo != null && menorParalelo != null) {
                    LS_NormalInscritos inscritosMover = paraleloEliminarNodo.getLs_NormalInscritos();
                    NodoInscritos nodoInscrito = inscritosMover.getP();
                    while (nodoInscrito != null) {
                        menorParalelo.getLs_NormalInscritos().adiFinal(nodoInscrito.getNombre(), nodoInscrito.getCi());
                        nodoInscrito = nodoInscrito.getSig();
                    }
                    paralelos.eliminarParalelo(paraleloEliminar);
                }
                return; 
            }
            materia = materia.getSig();
        }
    }


    // b.
    public static String obtenerMateriaMayorInscritos(LS_NormalMaterias lsnm) {
        NodoMaterias materia = lsnm.getP();
        String materiaMayor = null;
        int maxInscritos = 0;

        while (materia != null) {
            NodoParalelos paralelo = materia.getLs_NormalParalelos().getP();
            while (paralelo != null) {
                int inscritos = paralelo.getLs_NormalInscritos().nroNodos();
                if (inscritos > maxInscritos) {
                    maxInscritos = inscritos;
                    materiaMayor = materia.getSigla();
                }
                paralelo = paralelo.getSig();
            }
            materia = materia.getSig();
        }
        return materiaMayor;
    }

    // c.
    public static void crearParaleloSiExcede(LS_NormalMaterias lsnm, String siglaMateria, int limite, String docente, String paraleloNuevo) {
        NodoMaterias materia = lsnm.getP();
        while (materia != null) {
            if (materia.getSigla().equals(siglaMateria)) {
                LS_NormalParalelos paralelos = materia.getLs_NormalParalelos();
                NodoParalelos nodoParalelo = paralelos.getP();

                while (nodoParalelo != null) {
                    if (nodoParalelo.getLs_NormalInscritos().nroNodos() > limite) {
                        LS_NormalInscritos nuevosInscritos = new LS_NormalInscritos();
                        paralelos.adiFinal(docente, paraleloNuevo, nuevosInscritos);
                        return;
                    }
                    nodoParalelo = nodoParalelo.getSig();
                }
            }
            materia = materia.getSig();
        }
    }
}
