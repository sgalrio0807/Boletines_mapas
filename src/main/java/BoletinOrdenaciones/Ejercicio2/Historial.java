package BoletinOrdenaciones.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

// Uso ArrayList porque necesito mantener el historial ordenado por fecha y permitir duplicados
public class Historial {

    private ArrayList<PaginaWeb> historial;

    public Historial() {
        historial = new ArrayList<>();
    }

    public ArrayList<PaginaWeb> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<PaginaWeb> historial) {
        this.historial = historial;
    }

    public void agregarPagina(String url, LocalDate fecha) throws HistorialException {
        if (fecha.isAfter(LocalDate.now())) {
            throw new HistorialException("La fecha no puede ser futura");
        }

        PaginaWeb p = new PaginaWeb(url, fecha);
        historial.add(p);

        historial.sort(Comparator.comparing(PaginaWeb::getFecha));
    }

    public void agregarPagina(String url) throws HistorialException {
        agregarPagina(url, LocalDate.now());
    }

    public void mostrarHistorial() {
        for (PaginaWeb p : historial) {
            System.out.println(p.getFecha() + " - " + p.getUrl());
        }
    }

    public void historialDeDia(LocalDate dia) {
        for (PaginaWeb p : historial) {
            if (p.getFecha().equals(dia)) {
                System.out.println(p.getFecha() + " - " + p.getUrl());
            }
        }
    }

    public void historialPorUrl(String url) {
        for (PaginaWeb p : historial) {
            if (p.getUrl().equalsIgnoreCase(url)) {
                System.out.println(p.getFecha() + " - " + p.getUrl());
            }
        }
    }

    public void borrarPorUrl(String url) {
        historial.removeIf(p -> p.getUrl().equalsIgnoreCase(url));
    }

    public ArrayList<PaginaWeb> ordenarPorUrl() {
        ArrayList<PaginaWeb> copia = new ArrayList<>(historial);

        copia.sort(Comparator.comparing(PaginaWeb::getUrl));

        return copia;
    }
}

