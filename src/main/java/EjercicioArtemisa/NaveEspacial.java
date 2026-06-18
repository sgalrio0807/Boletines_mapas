package EjercicioArtemisa;

import java.util.Objects;

public class NaveEspacial {
    private String codigoNave;
    private String nombreMision;
    private String agencia;
    private int capacidadTripulacion;

    public NaveEspacial(String codigoNave, String nombreMision, String agencia, int capacidadTripulacion) {
        this.codigoNave = codigoNave;
        this.nombreMision = nombreMision;
        this.agencia = agencia;
        this.capacidadTripulacion = capacidadTripulacion;
    }

    public String getCodigoNave() { return codigoNave; }
    public String getNombreMision() { return nombreMision; }
    public String getAgencia() { return agencia; }
    public int getCapacidadTripulacion() { return capacidadTripulacion; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NaveEspacial n = (NaveEspacial) o;
        return Objects.equals(codigoNave, n.codigoNave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoNave);
    }

    @Override
    public String toString() {
        return nombreMision + " (" + codigoNave + ")";
    }
}
