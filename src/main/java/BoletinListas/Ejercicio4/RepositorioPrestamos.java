package BoletinListas.Ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;

public class RepositorioPrestamos {

    // Uso ArrayList porque necesito mantener el orden en que se realizaron los préstamos
    private ArrayList<Prestamo> historial;

    // Uso HashSet porque NO puede haber préstamos repetidos
    private HashSet<Prestamo> conjuntoPrestamos;

    public RepositorioPrestamos() {
        historial = new ArrayList<>();
        conjuntoPrestamos = new HashSet<>();
    }

    public ArrayList<Prestamo> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<Prestamo> historial) {
        this.historial = historial;
    }

    public HashSet<Prestamo> getConjuntoPrestamos() {
        return conjuntoPrestamos;
    }

    public void setConjuntoPrestamos(HashSet<Prestamo> conjuntoPrestamos) {
        this.conjuntoPrestamos = conjuntoPrestamos;
    }

    public void agregarPrestamo(Prestamo p) {
        if (!conjuntoPrestamos.contains(p)) {
            conjuntoPrestamos.add(p);
            historial.add(p);
        }
    }

    public void devolverLibro(Prestamo p) {
        p.getLibro().setEstado(Estado.LIBRE);
    }

    public void mostrarPrestamos() {
        for (Prestamo p : historial) {
            System.out.println(p.getLibro().getTitulo() + " - " +
                    p.getNombreUsuario() + " - " +
                    p.getFechaPrestamo());
        }
    }

    public void mostrarPrestamosPorLibro(String titulo, String autor) {
        for (Prestamo p : historial) {
            if (p.getLibro().getTitulo().equalsIgnoreCase(titulo) &&
                    p.getLibro().getAutor().equalsIgnoreCase(autor)) {
                System.out.println(p.getId() + " - " + p.getNombreUsuario());
            }
        }
    }
}

