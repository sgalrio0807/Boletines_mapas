package Simulaciones.Ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionaActividadesGuarderia {
    static void main(String[] args) {
        RepositorioActividades repo = new RepositorioActividades();

        // Crear maestros
        Maestro m1 = new Maestro("Carlos", "Ruiz", "111A", "A1");
        Maestro m2 = new Maestro("Ana", "López", "222B", "B2");

        // Crear actividades
        Actividad a1 = new Actividad("Pintura Creativa", Lugar.AULA, LocalDate.of(2024, 5, 10), 4, 3, m1);
        Actividad a2 = new Actividad("Juegos de Agua", Lugar.PATIO, LocalDate.of(2024, 5, 12), 5, 2, m2);

        repo.agregarActividad(a1);
        repo.agregarActividad(a2);

        // Crear alumnos
        List<String> alergias1 = new ArrayList<>();
        alergias1.add("Gluten");

        Alumno al1 = new Alumno("Mario", "Gómez", 4, "111111111", alergias1, true, m1);
        Alumno al2 = new Alumno("Lucía", "Pérez", 4, "222222222", new ArrayList<>(), false, m1);
        Alumno al3 = new Alumno("Sofía", "López", 5, "333333333", new ArrayList<>(), true, m2);

        System.out.println("PRUEBA: AGREGAR ALUMNOS");

        try {
            repo.agregarAlumnoActividad("Pintura Creativa", LocalDate.of(2024, 5, 10), al1);
            repo.agregarAlumnoActividad("Pintura Creativa", LocalDate.of(2024, 5, 10), al2);

            // Este falla por edad incorrecta
            repo.agregarAlumnoActividad("Pintura Creativa", LocalDate.of(2024, 5, 10), al3);

        } catch (GuarderiaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("PRUEBA: COMPROBAR SI UN ALUMNO ESTÁ APUNTADO");

        try {
            boolean apuntado = repo.isAlumnoApuntado("Pintura Creativa", LocalDate.of(2024, 5, 10), al1);
            System.out.println("¿Mario está apuntado? " + apuntado);

            boolean apuntado2 = repo.isAlumnoApuntado("Pintura Creativa", LocalDate.of(2024, 5, 10), al3);
            System.out.println("¿Sofía está apuntada? " + apuntado2);

        } catch (GuarderiaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("PRUEBA: ALUMNADO CON ALERGIAS");

        try {
            List<Alumno> alergicos = repo.getAlumnadoConAlergias("Pintura Creativa", LocalDate.of(2024, 5, 10));

            if (alergicos.size() == 0) {
                System.out.println("No hay alumnado con alergias");
            } else {
                for (Alumno a : alergicos) {
                    System.out.println(a.getNombre() + " " + a.getApellidos() + " - Alergias: " + a.getAlergias());
                }
            }

        } catch (GuarderiaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("PRUEBA: LISTA DE ACTIVIDADES ORDENADAS POR FECHA");

        List<Actividad> listaOrdenada = repo.getListaActividades();

        for (Actividad act : listaOrdenada) {
            System.out.println(act.getNombre() + " - " + act.getFecha());
        }
    }
}
