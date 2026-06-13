package BoletinListas.Ejercicio2;

import java.util.HashSet;

public class Equipo {

    private String nombreEquipo;
    private HashSet<Alumno> alumnos;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.alumnos = new HashSet<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public boolean equals(Object o) {
        boolean iguales = false;

        if (o instanceof Equipo) {
            Equipo otro = (Equipo) o;
            if (this.nombreEquipo.equalsIgnoreCase(otro.nombreEquipo)) {
                iguales = true;
            }
        }

        return iguales; 
    }

    @Override
    public int hashCode() {
        return nombreEquipo.toLowerCase().hashCode();
    }

    public void addAlumno(Alumno a) throws DeportivosException {
        if (alumnos.contains(a)) {
            throw new DeportivosException("El alumno ya está en el equipo");
        }
        alumnos.add(a);
    }

    public void borrarAlumno(Alumno a) throws DeportivosException {
        if (!alumnos.contains(a)) {
            throw new DeportivosException("El alumno no existe en el equipo");
        }
        alumnos.remove(a);
    }

    public Alumno pertenece(Alumno a) {
        Alumno resultado = null;

        for (Alumno x : alumnos) {
            if (x.equals(a)) {
                resultado = x;
            }
        }

        return resultado;
    }

    public void mostrarAlumnos() {
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }

    public Equipo union(Equipo otro) {
        Equipo nuevo = new Equipo(this.nombreEquipo + "_UNION_" + otro.nombreEquipo);

        nuevo.alumnos.addAll(this.alumnos);
        nuevo.alumnos.addAll(otro.alumnos);

        return nuevo;
    }

    public Equipo interseccion(Equipo otro) {
        Equipo nuevo = new Equipo(this.nombreEquipo + "_INTER_" + otro.nombreEquipo);

        for (Alumno a : this.alumnos) {
            if (otro.alumnos.contains(a)) {
                nuevo.alumnos.add(a);
            }
        }

        return nuevo;
    }
}
