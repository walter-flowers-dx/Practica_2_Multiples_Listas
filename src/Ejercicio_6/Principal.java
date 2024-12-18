package Ejercicio_6;

public class Principal {

    public static void main(String[] args) {
        // LISTA DE MATERIAS
        LS_NormalMateria lsnm1 = new LS_NormalMateria();
        Materia m1 = new Materia("INF-121", "Programacion 2");
        Materia m2 = new Materia("INF-131", "Programacion 3");
        Materia m3 = new Materia("INF-255", "Marketing");
        lsnm1.adiFinal(m1, 76, 51, 10, 5);
        lsnm1.adiFinal(m2, 21, 80, 90, 6);
        lsnm1.adiFinal(m3, 34, 51, 25, 9);
        System.out.println("Lista de materias 1.- ");
        lsnm1.mostrar();
        
        LS_NormalMateria lsnm2 = new LS_NormalMateria();
        Materia m4 = new Materia("INF-115", "Calculo 1");
        Materia m5 = new Materia("INF-121", "Programacion 2");
        Materia m6 = new Materia("INF-254", "Metodos Numericos");
        Materia m7 = new Materia("INF-134", "Estadistica 2");
        Materia m8 = new Materia("INF-124", "Algebra Lineal");
        lsnm2.adiFinal(m4, 34, 56, 90, 4);
        lsnm2.adiFinal(m5, 51, 51, 60, 0);
        lsnm2.adiFinal(m6, 40, 70, 65, 8);
        lsnm2.adiFinal(m7, 80, 100, 100, 0);
        lsnm2.adiFinal(m8, 21, 51, 61, 4);
        System.out.println("\nLista de materias 2.- ");
        lsnm2.mostrar();
        
        LS_NormalMateria lsnm3 = new LS_NormalMateria();
        Materia m9 = new Materia("INF-123", "Estadistica 1");
        Materia m10 = new Materia("INF-124", "Algebra Lineal");
        Materia m11 = new Materia("INF-126", "Calculo 2");
        Materia m12 = new Materia("INF-132", "Electronica");
        Materia m13 = new Materia("INF-113", "Programcion web 1");
        Materia m14 = new Materia("INF-121", "Programacion 2");
        lsnm3.adiFinal(m9, 67, 12, 83, 94);
        lsnm3.adiFinal(m10, 45, 3, 76, 0);
        lsnm3.adiFinal(m11, 58, 99, 34, 40);
        lsnm3.adiFinal(m12, 73, 18, 47, 0);
        lsnm3.adiFinal(m13, 88, 62, 20, 5);
        lsnm3.adiFinal(m14, 14, 30, 81, 0);
        System.out.println("\nLista de materias 3.- ");
        lsnm3.mostrar();
        
        LS_NormalEstudiantes lsne1 = new LS_NormalEstudiantes();
        lsne1.adiFinal("Juan", lsnm1, "3ro", "I/2024");
        lsne1.adiFinal("Ana", lsnm2, "5to", "II/2024");
        lsne1.adiFinal("Pedro", lsnm3, "6to", "I/2023");
        lsne1.adiFinal("Danna", lsnm2, "1ro", "I/2023");
        lsne1.adiFinal("Karla", lsnm1, "2do", "II/2022");
        System.out.println("\nLista de Estudiantes: ");
        lsne1.mostrar();
        
        System.out.println("\na) Mostrar los estudiantes que aprobaron sin auxiliatura la materia Y");
        mostrarAprobadosSinAux(lsne1, "Programacion 2");
        
        System.out.println("\nb) Mostrar el estudiante(s) que obtuvo la nota mayor en la materia 'INF-121'");
        mostrarNotaMayor(lsne1, "INF-121");
        
        System.out.println("\nc) Mostrar el promedio de aprobacion de cada estudiante");
        mostrarPromedioPorEstudiante(lsne1);
    }
    
    // a.
    public static void mostrarAprobadosSinAux(LS_NormalEstudiantes lsne, String materiaNombre) {
        NodoEstudiantes estudiante = lsne.getP();
        while (estudiante != null) {
            NodoMateria materia = estudiante.getLs_NormalMateria().getP();
            while (materia != null) {
                if (materia.getQ().getNombre().equals(materiaNombre) &&
                    (materia.getParcial1() + materia.getParcial2() + materia.getExFinal() >= 51) &&
                    materia.getNotaAux() == 0) {
                    System.out.println(estudiante.getNombreEstudiante());
                }
                materia = materia.getSig();
            }
            estudiante = estudiante.getSig();
        }
    }
    
    // b.
    public static void mostrarNotaMayor(LS_NormalEstudiantes lista, String siglaMateria) {
    	NodoEstudiantes temp = lista.getP();
        String estudianteMaxNota = "";
        double maxNota = -1;

        while (temp != null) {
            NodoMateria materiaTemp = temp.getLs_NormalMateria().getP();
            while (materiaTemp != null) {
                if (materiaTemp.getQ().getSigla().equals(siglaMateria)) {
                    double promedio = (materiaTemp.getParcial1() + materiaTemp.getParcial2() + materiaTemp.getExFinal()) / 3.0;
                    if (promedio > maxNota) {
                        maxNota = promedio;
                        estudianteMaxNota = temp.getNombreEstudiante();
                    }
                }
                materiaTemp = materiaTemp.getSig();
            }
            temp = temp.getSig();
        }

        if (maxNota != -1) {
            System.out.println("Estudiante: " + estudianteMaxNota + " con promedio de " + maxNota);
        } else {
            System.out.println("No se encontró la materia '" + siglaMateria + "'.");
        }
    }
    
    // c.
    public static void mostrarPromedioPorEstudiante(LS_NormalEstudiantes lista) {
    	NodoEstudiantes temp = lista.getP();

        while (temp != null) {
            NodoMateria materiaTemp = temp.getLs_NormalMateria().getP();
            double sumaPromedios = 0;
            int materiasAprobadas = 0;

            while (materiaTemp != null) {
                double promedio = (materiaTemp.getParcial1() + materiaTemp.getParcial2() + materiaTemp.getExFinal()) / 3.0;
                if (promedio > 51) {
                    sumaPromedios += promedio;
                    materiasAprobadas++;
                }
                materiaTemp = materiaTemp.getSig();
            }

            if (materiasAprobadas > 0) {
                double promedioFinal = sumaPromedios / materiasAprobadas;
                System.out.println("Estudiante: " + temp.getNombreEstudiante() + " - Promedio de aprobación: " + promedioFinal);
            } else {
                System.out.println("Estudiante: " + temp.getNombreEstudiante() + " - No aprobó ninguna materia.");
            }
            temp = temp.getSig();
        }
    }
}
