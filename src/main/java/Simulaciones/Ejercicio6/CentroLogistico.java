package Simulaciones.Ejercicio6;

import java.util.ArrayList;
import java.util.Objects;

public class CentroLogistico {

    private int id;
    private String nombre;
    private String ciudad;
    private int numComedores;
    private ArrayList<Trabajador> trabajadores;

    public CentroLogistico(int id, String nombre, String ciudad, int numComedores) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numComedores = numComedores;
        this.trabajadores = new ArrayList<>();
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumComedores() {
        return numComedores;
    }

    public void setNumComedores(int numComedores) {
        this.numComedores = numComedores;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CentroLogistico that = (CentroLogistico) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CentroLogistico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", numComedores=" + numComedores +
                ", trabajadores=" + trabajadores +
                '}';
    }
}

