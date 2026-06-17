package Simulaciones.Ejercicio8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Usamos HashMap<String, Equipo> porque el código identifica unívocamente a cada equipo y así podemos acceder rápido por código.
public class RepositorioLiga {

    private HashMap<String, Equipo> equipos;

    public RepositorioLiga() {
        equipos = new HashMap<>();
    }

    public void registrarEquipo(Equipo e) throws LigaException {
        if (equipos.containsKey(e.getCodigo())) {
            throw new LigaException("Ya existe un equipo con ese código");
        }
        equipos.put(e.getCodigo(), e);
    }

    public void registrarPartida(String codigoEquipo, LocalDateTime fechaHora, Videojuego videojuego, String rival, Resultado resultado) throws LigaException {

        Equipo e = equipos.get(codigoEquipo);

        if (e == null) {
            throw new LigaException("El equipo no existe");
        }

        Partida p = new Partida(fechaHora, videojuego, rival, resultado);
        e.getPartidas().add(p);
    }

    public List<Partida> obtenerPartidasEquipoOrdenadas(String codigoEquipo) throws LigaException {

        Equipo e = equipos.get(codigoEquipo);

        if (e == null) {
            throw new LigaException("El equipo no existe");
        }

        ArrayList<Partida> lista = new ArrayList<>(e.getPartidas());

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                Partida a = lista.get(i);
                Partida b = lista.get(j);

                if (a.getFechaHora().isAfter(b.getFechaHora())) {
                    Partida aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }

    public List<Partida> obtenerPartidasPorVideojuego(String codigoEquipo, Videojuego v) throws LigaException {

        Equipo e = equipos.get(codigoEquipo);

        if (e == null) {
            throw new LigaException("El equipo no existe");
        }

        ArrayList<Partida> lista = new ArrayList<>();

        for (Partida p : e.getPartidas()) {
            if (p.getVideojuego() == v) {
                lista.add(p);
            }
        }

        return lista;
    }

    public int getPuntuacionTotal(String codigoEquipo) throws LigaException {

        Equipo e = equipos.get(codigoEquipo);

        if (e == null) {
            throw new LigaException("El equipo no existe");
        }

        int total = 0;

        for (Partida p : e.getPartidas()) {
            total = total + p.getPuntos();
        }

        return total;
    }

    public List<Equipo> getClasificacionGeneral() {

        ArrayList<Equipo> lista = new ArrayList<>(equipos.values());

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                Equipo a = lista.get(i);
                Equipo b = lista.get(j);

                int puntosA = 0;
                int puntosB = 0;

                for (Partida p : a.getPartidas()) {
                    puntosA = puntosA + p.getPuntos();
                }

                for (Partida p : b.getPartidas()) {
                    puntosB = puntosB + p.getPuntos();
                }

                boolean cambiar = false;

                if (puntosA < puntosB) {
                    cambiar = true;
                } else if (puntosA == puntosB &&
                        a.getNombre().compareToIgnoreCase(b.getNombre()) > 0) {
                    cambiar = true;
                }

                if (cambiar) {
                    Equipo aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }
}

