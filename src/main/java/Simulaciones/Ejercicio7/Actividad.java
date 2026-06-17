package Simulaciones.Ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actividad {

    private String nombre;
    private Lugar lugar;
    private LocalDate fecha;
    private int edadRecomendada;
    private int maxAlumnos;
    private Maestro maestro;
    private List<Alumno> alumnos;

    public Actividad(String nombre, Lugar lugar, LocalDate fecha, int edadRecomendada, int maxAlumnos, Maestro maestro) {

        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.edadRecomendada = edadRecomendada;
        this.maxAlumnos = maxAlumnos;
        this.maestro = maestro;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return Objects.equals(nombre, actividad.nombre) && Objects.equals(fecha, actividad.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }
}

