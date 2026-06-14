package BoletinOrdenaciones2.Ejercicio3;

import java.time.LocalDate;

public class Reserva {

    private static int contador = 1;

    private int idReserva;
    private LocalDate fechaReserva;
    private EstadoReserva estado;
    private Usuario usuario;

    public Reserva(LocalDate fechaReserva, EstadoReserva estado, Usuario usuario) {
        this.idReserva = contador;
        contador++;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fechaReserva=" + fechaReserva +
                ", estado=" + estado +
                ", usuario=" + usuario +
                '}';
    }
}

