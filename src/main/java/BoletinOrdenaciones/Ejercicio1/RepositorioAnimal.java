package BoletinOrdenaciones.Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;

// Uso ArrayList porque necesito mantener orden y permitir ordenaciones temporales sin modificar almacenamiento
public class RepositorioAnimal {

    private String nombre;
    private String lugar;
    private double presupuestoAnual;
    private ArrayList<Animal> animales;

    public RepositorioAnimal(String nombre, String lugar, double presupuestoAnual) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.presupuestoAnual = presupuestoAnual;
        this.animales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    public void agregarAnimal(Animal a) {
        boolean existe = false;

        for (Animal x : animales) {
            if (x.getIdentificador().equalsIgnoreCase(a.getIdentificador())) {
                existe = true;
            }
        }
        if (!existe) {
            animales.add(a);
        }
    }

    public void mostrarInfoBasica() {
        for (Animal a : animales) {
            System.out.println(a.getNombre() + " - " +
                    a.getFechaNacimiento() + " - " +
                    a.getMedio() + " - " +
                    a.getComida());
        }
    }

    public ArrayList<Animal> ordenarPorNombre() {
        ArrayList<Animal> copia = new ArrayList<>(animales);
        copia.sort(Comparator.comparing(Animal::getNombre));

        return copia;
    }

    public ArrayList<Animal> ordenarPorNombreYFecha() {
        ArrayList<Animal> copia = new ArrayList<>(animales);
        copia.sort(Comparator
                .comparing(Animal::getNombre)
                .thenComparing(Animal::getFechaNacimiento));

        return copia;
    }

    public ArrayList<Animal> ordenarPorMedioYNombre() {
        ArrayList<Animal> copia = new ArrayList<>(animales);

        copia.sort(Comparator
                .comparing(Animal::getMedio)
                .thenComparing(Animal::getNombre));

        return copia;
    }
}

