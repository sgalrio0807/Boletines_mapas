package BoletinListas.Ejercicio4;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {

    private String id;
    private Libro libro;
    private String nombreUsuario;
    private LocalDate fechaPrestamo;

    public Prestamo(String id, Libro libro, String nombreUsuario, LocalDate fechaPrestamo) {
        this.id = id;
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(id, prestamo.id) && Objects.equals(libro, prestamo.libro) && Objects.equals(nombreUsuario, prestamo.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libro, nombreUsuario);
    }
}

