package BoletinOrdenaciones2.Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;

public class Agenda {

    // Uso HashSet para evitar duplicados
    private HashSet<Contacto> contactos;

    public Agenda() {
        contactos = new HashSet<>();
    }

    public HashSet<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(HashSet<Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean agregarContacto(Contacto c) {
        boolean añadido = contactos.add(c);
        return añadido;
    }

    public boolean eliminarContacto(String nombre, String apellidos) {
        boolean eliminado = false;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellidos().equalsIgnoreCase(apellidos)) {
                contactos.remove(c);
                eliminado = true;
                break;
            }
        }

        return eliminado;
    }

    public Contacto buscarContacto(String nombre, String apellidos) {
        Contacto encontrado = null;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellidos().equalsIgnoreCase(apellidos)) {
                encontrado = c;
            }
        }

        return encontrado;
    }

    public ArrayList<Contacto> obtenerContactosOrdenados() {
        ArrayList<Contacto> lista = new ArrayList<>(contactos);

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                Contacto a = lista.get(i);
                Contacto b = lista.get(j);

                boolean cambiar = false;

                if (a.getNombre().compareToIgnoreCase(b.getNombre()) > 0) {
                    cambiar = true;
                } else if (a.getNombre().equalsIgnoreCase(b.getNombre()) &&
                        a.getApellidos().compareToIgnoreCase(b.getApellidos()) > 0) {
                    cambiar = true;
                }

                if (cambiar) {
                    Contacto aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }
}

