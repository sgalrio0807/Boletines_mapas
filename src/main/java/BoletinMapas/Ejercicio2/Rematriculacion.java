package BoletinMapas.Ejercicio2;

import java.time.LocalDate;

public class Rematriculacion {

    private String vin;
    private String matriculaInicial;
    private String matriculaFinal;
    private LocalDate fecha;

    public Rematriculacion(String vin, String matriculaInicial, String matriculaFinal, LocalDate fecha) {
        this.vin = vin;
        this.matriculaInicial = matriculaInicial;
        this.matriculaFinal = matriculaFinal;
        this.fecha = fecha;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMatriculaInicial() {
        return matriculaInicial;
    }

    public void setMatriculaInicial(String matriculaInicial) {
        this.matriculaInicial = matriculaInicial;
    }

    public String getMatriculaFinal() {
        return matriculaFinal;
    }

    public void setMatriculaFinal(String matriculaFinal) {
        this.matriculaFinal = matriculaFinal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Rematriculacion{" +
                "vin='" + vin + '\'' +
                ", matriculaInicial='" + matriculaInicial + '\'' +
                ", matriculaFinal='" + matriculaFinal + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}

