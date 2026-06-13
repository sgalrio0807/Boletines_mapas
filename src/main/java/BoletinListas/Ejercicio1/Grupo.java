package BoletinListas.Ejercicio1;

import java.util.ArrayList;

public class Grupo {
    private String identificador;
    private String descripcion;
    private ArrayList<Estudiante> estudiantes;
    private String tutor;
    private String aula;
    private Horario horario;

    public Grupo(String identificador, String descripcion, String tutor, String aula) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.tutor = tutor;
        this.aula = aula;
        this.estudiantes = new ArrayList<>();
        this.horario = new Horario();
    }

    public void agregarEstudiante(Estudiante estudiante){
        this.estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiantePorId(String id){
        Estudiante encontrado = null;
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getId().equalsIgnoreCase(id)) {
                encontrado = estudiante;
            }
        }
        return encontrado;
    }

    public double promedioGrupo() throws Exception{
        if (estudiantes.size()==0){
            throw new Exception("El grupo no tiene estudiantes");
        }
        double suma = 0;
        int contador = 0;
        for (Estudiante estudiante : this.estudiantes) {
            suma = suma + estudiante.calcularPromedio();
            contador++;
        }
        double promedio = suma/contador;
        return promedio;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
