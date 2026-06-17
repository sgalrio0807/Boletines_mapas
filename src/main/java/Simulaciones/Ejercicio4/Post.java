package Simulaciones.Ejercicio4;

public class Post extends Mensaje {

    public Post(String contenido, Usuario autor) throws UserMemoryException {
        super(validar(contenido), autor);
    }

    private static String validar(String texto) throws UserMemoryException {
        if (texto == null || texto.trim().length() == 0) {
            throw new UserMemoryException("Post no válido: no puede estar en blanco");
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

