package EjercicioF1;

import java.util.Objects;

public class Escuderia {
    private String nombre;
    private String pais;
    private int trofeosGanados;

    public Escuderia(String nombre, String pais, int trofeosGanados) {
        this.nombre = nombre;
        this.pais = pais;
        this.trofeosGanados = trofeosGanados;
    }

    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public int getTrofeosGanados() { return trofeosGanados; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Escuderia e = (Escuderia) o;
        return Objects.equals(nombre, e.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ") - Trofeos: " + trofeosGanados;
    }
}
