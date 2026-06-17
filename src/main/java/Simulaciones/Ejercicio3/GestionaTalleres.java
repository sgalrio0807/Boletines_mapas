package Simulaciones.Ejercicio3;

public class GestionaTalleres {
    static void main(String[] args) {
        Academia academia = new Academia();

        Taller t1 = new Taller("Robótica", 10, 3);
        Taller t2 = new Taller("Pintura", 6, 2);

        academia.añadirTaller(t1);
        academia.añadirTaller(t2);

        Alumno a1 = new Alumno("Carlos", 12, "111");
        Alumno a2 = new Alumno("Ana", 9, "222");
        Alumno a3 = new Alumno("Luis", 7, "333");
        Alumno a4 = new Alumno("Marta", 5, "444");

        try {
            academia.inscribirAlumno("Robótica", a1);
            academia.inscribirAlumno("Robótica", a2);
            academia.inscribirAlumno("Pintura", a3);

            academia.inscribirAlumno("Pintura", a4); // edad insuficiente

        } catch (InscripcionException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nAlumnos en Robótica:");
        academia.mostrarAlumnosDeTaller("Robótica");

        System.out.println("\nTalleres ordenados por número de alumnos:");
        for (Taller t : academia.talleresPorNumeroAlumnos()) {
            System.out.println(t.getNombre() + " → " + t.getAlumnos().size() + " alumnos");
        }

        System.out.println("\nAlumnos mayores de 10 en Robótica:");
        for (Alumno a : academia.alumnosMayoresDe("Robótica", 10)) {
            System.out.println(a);
        }
    }
}
