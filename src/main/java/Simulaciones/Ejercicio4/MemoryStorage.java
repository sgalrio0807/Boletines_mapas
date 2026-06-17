package Simulaciones.Ejercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class MemoryStorage {

    private TreeSet<Usuario> usuarios;
    private ArrayList<Mensaje> mensajes;

    public MemoryStorage() {
        usuarios = new TreeSet<>();
        mensajes = new ArrayList<>();
    }

    public void addUsuario(String nombre, String password) {
        try {
            Usuario u = new Usuario(nombre, password);
            usuarios.add(u);
        } catch (UserMemoryException e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuario buscarUsuario(String nombre) {
        Usuario encontrado = null;

        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = u;
            }
        }

        return encontrado;
    }

    public void crearTweet(String contenido, String nombreUsuario) {
        Usuario u = buscarUsuario(nombreUsuario);

        if (u == null) {
            System.out.println("Usuario no existe, no se crea el mensaje");
        } else {
            try {
                Mensaje m = new Tweet(contenido, u);
                mensajes.add(m);
            } catch (UserMemoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void crearPost(String contenido, String nombreUsuario) {
        Usuario u = buscarUsuario(nombreUsuario);

        if (u == null) {
            System.out.println("Usuario no existe, no se crea el mensaje");
        } else {
            try {
                Mensaje m = new Post(contenido, u);
                mensajes.add(m);
            } catch (UserMemoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void crearRecomendacion(String contenido, String nombreUsuario) {
        Usuario u = buscarUsuario(nombreUsuario);

        if (u == null) {
            System.out.println("Usuario no existe, no se crea el mensaje");
        } else {
            try {
                Mensaje m = new Recomendacion(contenido, u);
                mensajes.add(m);
            } catch (UserMemoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Mensaje buscarMensajePorId(int id) {
        Mensaje encontrado = null;

        for (Mensaje m : mensajes) {
            if (m.getId() == id) {
                encontrado = m;
            }
        }

        return encontrado;
    }

    public void valorarMensaje(int idMensaje, Valoracion v) {
        Mensaje m = buscarMensajePorId(idMensaje);

        if (m != null) {
            m.añadirValoracion(v);
        }
    }

    public void mostrarMensajesUsuario(String nombreUsuario) {
        for (Mensaje m : mensajes) {
            if (m.getAutor().getNombre().equalsIgnoreCase(nombreUsuario)) {
                System.out.println(m);
            }
        }
    }

    public void mostrarMensajesUsuario(String nombreUsuario, String tipo) {
        for (Mensaje m : mensajes) {

            boolean coincide = false;

            if (tipo.equalsIgnoreCase("tweet") && m instanceof Tweet) {
                coincide = true;
            } else if (tipo.equalsIgnoreCase("post") && m instanceof Post) {
                coincide = true;
            } else if (tipo.equalsIgnoreCase("recomendacion") && m instanceof Recomendacion) {
                coincide = true;
            }

            if (m.getAutor().getNombre().equalsIgnoreCase(nombreUsuario) && coincide) {
                System.out.println(m);
            }
        }
    }


    public void mostrarMensajesOrdenadosPorValoracion() {
        ArrayList<Mensaje> copia = new ArrayList<>(mensajes);
        Collections.sort(copia, new ComparadorMensajes());

        for (Mensaje m : copia) {
            System.out.println(m);
        }
    }
}

