package Ejercicio_8;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LISTA DE INSCRITOS
        LS_NormalInscritos lsni1 = new LS_NormalInscritos();
        lsni1.adiFinal("Ana", 4123412);
        lsni1.adiFinal("Luis", 5182934);
        lsni1.adiFinal("Carmen", 7638492);
        lsni1.adiFinal("Javier", 8257391);
        lsni1.adiFinal("Sofia", 1293847);
        lsni1.adiFinal("Miguel", 9842319);
        lsni1.adiFinal("Valeria", 3274819);
        lsni1.adiFinal("Diego", 7312948);
        lsni1.adiFinal("Esteban", 8923742);

        LS_NormalInscritos lsni2 = new LS_NormalInscritos();
        lsni2.adiFinal("Lucia", 1293847);
        lsni2.adiFinal("Andres", 4392871);
        lsni2.adiFinal("Valeria", 3274819);

        LS_NormalInscritos lsni3 = new LS_NormalInscritos();
        lsni3.adiFinal("Oscar", 4273189);
        lsni3.adiFinal("Andrea", 7834219);
        lsni3.adiFinal("Miguel", 9842319);
        lsni3.adiFinal("Isabel", 6324789);
        lsni3.adiFinal("Hector", 2384719);
        lsni3.adiFinal("Ana", 4123412);

        // LISTA DE PARALELOS
        LS_NormalParalelos lsnp1 = new LS_NormalParalelos();
        lsnp1.adiFinal("Marcelo", "A", lsni1);
        lsnp1.adiFinal("Carmen", "B", lsni2);
        lsnp1.adiFinal("Marisol", "C", lsni3);
        lsnp1.adiFinal("Carlos", "D", lsni2);

        LS_NormalParalelos lsnp2 = new LS_NormalParalelos();
        lsnp2.adiFinal("Jhony", "A", lsni1);
        lsnp2.adiFinal("Rudy", "B", lsni2);

        LS_NormalParalelos lsnp3 = new LS_NormalParalelos();
        lsnp3.adiFinal("Moises", "A", lsni1);
        lsnp3.adiFinal("Celia", "B", lsni2);
        lsnp3.adiFinal("Tatiana", "C", lsni3);
        lsnp3.adiFinal("Daniela", "D", lsni2);
        lsnp3.adiFinal("Carlos", "E", lsni2);

        // LISTA DE MATERIAS
        LS_NormalMaterias lsnm1 = new LS_NormalMaterias();
        lsnm1.adiFinal("INF-121", "Programacion 2", lsnp1);
        lsnm1.adiFinal("INF-131", "Programacion 3", lsnp2);
        lsnm1.adiFinal("INF-134", "Estadistica 2", lsnp3);
        lsnm1.adiFinal("SIS-255", "Marketing", lsnp2);
        lsnm1.adiFinal("SIS-254", "Metodos Numericos", lsnp3);

        System.out.println("Lista completa de materias:");
        lsnm1.mostrar();

        System.out.println("\na) Eliminar el paralelo X de la materia Z y mover a sus inscritos al paralelo con menos inscritos correspondiente a la misma materia");
        
        System.out.println("\nb) Mostrar la sigla de la materia en la cual se encuentra el paralelo con la mayor cantidad de inscritos");
        
        System.out.println("\nc) Crear un nuevo paralelo si la cantidad de inscritos es mayor a X, el nuevo paralelo debe ser introducido por teclado al igual que el docente");
    }

}