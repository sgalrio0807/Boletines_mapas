package BoletinOrdenaciones.Ejercicio2;

import java.time.LocalDate;

public class Gestiona {
    static void main(String[] args) {
        Historial h = new Historial();

        try {
            h.agregarPagina("google.com", LocalDate.of(2023, 5, 10));
            h.agregarPagina("google.com");
            h.agregarPagina("youtube.com", LocalDate.of(2023, 4, 2));
            h.agregarPagina("youtube.com");

            h.agregarPagina("google.com", LocalDate.of(2030, 1, 1));

        } catch (HistorialException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Historial completo:");
        h.mostrarHistorial();

        System.out.println("Historial para google.com:");
        h.historialPorUrl("google.com");

        System.out.println("Historial ordenado por URL:");
        for (PaginaWeb p : h.ordenarPorUrl()) {
            System.out.println(p.getUrl() + " - " + p.getFecha());
        }
    }
}
