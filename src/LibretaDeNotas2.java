import java.util.*;

public class LibretaDeNotas2 {

        public static void main(String[] args) {

            Map<String, Double> libreta = new HashMap<>();
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese cuantos alumnos son: ");
            int alumnos = sc.nextInt();

            for (int i = 0; i < alumnos; i++) {
                System.out.println("Ingrese el nombre del alumno: ");
                String nombre = sc.next();
                System.out.println("Ingrese la cantidad de notas para el alumno " + nombre + ": ");
                int cantidadNotas = sc.nextInt();

                List<Integer> notas = new ArrayList<>();
                for (int j = 0; j < cantidadNotas; j++) {
                    int nota;
                    do {
                        System.out.println("Ingrese la nota " + (j + 1) + " del alumno " + nombre );
                        nota = sc.nextInt();
                        if (nota < 0 || nota > 10) {
                            System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                        }
                    } while (nota < 0 || nota > 10);
                    notas.add(nota);
                }
                System.out.println("Nota máxima de " + nombre + ": " + Collections.max(notas));
                System.out.println("Nota mínima de " + nombre + ": " + Collections.min(notas));

                //promedio
                double suma = 0;
                for (int nota : notas) {
                    suma += nota;
                }
                double promedio = suma / cantidadNotas;
                libreta.put(nombre, promedio);
            }

            //Menú
            int opcion = 0;
            do {
                System.out.println("\nSeleccione una opción: \n 1.-Mostrar el promedio de notas por alumno. \n 2.-Mostrar si la nota es APROBATORIA o REPROBATORIA. \n 3.-Mostrar si la nota está sobre o debajo del promedio del curso por alumno. \n 0.- Salir del menú.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1: // Mostrar promedio de notas de un estudiante
                        System.out.println("Ingrese el nombre del alumno:");
                        String nombre = sc.next();
                        if (libreta.containsKey(nombre)) {
                            System.out.println("Promedio de " + nombre + ": " + libreta.get(nombre));
                        } else {
                            System.out.println("Alumno no encontrado, ingrese nuevamente el nombre del alumno");
                        }
                        break;

                    case 2:
                        System.out.println("Ingrese el nombre del alumno:");
                        nombre = sc.next();
                        if (libreta.containsKey(nombre)) {
                            double promedio = libreta.get(nombre);
                            String resultado = (promedio >= 5) ? "APROBATORIO" : "REPROBATORIO";
                            System.out.println("El promedio es: " + resultado);
                        } else {
                            System.out.println("Alumno no encontrado, ingrese nuevamente el nombre del alumno");
                        }
                        break;

                    case 3:
                        double sumaPromedios = 0;
                        for (double promedio : libreta.values()) {
                            sumaPromedios += promedio;
                        }
                        double promedioCurso = sumaPromedios / libreta.size();


                        System.out.println("Ingrese el nombre del alumno:");
                        nombre = sc.next();
                        if (libreta.containsKey(nombre)) {
                            double promedio = libreta.get(nombre);
                            if (promedio > promedioCurso) {
                                System.out.println("La nota de " + nombre + " está por encima del promedio del curso.");
                            } else {
                                System.out.println("La nota de " + nombre + " no está por encima del promedio del curso.");
                            }
                        } else {
                            System.out.println("Alumno no encontrado, ingrese nuevamente el nombre del alumno");
                        }
                        break;

                    case 0:
                        System.out.println(".......Saliendo.......");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 0);

            sc.close();
        }
    }





