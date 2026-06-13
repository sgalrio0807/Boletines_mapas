package BoletinListas.Ejercicio3;

public class Gestiona {
    static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        Libro l1 = new Libro("El Quijote", "Cervantes", "Novela", 1605, Estado.LIBRE);
        Libro l2 = new Libro("IT", "Stephen King", "Terror", 1986, Estado.LIBRE);

        b.agregarLibro(l1);
        b.agregarLibro(l2);

        try {
            b.prestarLibro("IT", "Stephen King");
            b.mostrarInventario();
            b.devolverLibro("IT", "Stephen King");
            b.mostrarInfoDetallada("El Quijote", "Cervantes");
            b.buscarPorTituloOAutor("king");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
        }
    }
}
