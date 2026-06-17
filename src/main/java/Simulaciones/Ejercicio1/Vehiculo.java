package Simulaciones.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Vehiculo {

    private String vin;
    private String matriculaActual;
    private String marca;
    private String modelo;
    private String color;
    private int añoFabricacion;
    private LocalDate fechaMatriculacion;
    private String propietario;
    private ArrayList<Matriculacion> historico;

    public Vehiculo(String vin, String matriculaActual, String marca, String modelo, String color, int añoFabricacion, LocalDate fechaMatriculacion, String propietario) {

        this.vin = vin;
        this.matriculaActual = matriculaActual;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.añoFabricacion = añoFabricacion;
        this.fechaMatriculacion = fechaMatriculacion;
        this.propietario = propietario;
        this.historico = new ArrayList<>();

        this.historico.add(new Matriculacion(matriculaActual, fechaMatriculacion));
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMatriculaActual() {
        return matriculaActual;
    }

    public void setMatriculaActual(String matriculaActual) {
        this.matriculaActual = matriculaActual;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Matriculacion> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Matriculacion> historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(vin, vehiculo.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "vin='" + vin + '\'' +
                ", matriculaActual='" + matriculaActual + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", propietario='" + propietario + '\'' +
                ", historico=" + historico +
                '}';
    }
}

