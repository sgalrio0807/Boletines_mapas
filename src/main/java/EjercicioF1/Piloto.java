package EjercicioF1;

import java.util.Objects;

public class Piloto {
    private int dorsal;
    private String nombreCompleto;
    private int puntosTemporada;

    public Piloto(int dorsal, String nombreCompleto, int puntosTemporada) {
        this.dorsal = dorsal;
        this.nombreCompleto = nombreCompleto;
        this.puntosTemporada = puntosTemporada;
    }

    public int getDorsal() { return dorsal; }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getPuntosTemporada() { return puntosTemporada; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Piloto p = (Piloto) o;
        return dorsal == p.dorsal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dorsal);
    }

    @Override
    public String toString() {
        return nombreCompleto + " (#" + dorsal + ") - Puntos: " + puntosTemporada;
    }
}
