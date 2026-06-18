package EjercicioArtemisa;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionaMisiones {
    static void main(String[] args) {
        RepositorioMisiones repo = new RepositorioMisiones();

        // ============================
        // CREACIÓN DE EXPERIMENTOS
        // ============================
        Experimento e1 = new Experimento("EXP001", "Análisis lunar", 5, LocalDate.of(2026, 6, 20));
        Experimento e2 = new Experimento("EXP002", "Radiación solar", 3, LocalDate.of(2026, 6, 22));
        Experimento e3 = new Experimento("EXP003", "Gravedad cero", 4, LocalDate.of(2026, 6, 25));
        Experimento e4 = new Experimento("EXP004", "Oxígeno marciano", 6, LocalDate.of(2026, 6, 28));
        Experimento e5 = new Experimento("EXP005", "Presión atmosférica", 2, LocalDate.of(2026, 6, 30));
        Experimento e6 = new Experimento("EXP006", "Temperatura lunar", 7, LocalDate.of(2026, 7, 2));

        // ============================
        // ASIGNACIÓN DE EXPERIMENTOS
        // ============================
        try {
            repo.asignarExperimento("N001", "Artemisa II", "NASA", 6, e1);
            repo.asignarExperimento("N002", "Luna Base", "ESA", 5, e2);
            repo.asignarExperimento("N003", "Marte Alpha", "NASA", 8, e3);
            repo.asignarExperimento("N004", "Titan Explorer", "JAXA", 4, e4);
            repo.asignarExperimento("N001", "Artemisa II", "NASA", 6, e5);
            repo.asignarExperimento("N005", "Nueva Nave", "CNSA", 10, e6);
        } catch (MisionException ex) {
            System.out.println(ex.getMessage());
        }

        // ============================
        // APARTADO 4: ORDENADOS POR DURACIÓN
        // ============================
        ArrayList<Experimento> ordenadosDuracion = repo.obtenerExperimentosOrdenadosPorDuracion("N001");

        System.out.println("Experimentos de N001 ordenados por duración:");
        for (Experimento e : ordenadosDuracion) {
            System.out.println(e);
        }

        // ============================
        // APARTADO 5: FILTRAR POR CAPACIDAD
        // ============================
        ArrayList<Experimento> filtrados = repo.obtenerExperimentosFiltradosCapacidad(5);

        System.out.println("Experimentos de naves con capacidad > 5:");
        for (Experimento e : filtrados) {
            System.out.println(e);
        }
    }
}
