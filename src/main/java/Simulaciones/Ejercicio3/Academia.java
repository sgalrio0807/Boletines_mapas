package Simulaciones.Ejercicio3;

import java.util.ArrayList;

public class Academia {

    private ArrayList<Taller> talleres;

    public Academia() {
        talleres = new ArrayList<>();
    }

    public void añadirTaller(Taller t) {
        talleres.add(t);
    }

    public Taller buscarTallerPorNombre(String nombre) {
        Taller encontrado = null;

        for (Taller t : talleres) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = t;
            }
        }

        return encontrado;
    }

    public void inscribirAlumno(String nombreTaller, Alumno a) throws InscripcionException {

        Taller t = buscarTallerPorNombre(nombreTaller);

        if (t == null) {
            throw new InscripcionException("No existe el taller");
        }

        if (a.getEdad() < t.getEdadMinima()) {
            throw new InscripcionException("Edad insuficiente para el taller");
        }

        if (t.getAlumnos().size() >= t.getAforoMaximo()) {
            throw new InscripcionException("Aforo completo");
        }

        boolean añadido = t.getAlumnos().add(a);

        if (!añadido) {
            throw new InscripcionException("El alumno ya está inscrito en este taller");
        }
    }

    public void mostrarAlumnosDeTaller(String nombreTaller) {
        Taller t = buscarTallerPorNombre(nombreTaller);

        if (t != null) {
            for (Alumno a : t.getAlumnos()) {
                System.out.println(a);
            }
        }
    }

    public ArrayList<Taller> talleresPorNumeroAlumnos() {
        ArrayList<Taller> lista = new ArrayList<>(talleres);

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                if (lista.get(i).getAlumnos().size() < lista.get(j).getAlumnos().size()) {
                    Taller aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }

    public ArrayList<Alumno> alumnosDeTaller(String nombreTaller) {
        ArrayList<Alumno> lista = new ArrayList<>();

        Taller t = buscarTallerPorNombre(nombreTaller);

        if (t != null) {
            lista.addAll(t.getAlumnos());
        }

        return lista;
    }

    public ArrayList<Alumno> alumnosMayoresDe(String nombreTaller, int edad) {
        ArrayList<Alumno> lista = new ArrayList<>();

        Taller t = buscarTallerPorNombre(nombreTaller);

        if (t != null) {
            for (Alumno a : t.getAlumnos()) {
                if (a.getEdad() > edad) {
                    lista.add(a);
                }
            }
        }

        return lista;
    }
}

