package BoletinClone.Ejercicio1;

import java.util.Objects;

public class Reserva {

    private static int contador = 1;

    private int id;
    private String pasajero;
    private String destino;
    private String asiento;
    private double precio;

    public Reserva(String pasajero, String destino, String asiento, double precio) {
        this.id = contador;
        contador++;
        this.pasajero = pasajero;
        this.destino = destino;
        this.asiento = asiento;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", pasajero='" + pasajero + '\'' +
                ", destino='" + destino + '\'' +
                ", asiento='" + asiento + '\'' +
                ", precio=" + precio +
                '}';
    }
}

