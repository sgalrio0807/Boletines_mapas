package BoletinOrdenaciones.Ejercicio1;

import java.time.LocalDate;

public class Animal {

    private String identificador;
    private String nombre;
    private String especie;
    private int edad;
    private ClasificacionComida comida;
    private LocalDate fechaNacimiento;
    private double peso;
    private Medio medio;
    private Gestacion gestacion;

    public Animal(String identificador, String nombre, String especie, int edad,
                  ClasificacionComida comida, LocalDate fechaNacimiento,
                  double peso, Medio medio, Gestacion gestacion) {

        this.identificador = identificador;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.comida = comida;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.medio = medio;
        this.gestacion = gestacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ClasificacionComida getComida() {
        return comida;
    }

    public void setComida(ClasificacionComida comida) {
        this.comida = comida;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Medio getMedio() {
        return medio;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }

    public Gestacion getGestacion() {
        return gestacion;
    }

    public void setGestacion(Gestacion gestacion) {
        this.gestacion = gestacion;
    }
}

