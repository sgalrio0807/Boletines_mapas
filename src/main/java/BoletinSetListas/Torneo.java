package BoletinSetListas;

import java.util.ArrayList;
import java.util.HashSet;

public class Torneo {

    private HashSet<Jugador> jugadores;   // sin repetidos
    private ArrayList<Partido> partidos;  // se permiten repetidos

    public Torneo() {
        jugadores = new HashSet<>();
        partidos = new ArrayList<>();
    }

    public HashSet<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(HashSet<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void agregarJugador(Jugador j) throws TorneoException {
        boolean añadido = jugadores.add(j);
        if (!añadido) {
            throw new TorneoException("Jugador ya registrado");
        }
    }

    public void registrarPartido(Partido p) {
        partidos.add(p);
        p.getJugador1().getPartidos().add(p);
        p.getJugador2().getPartidos().add(p);
    }

    public void mostrarJugadores() {
        for (Jugador j : jugadores) {
            System.out.println(j);
        }
    }

    public void mostrarPartidosJugador(int numeroFicha) throws TorneoException {
        Jugador encontrado = null;

        for (Jugador j : jugadores) {
            if (j.getNumeroFicha() == numeroFicha) {
                encontrado = j;
            }
        }

        if (encontrado == null) {
            throw new TorneoException("Jugador no encontrado");
        }

        for (Partido p : encontrado.getPartidos()) {
            System.out.println("Partido: " + p.getJugador1().getNombre() + " vs " +
                    p.getJugador2().getNombre() + " - " + p.getEstado());
        }
    }

    public Jugador getJugadorGanador(Partido p) throws TorneoException {
        Jugador ganador = null;

        if (p.getEstado() == EstadoPartido.PLANIFICADO) {
            throw new TorneoException("El partido no se ha jugado");
        }

        int setsGanadosJ1 = 0;
        int setsGanadosJ2 = 0;

        for (int i = 0; i < p.getSetsJ1().size(); i++) {
            if (p.getSetsJ1().get(i) > p.getSetsJ2().get(i)) {
                setsGanadosJ1++;
            } else {
                setsGanadosJ2++;
            }
        }

        if (setsGanadosJ1 > setsGanadosJ2) {
            ganador = p.getJugador1();
        } else {
            ganador = p.getJugador2();
        }

        return ganador;
    }

    public ArrayList<Jugador> getJugadoresOrdenados() {
        ArrayList<Jugador> lista = new ArrayList<>(jugadores);

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                Jugador a = lista.get(i);
                Jugador b = lista.get(j);

                boolean cambiar = false;

                if (a.getApellido().compareToIgnoreCase(b.getApellido()) > 0) {
                    cambiar = true;
                } else if (a.getApellido().equalsIgnoreCase(b.getApellido()) &&
                        a.getNombre().compareToIgnoreCase(b.getNombre()) > 0) {
                    cambiar = true;
                } else if (a.getApellido().equalsIgnoreCase(b.getApellido()) &&
                        a.getNombre().equalsIgnoreCase(b.getNombre()) &&
                        a.getNumeroFicha() > b.getNumeroFicha()) {
                    cambiar = true;
                }

                if (cambiar) {
                    Jugador aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }

}

