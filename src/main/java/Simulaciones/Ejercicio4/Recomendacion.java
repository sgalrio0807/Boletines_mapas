package Simulaciones.Ejercicio4;

public class Recomendacion extends Mensaje {

    public Recomendacion(String contenido, Usuario autor) throws UserMemoryException {
        super(validar(contenido), autor);
    }

    private static String validar(String texto) throws UserMemoryException {
        int len = (texto == null) ? 0 : texto.length();

        if (len < 100 || len > 200) {
            throw new UserMemoryException("Recomendación no válida: entre 100 y 200 caracteres");
        }

        return texto;
    }

    @Override
    public int calcularPuntuacion() {
        int puntos = 0;

        for (Valoracion v : getValoraciones()) {
            if (v == Valoracion.SUPERBUENA) {
                puntos += 3;
            } else if (v == Valoracion.MUYBUENA) {
                puntos += 2;
            } else if (v == Valoracion.BUENA) {
                puntos += 1;
            } else if (v == Valoracion.NORMAL) {
                puntos += 0;
            } else if (v == Valoracion.REGULAR) {
                puntos -= 1;
            } else if (v == Valoracion.MUYMALA) {
                puntos -= 2;
            }
        }

        return puntos;
    }
}

