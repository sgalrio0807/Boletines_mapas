package BoletinListas.Ejercicio4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    // Uso ArrayList porque necesito recorrer y mostrar fácilmente los libros
    private ArrayList<Libro> libros;

    private RepositorioPrestamos repo;

    public Biblioteca() {
        libros = new ArrayList<>();
        repo = new RepositorioPrestamos();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public RepositorioPrestamos getRepo() {
        return repo;
    }

    public void setRepo(RepositorioPrestamos repo) {
        this.repo = repo;
    }

    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    public Libro buscarLibro(String titulo, String autor) {
        Libro encontrado = null;

        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)) {
                encontrado = l;
            }
        }

        return encontrado;
    }

    public void prestarLibro(String titulo, String autor, String usuario) {
        try {
            Libro l = buscarLibro(titulo, autor);

            if (l == null) {
                throw new BibliotecaException("Libro no encontrado");
            }

            if (l.getEstado() == Estado.PRESTADO) {
                throw new BibliotecaException("El libro ya está prestado");
            }

            l.setEstado(Estado.PRESTADO);

            Prestamo p = new Prestamo(titulo + usuario + LocalDate.now(), l, usuario, LocalDate.now());
            repo.agregarPrestamo(p);

        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void devolverLibro(String titulo, String autor, String usuario) {
        try {
            Libro l = buscarLibro(titulo, autor);

            if (l == null) {
                throw new BibliotecaException("Libro no encontrado");
            }

            if (l.getEstado() == Estado.LIBRE) {
                throw new BibliotecaException("El libro no estaba prestado");
            }

            l.setEstado(Estado.LIBRE);

        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
        }
    }
}
