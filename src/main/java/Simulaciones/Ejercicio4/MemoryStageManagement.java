package Simulaciones.Ejercicio4;

public class MemoryStageManagement {
    static void main(String[] args) {
        MemoryStorage ms = new MemoryStorage();

        // Crear usuarios
        ms.addUsuario("carlos1", "Abcdef12");
        ms.addUsuario("ana", "abc"); // usuario incorrecto
        ms.addUsuario("usuarioX", "Clave123");

        // Crear mensajes
        ms.crearTweet("Hola mundo", "carlos1");
        ms.crearPost("Este es un post válido", "carlos1");

        String textoLargo = "";
        for (int i = 0; i < 120; i++) {
            textoLargo += "a";
        }
        ms.crearRecomendacion(textoLargo, "usuarioX");

        // Valorar mensajes
        ms.valorarMensaje(1, Valoracion.SUPERBUENA);
        ms.valorarMensaje(1, Valoracion.BUENA);
        ms.valorarMensaje(2, Valoracion.MUYMALA);

        // Mostrar mensajes de un usuario
        System.out.println("Mensajes de carlos1:");
        ms.mostrarMensajesUsuario("carlos1");

        // Mostrar mensajes filtrados por tipo (SIN Class<?>)
        System.out.println("Tweets de carlos1:");
        ms.mostrarMensajesUsuario("carlos1", "tweet");

        System.out.println("Posts de carlos1:");
        ms.mostrarMensajesUsuario("carlos1", "post");

        System.out.println("Recomendaciones de usuarioX:");
        ms.mostrarMensajesUsuario("usuarioX", "recomendacion");
    }
}
