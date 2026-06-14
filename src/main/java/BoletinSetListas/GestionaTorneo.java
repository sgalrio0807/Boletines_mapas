package BoletinSetListas;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionaTorneo {
    static void main(String[] args) {
        Torneo t = new Torneo();

        try {
            Jugador j1 = new Jugador("Carlos", "Ruiz", "ESP", 5, 1);
            Jugador j2 = new Jugador("Mario", "Lopez", "ARG", 12, 2);
            Jugador j3 = new Jugador("Luis", "Gomez", "CHI", 20, 3);
            Jugador j4 = new Jugador("Pablo", "Santos", "MEX", 30, 4);

            t.agregarJugador(j1);
            t.agregarJugador(j2);
            t.agregarJugador(j3);
            t.agregarJugador(j4);

            ArrayList<Integer> s1 = new ArrayList<>();
            s1.add(6); s1.add(3); s1.add(6);

            ArrayList<Integer> s2 = new ArrayList<>();
            s2.add(4); s2.add(6); s2.add(2);

            Partido p1 = new Partido(j1, j2, EstadoPartido.FINALIZADO, LocalDate.now(), s1, s2);
            Partido p2 = new Partido(j1, j2, EstadoPartido.FINALIZADO, LocalDate.now(), s2, s1);
            Partido p3 = new Partido(j3, j4, EstadoPartido.EN_CURSO, LocalDate.now(), s1, s2);

            t.registrarPartido(p1);
            t.registrarPartido(p2);
            t.registrarPartido(p3);

            System.out.println("Jugadores:");
            t.mostrarJugadores();

            System.out.println("Partidos de jugador 1:");
            t.mostrarPartidosJugador(1);

            System.out.println("Ganador del partido 1:");
            System.out.println(t.getJugadorGanador(p1));

            System.out.println("Probando excepción:");
            t.mostrarPartidosJugador(99);

            System.out.println("Jugadores ordenados:");
            for (Jugador j : t.getJugadoresOrdenados()) {
                System.out.println(j);
            }

        } catch (TorneoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
