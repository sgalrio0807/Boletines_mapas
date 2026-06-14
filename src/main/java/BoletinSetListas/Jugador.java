package BoletinSetListas;

import java.util.ArrayList;
import java.util.Objects;

public class Jugador {

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private int ranking;
    private int numeroFicha;
    private ArrayList<Partido> partidos;

    public Jugador(String nombre, String apellido, String nacionalidad, int ranking, int numeroFicha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.ranking = ranking;
        this.numeroFicha = numeroFicha;
        this.partidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return numeroFicha == jugador.numeroFicha;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroFicha);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", ranking=" + ranking +
                ", numeroFicha=" + numeroFicha +
                ", partidos=" + partidos +
                '}';
    }
}

