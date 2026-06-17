package Simulaciones.Ejercicio8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Equipo {

    private String codigo;
    private String nombre;
    private String pais;
    private LocalDate fechaFundacion;
    private ArrayList<Partida> partidas;

    public Equipo(String codigo, String nombre, String pais, LocalDate fechaFundacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
        this.fechaFundacion = fechaFundacion;
        this.partidas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(codigo, equipo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

