package BoletinOrdenaciones.Ejercicio1;

import java.time.LocalDate;

public class Gestiona {
    static void main(String[] args) {
        RepositorioAnimal repo = new RepositorioAnimal("Zoo", "Sevilla", 50000);

        Animal a1 = new Animal("1", "Tigre", "Panthera", 5, ClasificacionComida.CARNIVORO, LocalDate.of(2019, 1, 10), 200, Medio.TIERRA, Gestacion.VIVIPARO);
        Animal a2 = new Animal("2", "Delfín", "Delphinidae", 8, ClasificacionComida.CARNIVORO, LocalDate.of(2016, 5, 20), 150, Medio.AGUA, Gestacion.VIVIPARO);

        repo.agregarAnimal(a1);
        repo.agregarAnimal(a2);

        System.out.println("Info básica:");
        repo.mostrarInfoBasica();

        System.out.println("Ordenado por nombre:");
        for (Animal a : repo.ordenarPorNombre()) {
            System.out.println(a.getNombre());
        }

        System.out.println("Ordenado por nombre y fecha:");
        for (Animal a : repo.ordenarPorNombreYFecha()) {
            System.out.println(a.getNombre() + " - " + a.getFechaNacimiento());
        }

        System.out.println("Ordenado por medio y nombre:");
        for (Animal a : repo.ordenarPorMedioYNombre()) {
            System.out.println(a.getMedio() + " - " + a.getNombre());
        }
    }
}
