package BoletinListas.Ejercicio2;

import java.util.Objects;

public class Alumno {

    private String nombre;
    private String dni;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }

    @Override
    public boolean equals(Object o) {
        boolean iguales = false;

        if (o instanceof Alumno) {
            Alumno otro = (Alumno) o;
            if (this.dni.equals(otro.dni)) {
                iguales = true;
            }
        }

        return iguales; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}