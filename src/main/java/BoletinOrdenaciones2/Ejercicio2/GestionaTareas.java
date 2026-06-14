package BoletinOrdenaciones2.Ejercicio2;

public class GestionaTareas {
    static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        gestor.agregarTarea(new Tarea("Trabajo", "Preparar informe", 3));
        gestor.agregarTarea(new Tarea("Casa", "Lavar ropa", 5));
        gestor.agregarTarea(new Tarea("Urgente", "Pagar recibo", 1));
        gestor.agregarTarea(new Tarea("Estudios", "Hacer ejercicio Java", 2));

        System.out.println("Tareas ordenadas por prioridad:");
        gestor.mostrarTareas();

        System.out.println("Tarea más prioritaria:");
        System.out.println(gestor.obtenerMasPrioritaria());

        System.out.println("Eliminando tarea con ID 2...");
        gestor.eliminarTarea(2);

        System.out.println("Tareas tras eliminar:");
        gestor.mostrarTareas();
    }
}
