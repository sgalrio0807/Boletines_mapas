package Simulaciones.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {

    private static int numeroAlumnos = 1;

    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;
    private List<String> alergias;
    private boolean autorizaImagenes;
    private Maestro maestro;

    public Alumno(String nombre, String apellidos, int edad, String telefono, List<String> alergias, boolean autorizaImagenes, Maestro maestro) {

        this.id = numeroAlumnos;
        numeroAlumnos++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.alergias = alergias != null ? alergias : new ArrayList<>();
        this.autorizaImagenes = autorizaImagenes;
        this.maestro = maestro;
    }

    public static int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public static void setNumeroAlumnos(int numeroAlumnos) {
        Alumno.numeroAlumnos = numeroAlumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public boolean isAutorizaImagenes() {
        return autorizaImagenes;
    }

    public void setAutorizaImagenes(boolean autorizaImagenes) {
        this.autorizaImagenes = autorizaImagenes;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}

