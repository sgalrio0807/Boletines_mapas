package Simulaciones.Ejercicio6;

import java.time.LocalDate;
import java.util.Objects;

public class Trabajador {

    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private TipoTrabajador tipo;
    private int idCentro;

    public Trabajador(String nombre, String dni, LocalDate fechaNacimiento, TipoTrabajador tipo, int idCentro) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoTrabajador getTipo() {
        return tipo;
    }

    public void setTipo(TipoTrabajador tipo) {
        this.tipo = tipo;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trabajador that = (Trabajador) o;
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", tipo=" + tipo +
                ", idCentro=" + idCentro +
                '}';
    }
}

