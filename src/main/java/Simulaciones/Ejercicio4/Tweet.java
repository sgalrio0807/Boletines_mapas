package Simulaciones.Ejercicio4;

public class Tweet extends Mensaje {

    public Tweet(String contenido, Usuario autor) throws UserMemoryException {
        super(validar(contenido), autor);
    }

    private static String validar(String texto) throws UserMemoryException {
        if (texto == null || texto.length() == 0 || texto.length() > 50) {
            throw new UserMemoryException("Tweet no válido: máximo 50 caracteres y no vacío");
        }
        return texto;
    }

    @Override
    public int calcularPuntuacion() {
        int puntos = 0;

        for (Valoracion v : getValoraciones()) {
            int suma = 0;

            if (v == Valoracion.SUPERBUENA) {
                suma = 3;
            } else if (v == Valoracion.MUYBUENA) {
                suma = 2;
            } else if (v == Valoracion.BUENA) {
                suma = 1;
            } else if (v == Valoracion.NORMAL) {
                suma = 0;
            } else if (v == Valoracion.REGULAR) {
                suma = -1;
            } else if (v == Valoracion.MUYMALA) {
                suma = -2;
            }

            puntos = puntos + (suma * 2); // doble para tweet
        }

        return puntos;
    }
}

