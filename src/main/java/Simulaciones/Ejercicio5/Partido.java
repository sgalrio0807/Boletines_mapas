package Simulaciones.Ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Partido {

    private Jugador jugador1;
    private Jugador jugador2;
    private EstadoPartido estado;
    private LocalDate fecha;
    private ArrayList<Integer> setsJ1;
    private ArrayList<Integer> setsJ2;

    public Partido(Jugador jugador1, Jugador jugador2, EstadoPartido estado, LocalDate fecha, ArrayList<Integer> setsJ1, ArrayList<Integer> setsJ2) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.estado = estado;
        this.fecha = fecha;
        this.setsJ1 = setsJ1;
        this.setsJ2 = setsJ2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public EstadoPartido getEstado() {
        return estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getSetsJ1() {
        return setsJ1;
    }

    public void setSetsJ1(ArrayList<Integer> setsJ1) {
        this.setsJ1 = setsJ1;
    }

    public ArrayList<Integer> getSetsJ2() {
        return setsJ2;
    }

    public void setSetsJ2(ArrayList<Integer> setsJ2) {
        this.setsJ2 = setsJ2;
    }

    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
    }
}

