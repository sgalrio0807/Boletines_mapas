package BoletinClone.Ejercicio1;

import java.util.LinkedHashSet;

// Uso LinkedHashSet porque NO permite repetidos y mantiene el orden de inserción
public class RepositorioReservas {

    private LinkedHashSet<Reserva> reservas;

    public RepositorioReservas() {
        reservas = new LinkedHashSet<>();
    }

    public LinkedHashSet<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedHashSet<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva r) {
        reservas.add(r);
    }

    public Reserva obtenerPorId(int id) {
        Reserva encontrada = null;

        for (Reserva r : reservas) {
            if (r.getId() == id) {
                encontrada = r;
            }
        }

        return encontrada;
    }

    public void mostrarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public Reserva cambiarAsiento(int id, String nuevoAsiento, boolean confirmar) {
        Reserva resultado = null;
        Reserva encontrada = obtenerPorId(id);

        if (encontrada != null) {
            if (confirmar) {
                encontrada.setAsiento(nuevoAsiento);
                resultado = encontrada;
            } else {
                Reserva copia = new Reserva(encontrada.getPasajero(), encontrada.getDestino(), nuevoAsiento, encontrada.getPrecio());
                resultado = copia;
            }
        }
        return resultado;
    }
}

