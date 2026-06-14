package BoletinOrdenaciones2.Ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class SistemaReservas {

    private HashSet<Usuario> usuarios;
    private HashSet<Evento> eventos;

    public SistemaReservas() {
        usuarios = new HashSet<>();
        eventos = new HashSet<>();
    }

    public void altaUsuario(Usuario u) {
        usuarios.add(u);
    }

    public ArrayList<Usuario> listarUsuariosOrdenados() {
        ArrayList<Usuario> lista = new ArrayList<>(usuarios);

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                Usuario a = lista.get(i);
                Usuario b = lista.get(j);

                if (a.getId() > b.getId()) {
                    Usuario aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }

    public void altaEvento(Evento e) throws ReservaException {
        if (e.getFechaEvento().isBefore(LocalDate.now())) {
            throw new ReservaException("No se pueden registrar eventos pasados");
        }
        eventos.add(e);
    }

    private Usuario buscarUsuarioPorEmail(String email) {
        Usuario encontrado = null;

        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                encontrado = u;
            }
        }

        return encontrado;
    }

    private Evento buscarEventoPorId(int id) {
        Evento encontrado = null;

        for (Evento e : eventos) {
            if (e.getIdEvento() == id) {
                encontrado = e;
            }
        }

        return encontrado;
    }

    public void reservar(String email, int idEvento) throws ReservaException {
        Usuario u = buscarUsuarioPorEmail(email);
        Evento e = buscarEventoPorId(idEvento);

        if (e == null) {
            throw new ReservaException("Evento no encontrado");
        }

        if (u == null) {
            throw new ReservaException("Usuario no encontrado");
        }

        for (Reserva r : e.getReservas()) {
            if (r.getUsuario().equals(u)) {
                throw new ReservaException("El usuario ya tiene reserva en este evento");
            }
        }

        Reserva nueva = new Reserva(LocalDate.now(), EstadoReserva.RESERVADA, u);
        e.getReservas().add(nueva);
    }

    public void cancelarReserva(String email, int idReserva) throws ReservaException {
        Usuario u = buscarUsuarioPorEmail(email);

        if (u == null) {
            throw new ReservaException("Usuario no encontrado");
        }

        boolean encontrada = false;

        for (Evento e : eventos) {
            for (Reserva r : e.getReservas()) {
                if (r.getIdReserva() == idReserva && r.getUsuario().equals(u)) {
                    r.setEstado(EstadoReserva.ANULADA);
                    encontrada = true;
                }
            }
        }

        if (!encontrada) {
            throw new ReservaException("Reserva no encontrada");
        }
    }

    public ArrayList<Reserva> reservasUsuarioOrdenadas(String email) throws ReservaException {
        Usuario u = buscarUsuarioPorEmail(email);

        if (u == null) {
            throw new ReservaException("Usuario no encontrado");
        }

        ArrayList<Reserva> lista = new ArrayList<>();

        for (Evento e : eventos) {
            for (Reserva r : e.getReservas()) {
                if (r.getUsuario().equals(u)) {
                    lista.add(r);
                }
            }
        }

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getFechaReserva().isAfter(lista.get(j).getFechaReserva())) {
                    Reserva aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }
}

