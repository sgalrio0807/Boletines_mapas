package BoletinOrdenaciones2.Ejercicio1;

public class GestionaAgenda {
    static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.agregarContacto(new Contacto("Carlos", "Ruiz", "carlos@mail.com", "Calle A", "111"));
        agenda.agregarContacto(new Contacto("Ana", "López", "ana@mail.com", "Calle B", "222"));
        agenda.agregarContacto(new Contacto("Carlos", "Ruiz", "otro@mail.com", "Calle C", "333")); // duplicado

        System.out.println("Contactos ordenados:");
        for (Contacto c : agenda.obtenerContactosOrdenados()) {
            System.out.println(c);
        }

        System.out.println("Buscar Carlos Ruiz:");
        Contacto encontrado = agenda.buscarContacto("Carlos", "Ruiz");
        if (encontrado != null) {
            System.out.println(encontrado.getTelefono() + " - " + encontrado.getEmail());
        }
    }
}
