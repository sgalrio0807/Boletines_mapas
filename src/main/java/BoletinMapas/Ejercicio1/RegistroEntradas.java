package BoletinMapas.Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;

public class RegistroEntradas {

    private HashSet<EntradaVIP> entradas;

    public RegistroEntradas() {
        entradas = new HashSet<>();
    }

    public boolean añadirEntrada(EntradaVIP e) {
        boolean existe = false;

        for (EntradaVIP x : entradas) {
            if (x.getInfluencer().equals(e.getInfluencer())) {
                existe = true;
            }
        }

        boolean añadida = false;

        if (!existe) {
            entradas.add(e);
            añadida = true;
        }

        return añadida;
    }

    public EntradaVIP buscarEntrada(String nick, String plataforma) {
        EntradaVIP encontrada = null;

        for (EntradaVIP e : entradas) {
            Influencer i = e.getInfluencer();

            if (i.getNick().equalsIgnoreCase(nick) &&
                    i.getPlataforma().equalsIgnoreCase(plataforma)) {
                encontrada = e;
            }
        }

        return encontrada;
    }

    public boolean confirmar(String nick, String plataforma) {
        boolean cambiado = false;

        EntradaVIP e = buscarEntrada(nick, plataforma);

        if (e != null) {
            e.setEstado(EstadoEntrada.CONFIRMADA);
            cambiado = true;
        }

        return cambiado;
    }

    public boolean cancelar(String nick, String plataforma) {
        boolean cambiado = false;

        EntradaVIP e = buscarEntrada(nick, plataforma);

        if (e != null) {
            e.setEstado(EstadoEntrada.CANCELADA);
            cambiado = true;
        }

        return cambiado;
    }

    public ArrayList<EntradaVIP> listarConfirmados() {
        ArrayList<EntradaVIP> lista = new ArrayList<>();

        for (EntradaVIP e : entradas) {
            if (e.getEstado() == EstadoEntrada.CONFIRMADA) {
                lista.add(e);
            }
        }

        return lista;
    }

    public ArrayList<EntradaVIP> listarCancelados() {
        ArrayList<EntradaVIP> lista = new ArrayList<>();

        for (EntradaVIP e : entradas) {
            if (e.getEstado() == EstadoEntrada.CANCELADA) {
                lista.add(e);
            }
        }

        return lista;
    }

    public ArrayList<EntradaVIP> listarPendientes() {
        ArrayList<EntradaVIP> lista = new ArrayList<>();

        for (EntradaVIP e : entradas) {
            if (e.getEstado() == EstadoEntrada.ENVIADA) {
                lista.add(e);
            }
        }

        return lista;
    }

    public ArrayList<Influencer> top3Influencers() {
        ArrayList<Influencer> lista = new ArrayList<>();

        for (EntradaVIP e : entradas) {
            lista.add(e.getInfluencer());
        }

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getNumSeguidores() < lista.get(j).getNumSeguidores()) {
                    Influencer aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        while (lista.size() > 3) {
            lista.remove(lista.size() - 1);
        }

        return lista;
    }
}

