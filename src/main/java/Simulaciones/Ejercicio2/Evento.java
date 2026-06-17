package Simulaciones.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Evento {

    private String nombreEvento;
    private LocalDate fechaEvento;
    private String lugar;
    private ArrayList<Reserva> reservas;

    public Evento(String nombreEvento, LocalDate fechaEvento, String lugar) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.lugar = lugar;
        this.reservas = new ArrayList<>();
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

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(nombreEvento, evento.nombreEvento) && Objects.equals(fechaEvento, evento.fechaEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEvento, fechaEvento);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombreEvento='" + nombreEvento + '\'' +
                ", fechaEvento=" + fechaEvento +
                ", lugar='" + lugar + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}

