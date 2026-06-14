package BoletinOrdenaciones2.Ejercicio3;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Evento {

    private static int contador = 1;

    private int idEvento;
    private String nombreEvento;
    private LocalDate fechaEvento;
    private String lugar;
    private LinkedHashSet<Reserva> reservas;

    public Evento(String nombreEvento, LocalDate fechaEvento, String lugar) {
        this.idEvento = contador;
        contador++;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.lugar = lugar;
        this.reservas = new LinkedHashSet<>();
    }

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LinkedHashSet<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedHashSet<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return idEvento == evento.idEvento;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idEvento);
    }
}

