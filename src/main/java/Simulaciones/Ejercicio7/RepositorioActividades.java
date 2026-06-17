package Simulaciones.Ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepositorioActividades {

    // HashSet evita actividades duplicadas (mismo nombre + fecha)
    private HashSet<Actividad> actividades;

    public RepositorioActividades() {
        actividades = new HashSet<>();
    }

    public void agregarActividad(Actividad a) {
        actividades.add(a);
    }

    public void agregarAlumnoActividad(String nombreActividad, LocalDate fechaActividad, Alumno a) throws GuarderiaException {

        Actividad encontrada = null;

        for (Actividad act : actividades) {
            if (act.getNombre().equalsIgnoreCase(nombreActividad) &&
                    act.getFecha().equals(fechaActividad)) {
                encontrada = act;
            }
        }

        if (encontrada == null) {
            throw new GuarderiaException("La actividad no existe");
        }

        if (a.getEdad() != encontrada.getEdadRecomendada()) {
            throw new GuarderiaException("Edad no recomendada");
        }

        if (encontrada.getAlumnos().size() >= encontrada.getMaxAlumnos()) {
            throw new GuarderiaException("Aforo completo");
        }

        boolean repetido = false;
        for (Alumno al : encontrada.getAlumnos()) {
            if (al.equals(a)) {
                repetido = true;
            }
        }

        if (repetido) {
            throw new GuarderiaException("Alumno ya apuntado");
        }

        encontrada.getAlumnos().add(a);
    }

    public boolean isAlumnoApuntado(String nombreActividad, LocalDate fechaActividad, Alumno a) throws GuarderiaException {

        Actividad encontrada = null;

        for (Actividad act : actividades) {
            if (act.getNombre().equalsIgnoreCase(nombreActividad) &&
                    act.getFecha().equals(fechaActividad)) {
                encontrada = act;
            }
        }

        if (encontrada == null) {
            throw new GuarderiaException("La actividad no existe");
        }

        boolean apuntado = false;

        for (Alumno al : encontrada.getAlumnos()) {
            if (al.equals(a)) {
                apuntado = true;
            }
        }

        return apuntado;
    }

    public List<Alumno> getAlumnadoConAlergias(String nombreActividad, LocalDate fechaActividad) throws GuarderiaException {

        Actividad encontrada = null;

        for (Actividad act : actividades) {
            if (act.getNombre().equalsIgnoreCase(nombreActividad) &&
                    act.getFecha().equals(fechaActividad)) {
                encontrada = act;
            }
        }

        if (encontrada == null) {
            throw new GuarderiaException("La actividad no existe");
        }

        List<Alumno> lista = new ArrayList<>();

        for (Alumno a : encontrada.getAlumnos()) {
            if (a.getAlergias() != null && a.getAlergias().size() > 0) {
                lista.add(a);
            }
        }

        return lista;
    }

    public List<Actividad> getListaActividades() {

        List<Actividad> lista = new ArrayList<>(actividades);

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                Actividad a = lista.get(i);
                Actividad b = lista.get(j);

                if (a.getFecha().isAfter(b.getFecha())) {
                    Actividad aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }
}

