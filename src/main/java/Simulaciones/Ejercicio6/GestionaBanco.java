package Simulaciones.Ejercicio6;

import java.time.LocalDate;

public class GestionaBanco {
    static void main(String[] args) {
        BancoAlimentos banco = new BancoAlimentos();

        try {
            CentroLogistico c1 = new CentroLogistico(1, "Centro Norte", "Madrid", 12);
            CentroLogistico c2 = new CentroLogistico(2, "Centro Sur", "Sevilla", 8);

            banco.agregarCentro(c1);
            banco.agregarCentro(c2);

            // Intento de centro duplicado
            try {
                banco.agregarCentro(new CentroLogistico(1, "Duplicado", "Madrid", 5));
            } catch (BancoException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            Trabajador t1 = new Trabajador("Carlos Ruiz", "111A", LocalDate.of(1990, 5, 10), TipoTrabajador.ASALARIADO, 1);
            Trabajador t2 = new Trabajador("Ana López", "222B", LocalDate.of(1985, 3, 20), TipoTrabajador.VOLUNTARIO, 1);
            Trabajador t3 = new Trabajador("Luis Pérez", "333C", LocalDate.of(2000, 1, 15), TipoTrabajador.ASALARIADO, 2);

            banco.agregarTrabajador(t1);
            banco.agregarTrabajador(t2);
            banco.agregarTrabajador(t3);

            // Intento de trabajador duplicado
            try {
                banco.agregarTrabajador(t1);
            } catch (BancoException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            System.out.println("Datos del centro 1:");
            System.out.println(banco.obtenerCentro(1));

            System.out.println("Trabajadores del centro 1:");
            for (Trabajador t : banco.obtenerCentro(1).getTrabajadores()) {
                System.out.println(t);
            }

            System.out.println("Buscar trabajador por DNI 333C:");
            System.out.println(banco.obtenerTrabajador("333C"));

        } catch (BancoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
