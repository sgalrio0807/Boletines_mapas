package Simulaciones.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioEventos {

    private ArrayList<Evento> eventos;

    public RepositorioEventos() {
        eventos = new ArrayList<>();
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento e) throws ReservaException {

        if (e.getFechaEvento().isBefore(LocalDate.now())) {
            throw new ReservaException("No se pueden registrar eventos pasados");
        }

        for (Evento x : eventos) {
            if (x.equals(e)) {
                throw new ReservaException("Evento duplicado");
            }
        }

        eventos.add(e);
        ordenarEventos();
    }

    private void ordenarEventos() {
        for (int i = 0; i < eventos.size() - 1; i++) {
            for (int j = i + 1; j < eventos.size(); j++) {

                Evento a = eventos.get(i);
                Evento b = eventos.get(j);

                boolean cambiar = false;

                if (a.getFechaEvento().isAfter(b.getFechaEvento())) {
                    cambiar = true;
                } else if (a.getFechaEvento().equals(b.getFechaEvento()) &&
                        a.getNombreEvento().compareToIgnoreCase(b.getNombreEvento()) > 0) {
                    cambiar = true;
                }

                if (cambiar) {
                    Evento aux = eventos.get(i);
                    eventos.set(i, eventos.get(j));
                    eventos.set(j, aux);
                }
            }
        }
    }

    public Evento buscarEvento(String nombre, LocalDate fecha) {
        Evento encontrado = null;

        for (Evento e : eventos) {
            if (e.getNombreEvento().equalsIgnoreCase(nombre) &&
                    e.getFechaEvento().equals(fecha)) {
                encontrado = e;
            }
        }

        return encontrado;
    }

    public Reserva buscarReserva(int idReserva, String nombre, LocalDate fecha) {
        Reserva encontrada = null;

        Evento e = buscarEvento(nombre, fecha);

        if (e != null) {
            for (Reserva r : e.getReservas()) {
                if (r.getIdReserva() == idReserva) {
                    encontrada = r;
                }
            }
        }

        return encontrada;
    }

    public void agregarReserva(String email, String nombre, LocalDate fecha, ArrayList<Usuario> usuarios)
            throws ReservaException {

        Evento e = buscarEvento(nombre, fecha);

        if (e == null) {
            throw new ReservaException("Evento no encontrado");
        }

        Usuario u = null;

        for (Usuario x : usuarios) {
            if (x.getEmail().equalsIgnoreCase(email)) {
                u = x;
            }
        }

        if (u == null) {
            throw new ReservaException("Usuario no encontrado");
        }

        Reserva nueva = new Reserva(LocalDate.now(), u);
        e.getReservas().add(nueva);
    }

    public void modificarReserva(int idReserva, String nombre, LocalDate fecha, Usuario nuevoUsuario)
            throws ReservaException {

        Evento e = buscarEvento(nombre, fecha);

        if (e == null) {
            throw new ReservaException("Evento no encontrado");
        }

        Reserva r = buscarReserva(idReserva, nombre, fecha);

        if (r == null) {
            throw new ReservaException("Reserva no encontrada en ese evento");
        }

        r.setUsuario(nuevoUsuario);
    }
}

