package BoletinListas.Ejercicio4;

public class Gestiona {
    static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        Libro l1 = new Libro("IT", "Stephen King", Estado.LIBRE);
        Libro l2 = new Libro("Dune", "Frank Herbert", Estado.LIBRE);

        b.agregarLibro(l1);
        b.agregarLibro(l2);

        b.prestarLibro("IT", "Stephen King", "111A");
        b.prestarLibro("Dune", "Frank Herbert", "222B");

        b.getRepo().mostrarPrestamos();

        b.devolverLibro("IT", "Stephen King", "111A");

        b.getRepo().mostrarPrestamosPorLibro("IT", "Stephen King");
    }
}
