package Simulaciones.Ejercicio3;

import java.util.HashSet;

public class Taller {

    private static int contador = 1;

    private int id;
    private String nombre;
    private int edadMinima;
    private int aforoMaximo;
    private HashSet<Alumno> alumnos;

    public Taller(String nombre, int edadMinima, int aforoMaximo) {
        this.id = contador;
        contador++;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.aforoMaximo = aforoMaximo;
        this.alumnos = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public HashSet<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public void setAlumnos(HashSet<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edadMinima=" + edadMinima +
                ", aforoMaximo=" + aforoMaximo +
                ", alumnos=" + alumnos +
                '}';
    }
}

