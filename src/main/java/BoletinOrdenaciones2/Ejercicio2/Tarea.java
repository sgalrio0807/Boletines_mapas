package BoletinOrdenaciones2.Ejercicio2;

public class Tarea {

    private static int contador = 1;

    private int id;
    private String categoria;
    private String descripcion;
    private int prioridad;

    public Tarea(String categoria, String descripcion, int prioridad) {
        this.id = contador;
        contador++;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}
