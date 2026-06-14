package BoletinOrdenaciones2.Ejercicio3;

import java.time.LocalDate;

public class GestionaReservas {
    static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();

        Usuario u1 = new Usuario("Carlos Ruiz", "carlos@mail.com");
        Usuario u2 = new Usuario("Ana López", "ana@mail.com");
        Usuario u3 = new Usuario("Luis Pérez", "luis@mail.com");
        Usuario u4 = new Usuario("Marta Díaz", "marta@mail.com");

        sistema.altaUsuario(u1);
        sistema.altaUsuario(u2);
        sistema.altaUsuario(u3);
        sistema.altaUsuario(u4);

        try {
            Evento e1 = new Evento("Concierto Rock", LocalDate.now().plusDays(5), "Madrid");
            Evento e2 = new Evento("Teatro Comedia", LocalDate.now().plusDays(10), "Sevilla");

            sistema.altaEvento(e1);
            sistema.altaEvento(e2);

            sistema.reservar("carlos@mail.com", e1.getIdEvento());
            sistema.reservar("ana@mail.com", e1.getIdEvento());
            sistema.reservar("carlos@mail.com", e2.getIdEvento());

            sistema.cancelarReserva("carlos@mail.com", 999);

        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            sistema.cancelarReserva("carlos@mail.com", 1);
        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("\nReservas de Carlos ordenadas:");
            for (Reserva r : sistema.reservasUsuarioOrdenadas("carlos@mail.com")) {
                System.out.println(r);
            }
        } catch (ReservaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
