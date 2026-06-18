package EjercicioF1;

import java.util.*;

public class RepositorioF1 {

    // Mapa principal: cada escudería tiene su lista de pilotos
    // Justificación: uso HashMap porque no permite claves duplicadas (escuderías únicas)
    private HashMap<Escuderia, ArrayList<Piloto>> mapaEscuderias;

    public RepositorioF1() {
        this.mapaEscuderias = new HashMap<>();
    }

    // Apartado 2: comprobar si existe una escudería
    public boolean existeEscuderia(String nombre) {
        for (Escuderia e : mapaEscuderias.keySet()) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    // Apartado 3: agregar piloto a una escudería
    public void agregarPilotoAEscuderia(Escuderia escuderia, Piloto piloto) throws F1Exception {

        ArrayList<Piloto> lista = mapaEscuderias.get(escuderia);

        // Si la escudería no existe, se crea automáticamente
        if (lista == null) {
            lista = new ArrayList<>();
            mapaEscuderias.put(escuderia, lista);
        }

        // Comprobar si el piloto ya existe
        if (lista.contains(piloto)) {
            throw new F1Exception("El piloto ya está registrado en esta escudería");
        }

        lista.add(piloto);
    }

    // Apartado 4: obtener pilotos ordenados por puntos (mayor a menor)
    public List<Piloto> getOrdenadosPorPuntos(String nombreEscuderia) throws F1Exception {

        for (Escuderia e : mapaEscuderias.keySet()) {
            if (e.getNombre().equalsIgnoreCase(nombreEscuderia)) {
                ArrayList<Piloto> lista = new ArrayList<>(mapaEscuderias.get(e));

                Collections.sort(lista, new Comparator<Piloto>() {
                    @Override
                    public int compare(Piloto p1, Piloto p2) {
                        return Integer.compare(p2.getPuntosTemporada(), p1.getPuntosTemporada());
                    }
                });

                return lista;
            }
        }

        throw new F1Exception("La escudería no está registrada en el sistema");
    }

    // Apartado 5: obtener pilotos de escuderías con menos trofeos que el valor recibido
    public List<Piloto> getPilotosDeEscuderiasSegunNumPremios(int maxTrofeos) {

        ArrayList<Piloto> resultado = new ArrayList<>();

        for (Escuderia e : mapaEscuderias.keySet()) {
            if (e.getTrofeosGanados() < maxTrofeos) {
                resultado.addAll(mapaEscuderias.get(e));
            }
        }

        // Ordenar por nombre
        Collections.sort(resultado, new Comparator<Piloto>() {
            @Override
            public int compare(Piloto p1, Piloto p2) {
                return p1.getNombreCompleto().compareToIgnoreCase(p2.getNombreCompleto());
            }
        });

        return resultado;
    }
}
