package Simulaciones.Ejercicio4;

import java.util.Comparator;

public class ComparadorMensajes implements Comparator<Mensaje> {

    @Override
    public int compare(Mensaje m1, Mensaje m2) {
        int res = m2.calcularPuntuacion() - m1.calcularPuntuacion();

        if (res == 0) {
            res = m2.getFechaCreacion().compareTo(m1.getFechaCreacion());
        }

        return res;
    }
}

