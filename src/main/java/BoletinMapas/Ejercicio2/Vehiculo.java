package BoletinMapas.Ejercicio2;

import java.util.ArrayList;
import java.util.Objects;

public class Vehiculo {

    private String vin;
    private String matriculaActual;
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private String propietario;
    private ArrayList<Rematriculacion> rematriculaciones;

    public Vehiculo(String vin, String matriculaActual, String marca, String modelo,
                    int añoFabricacion, String propietario) {

        this.vin = vin;
        this.matriculaActual = matriculaActual;
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.propietario = propietario;
        this.rematriculaciones = new ArrayList<>();
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

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Rematriculacion> getRematriculaciones() {
        return rematriculaciones;
    }

    public void setRematriculaciones(ArrayList<Rematriculacion> rematriculaciones) {
        this.rematriculaciones = rematriculaciones;
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
                ", añoFabricacion=" + añoFabricacion +
                ", propietario='" + propietario + '\'' +
                ", rematriculaciones=" + rematriculaciones +
                '}';
    }
}

