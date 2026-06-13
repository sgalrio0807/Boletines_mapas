package BoletinOrdenaciones.Ejercicio2;

import java.time.LocalDate;

public class PaginaWeb {

    private String url;
    private LocalDate fecha;

    public PaginaWeb(String url, LocalDate fecha) {
        this.url = url;
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
