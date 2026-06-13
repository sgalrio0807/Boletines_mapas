package BoletinListas.Ejercicio1;

import java.util.ArrayList;

public class Instituto {
    private ArrayList<Grupo> grupos;

    public Instituto() {
        this.grupos = new ArrayList<>();
    }

    public void agregarGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public Grupo buscarGrupoPorDescripcion(String descripcion) {
        Grupo encontrado = null;
        for (Grupo grupo : this.grupos) {
            if (grupo.getDescripcion().equalsIgnoreCase(descripcion)) {
                encontrado = grupo;
            }
        }
        return encontrado;
    }
    public void mostrarEstudiantesPorGrupo(String descripcion) throws Exception {
        Grupo grupo = this.buscarGrupoPorDescripcion(descripcion);
        if (grupo == null) {
            throw new Exception("Grupo no encontrado");
        }
        for (Estudiante estudiante : grupo.getEstudiantes()) {
            System.out.println(estudiante.getNombre() + " - " + estudiante.getNotas());
        }
    }

    public void mostarInfoBasicaGrupo(String descripcion) throws Exception {
        Grupo grupo = this.buscarGrupoPorDescripcion(descripcion);
        if (grupo == null) {
            throw new Exception("Grupo no encontrado");
        }
        System.out.println("Descripción: " + grupo.getDescripcion());
        System.out.println("Tutor: " + grupo.getTutor());
        System.out.println("Número de estudiantes: " + grupo.getEstudiantes().size());
    }

    public double promedioEstudiantes(String idEstudiante, String descripcionGrupo) throws Exception {
        Grupo grupo = this.buscarGrupoPorDescripcion(descripcionGrupo);
        if (grupo == null) {
            throw new Exception("Grupo no encontrado");
        }
        Estudiante estudiante = grupo.buscarEstudiantePorId(idEstudiante);
        if (estudiante == null) {
            throw new Exception("Estudiante no encontrado");
        }
        double promedio = estudiante.calcularPromedio();
        return promedio;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
}
