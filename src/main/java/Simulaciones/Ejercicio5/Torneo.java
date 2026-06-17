package Simulaciones.Ejercicio5;

import java.util.ArrayList;

public class Torneo {

    private ArrayList<Jugador> jugadores;
    private ArrayList<Partido> partidos;

    public Torneo() {
        jugadores = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) throws TorneoException {
        if (jugadores.contains(j)) {
            throw new TorneoException("Jugador ya registrado");
        }
        jugadores.add(j);
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
            System.out.println(p.getJugador1().getNombre() + " vs " +
                    p.getJugador2().getNombre() + " - " + p.getEstado());
        }
    }

    public Jugador getJugadorGanador(Partido p) throws TorneoException {
        Jugador ganador = null;

        if (p.getEstado() == EstadoPartido.PLANIFICADO) {
            throw new TorneoException("El partido no se ha jugado");
        }

        int j1 = 0;
        int j2 = 0;

        for (int i = 0; i < p.getSetsJ1().size(); i++) {
            if (p.getSetsJ1().get(i) > p.getSetsJ2().get(i)) {
                j1++;
            } else {
                j2++;
            }
        }

        if (j1 > j2) ganador = p.getJugador1();
        else ganador = p.getJugador2();

        return ganador;
    }

    public ArrayList<Jugador> jugadoresOrdenados() {
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

