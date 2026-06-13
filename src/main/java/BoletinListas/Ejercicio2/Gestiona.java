package BoletinListas.Ejercicio2;

public class Gestiona {
    static void main(String[] args) {
        try {
            Equipo futbol = new Equipo("Futbol");
            Equipo baloncesto = new Equipo("Baloncesto");

            Alumno a1 = new Alumno("Sergio", "111A");
            Alumno a2 = new Alumno("Ana", "222B");
            Alumno a3 = new Alumno("Luis", "333C");
            Alumno a4 = new Alumno("Ana", "222B");

            futbol.addAlumno(a1);
            futbol.addAlumno(a2);

            baloncesto.addAlumno(a2);
            baloncesto.addAlumno(a3);

            System.out.println("Alumnos fútbol:");
            futbol.mostrarAlumnos();

            System.out.println("Alumnos baloncesto:");
            baloncesto.mostrarAlumnos();

            System.out.println("Unión:");
            Equipo union = futbol.union(baloncesto);
            union.mostrarAlumnos();

            System.out.println("Intersección:");
            Equipo inter = futbol.interseccion(baloncesto);
            inter.mostrarAlumnos();

            System.out.println("¿Pertenece Sergio al fútbol?");
            System.out.println(futbol.pertenece(a1));

        } catch (DeportivosException e) {
            System.out.println(e.getMessage());
        }
    }
}
