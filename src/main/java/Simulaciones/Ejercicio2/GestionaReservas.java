package Simulaciones.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionaReservas {
    static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Carlos Ruiz", "carlos@mail.com"));
        usuarios.add(new Usuario("Ana López", "ana@mail.com"));
        usuarios.add(new Usuario("Luis Pérez", "luis@mail.com"));
        usuarios.add(new Usuario("Marta Díaz", "marta@mail.com"));

        RepositorioEventos repo = new RepositorioEventos();

        try {
            repo.agregarEvento(new Evento("Concierto Rock", LocalDate.now().plusDays(5), "Madrid"));
            repo.agregarEvento(new Evento("Teatro Comedia", LocalDate.now().plusDays(10), "Sevilla"));

            repo.agregarReserva("carlos@mail.com", "Concierto Rock", LocalDate.now().plusDays(5), usuarios);
            repo.agregarReserva("ana@mail.com", "Concierto Rock", LocalDate.now().plusDays(5), usuarios);

        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Intentando agregar evento duplicado:");
        try {
            repo.agregarEvento(new Evento("Concierto Rock", LocalDate.now().plusDays(5), "Madrid"));
        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Modificando usuario de reserva existente:");
        try {
            repo.modificarReserva(1, "Concierto Rock", LocalDate.now().plusDays(5), usuarios.get(3));
            System.out.println("Reserva modificada correctamente");
        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Intentando modificar reserva inexistente:");
        try {
            repo.modificarReserva(999, "Concierto Rock", LocalDate.now().plusDays(5), usuarios.get(2));
        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
