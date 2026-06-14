package BoletinOrdenaciones2.Ejercicio1;

public class GestionaContactoMapa {
    static void main(String[] args) {
        AgendaMapa agenda = new AgendaMapa();

        agenda.agregarContacto(new Contacto("Carlos", "Ruiz", "c@mail.com", "Calle A", "111"));
        agenda.agregarContacto(new Contacto("Ana", "López", "a@mail.com", "Calle B", "222"));

        System.out.println("Agenda:");
        agenda.mostrarAgenda();

        System.out.println("Buscar por teléfono 111:");
        System.out.println(agenda.buscarPorTelefono("111"));
    }
}
