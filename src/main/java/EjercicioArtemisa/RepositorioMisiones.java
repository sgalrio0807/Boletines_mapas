package EjercicioArtemisa;

import java.util.*;

public class RepositorioMisiones {

    private HashMap<NaveEspacial, ArrayList<Experimento>> misiones;

    public RepositorioMisiones() {
        this.misiones = new HashMap<>();
    }

    // ============================================================
    // 2. Comprobar si existe una nave
    // ============================================================
    public boolean existeNave(String codigoNave) {
        boolean existe = false;

        for (NaveEspacial n : misiones.keySet()) {
            if (n.getCodigoNave().equalsIgnoreCase(codigoNave)) {
                existe = true;
            }
        }

        return existe;
    }

    // ============================================================
    // 3. Asignar experimento a una nave
    // ============================================================
    public void asignarExperimento(String codigoNave, String nombreMision, String agencia,
                                   int capacidad, Experimento experimento) throws MisionException {

        NaveEspacial naveEncontrada = null;

        // Buscar la nave
        for (NaveEspacial n : misiones.keySet()) {
            if (n.getCodigoNave().equalsIgnoreCase(codigoNave)) {
                naveEncontrada = n;
            }
        }

        // Si no existe, crearla
        if (naveEncontrada == null) {
            naveEncontrada = new NaveEspacial(codigoNave, nombreMision, agencia, capacidad);
            misiones.put(naveEncontrada, new ArrayList<>());
        }

        ArrayList<Experimento> lista = misiones.get(naveEncontrada);

        boolean existe = false;
        for (Experimento e : lista) {
            if (e.equals(experimento)) {
                existe = true;
            }
        }

        if (existe) {
            throw new MisionException("El experimento ya está asignado a esta nave");
        }

        lista.add(experimento);

        // Ordenar por fecha
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                Experimento e1 = lista.get(i);
                Experimento e2 = lista.get(j);

                if (e1.getFechaEjecucion().isAfter(e2.getFechaEjecucion())) {
                    Experimento aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }
    }

    // ============================================================
    // 4. Obtener experimentos ordenados por duración (mayor a menor)
    // ============================================================
    public ArrayList<Experimento> obtenerExperimentosOrdenadosPorDuracion(String codigoNave) {

        ArrayList<Experimento> resultado = new ArrayList<>();

        for (NaveEspacial n : misiones.keySet()) {
            if (n.getCodigoNave().equalsIgnoreCase(codigoNave)) {
                resultado = new ArrayList<>(misiones.get(n));
            }
        }

        // Ordenar solo si hay datos
        for (int i = 0; i < resultado.size() - 1; i++) {
            for (int j = i + 1; j < resultado.size(); j++) {

                Experimento e1 = resultado.get(i);
                Experimento e2 = resultado.get(j);

                boolean mayorDuracion = e1.getDuracionHoras() < e2.getDuracionHoras();
                boolean igualDuracion = e1.getDuracionHoras() == e2.getDuracionHoras();
                boolean ordenAlfabetico = e1.getIdExperimento().compareToIgnoreCase(e2.getIdExperimento()) > 0;

                if (mayorDuracion || (igualDuracion && ordenAlfabetico)) {
                    Experimento aux = resultado.get(i);
                    resultado.set(i, resultado.get(j));
                    resultado.set(j, aux);
                }
            }
        }

        return resultado;
    }

    // ============================================================
    // 5. Obtener experimentos de naves con capacidad superior
    // ============================================================
    public ArrayList<Experimento> obtenerExperimentosFiltradosCapacidad(int capacidad) {

        ArrayList<Experimento> resultado = new ArrayList<>();

        for (NaveEspacial n : misiones.keySet()) {
            if (n.getCapacidadTripulacion() > capacidad) {
                ArrayList<Experimento> lista = misiones.get(n);

                for (Experimento e : lista) {
                    resultado.add(e);
                }
            }
        }

        return resultado;
    }
}
