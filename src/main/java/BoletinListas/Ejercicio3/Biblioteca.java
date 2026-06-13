package BoletinListas.Ejercicio3;

import java.util.ArrayList;

public class Biblioteca {

    // Uso ArrayList porque permito duplicados y necesito recorrer y mostrar fácilmente
    private ArrayList<Libro> inventario;

    public Biblioteca() {
        inventario = new ArrayList<>();
    }

    public ArrayList<Libro> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Libro> inventario) {
        this.inventario = inventario;
    }

    public void agregarLibro(Libro l) {
        inventario.add(l);
    }

    public Libro buscarLibro(String titulo, String autor) {
        Libro encontrado = null;

        for (Libro l : inventario) {
            if (l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)) {
                encontrado = l;
            }
        }

        return encontrado;
    }

    public void prestarLibro(String titulo, String autor) throws BibliotecaException {
        Libro l = buscarLibro(titulo, autor);

        if (l == null) {
            throw new BibliotecaException("El libro no está en el inventario");
        }

        if (l.getEstado() == Estado.PRESTADO) {
            throw new BibliotecaException("El libro ya está prestado");
        }

        l.setEstado(Estado.PRESTADO);
    }

    public void devolverLibro(String titulo, String autor) throws BibliotecaException {
        Libro l = buscarLibro(titulo, autor);

        if (l == null) {
            throw new BibliotecaException("El libro no está en el inventario");
        }

        if (l.getEstado() == Estado.LIBRE) {
            throw new BibliotecaException("El libro no estaba prestado");
        }

        l.setEstado(Estado.LIBRE);
    }

    public void mostrarInventario() {
        for (Libro l : inventario) {
            System.out.println(l.getTitulo() + " - " + l.getAutor() + " - " + l.getEstado());
        }
    }

    public void mostrarInfoDetallada(String titulo, String autor) throws BibliotecaException {
        Libro l = buscarLibro(titulo, autor);

        if (l == null) {
            throw new BibliotecaException("Libro no encontrado");
        }

        System.out.println("Título: " + l.getTitulo());
        System.out.println("Autor: " + l.getAutor());
        System.out.println("Género: " + l.getGenero());
        System.out.println("Año: " + l.getAnio());
        System.out.println("Estado: " + l.getEstado());
    }

    public void buscarPorTituloOAutor(String texto) {
        for (Libro l : inventario) {
            if (l.getTitulo().toLowerCase().contains(texto.toLowerCase()) ||
                    l.getAutor().toLowerCase().contains(texto.toLowerCase())) {
                System.out.println(l.getTitulo() + " - " + l.getAutor());
            }
        }
    }
}

