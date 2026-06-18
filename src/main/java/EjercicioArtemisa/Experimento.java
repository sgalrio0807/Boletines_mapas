package EjercicioArtemisa;

import java.time.LocalDate;
import java.util.Objects;

public class Experimento {
    private String idExperimento;
    private String descripcion;
    private double duracionHoras;
    private LocalDate fechaEjecucion;
    private EstadoExperimento estado;

    public Experimento(String idExperimento, String descripcion, double duracionHoras, LocalDate fechaEjecucion) {
        this.idExperimento = idExperimento;
        this.descripcion = descripcion;
        this.duracionHoras = duracionHoras;
        this.fechaEjecucion = fechaEjecucion;
        this.estado = EstadoExperimento.PROGRAMADO;
    }

    public String getIdExperimento() { return idExperimento; }
    public double getDuracionHoras() { return duracionHoras; }
    public LocalDate getFechaEjecucion() { return fechaEjecucion; }
    public EstadoExperimento getEstado() { return estado; }

    public void setEstado(EstadoExperimento estado) { this.estado = estado; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Experimento e = (Experimento) o;
        return Objects.equals(idExperimento, e.idExperimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExperimento);
    }

    @Override
    public String toString() {
        return idExperimento + " (" + duracionHoras + "h, " + estado + ")";
    }
}
