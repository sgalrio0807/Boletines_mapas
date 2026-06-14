package BoletinOrdenaciones2.Ejercicio1;

import java.util.LinkedHashMap;

public class AgendaMapa {

    private LinkedHashMap<String, Contacto> contactos;

    public AgendaMapa() {
        contactos = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(LinkedHashMap<String, Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean agregarContacto(Contacto c) {
        boolean añadido = false;

        if (!contactos.containsKey(c.getTelefono())) {
            contactos.put(c.getTelefono(), c);
            añadido = true;
        }

        return añadido;
    }

    public boolean eliminarContacto(String telefono) {
        boolean eliminado = false;

        if (contactos.containsKey(telefono)) {
            contactos.remove(telefono);
            eliminado = true;
        }

        return eliminado;
    }

    public Contacto buscarPorTelefono(String telefono) {
        Contacto encontrado = null;

        if (contactos.containsKey(telefono)) {
            encontrado = contactos.get(telefono);
        }

        return encontrado;
    }

    public void mostrarAgenda() {
        for (String t : contactos.keySet()) {
            System.out.println(contactos.get(t));
        }
    }
}

