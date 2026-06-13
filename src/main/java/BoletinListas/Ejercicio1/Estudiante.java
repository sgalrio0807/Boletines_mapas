package BoletinListas.Ejercicio1;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String id;
    private ArrayList<Double> notas;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() throws Exception{
        if (notas.size() == 0) {
            throw new Exception("El estudiante no tiene notas");
        }
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        double promedio = suma / notas.size();
        return promedio;
    }
}
