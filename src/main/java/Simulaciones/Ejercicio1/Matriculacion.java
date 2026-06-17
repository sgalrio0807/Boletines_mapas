package Simulaciones.Ejercicio1;

import java.time.LocalDate;

public class Matriculacion {

    private String matricula;
    private LocalDate fecha;

    public Matriculacion(String matricula, LocalDate fecha) {
        this.matricula = matricula;
        this.fecha = fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Matriculacion{" +
                "matricula='" + matricula + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}

