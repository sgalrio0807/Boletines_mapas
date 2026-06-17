package Simulaciones.Ejercicio4;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Mensaje {

    private static int contador = 1;

    private int id;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private Usuario autor;
    private ArrayList<Valoracion> valoraciones;
    private int lecturas;

    public Mensaje(String contenido, Usuario autor) {
        this.id = contador;
        contador++;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaCreacion = LocalDateTime.now();
        this.valoraciones = new ArrayList<>();
        this.lecturas = 0;
    }

    public int getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public int getLecturas() {
        return lecturas;
    }

    public ArrayList<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void añadirValoracion(Valoracion v) {
        valoraciones.add(v);
        lecturas++;
    }

    public abstract int calcularPuntuacion();

    @Override
    public String toString() {
        return "[" + id + "] " + autor + " (" + fechaCreacion + ") -> " + contenido +
                " | puntuación: " + calcularPuntuacion();
    }
}

