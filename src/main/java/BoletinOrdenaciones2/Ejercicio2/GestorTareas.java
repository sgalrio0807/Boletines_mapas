package BoletinOrdenaciones2.Ejercicio2;

import java.util.ArrayList;

public class GestorTareas {

    private ArrayList<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void agregarTarea(Tarea t) {
        tareas.add(t);
        ordenarPorPrioridad();
    }

    public boolean eliminarTarea(int id) {
        boolean eliminada = false;

        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                eliminada = true;
                break;
            }
        }

        return eliminada;
    }

    private void ordenarPorPrioridad() {
        for (int i = 0; i < tareas.size() - 1; i++) {
            for (int j = i + 1; j < tareas.size(); j++) {

                Tarea a = tareas.get(i);
                Tarea b = tareas.get(j);

                if (a.getPrioridad() > b.getPrioridad()) {
                    Tarea aux = tareas.get(i);
                    tareas.set(i, tareas.get(j));
                    tareas.set(j, aux);
                }
            }
        }
    }

    public void mostrarTareas() {
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    public Tarea obtenerMasPrioritaria() {
        Tarea resultado = null;

        if (tareas.size() > 0) {
            resultado = tareas.get(0);
        }

        return resultado;
    }
}

