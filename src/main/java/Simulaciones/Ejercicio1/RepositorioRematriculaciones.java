package Simulaciones.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class RepositorioRematriculaciones {

    private HashSet<Vehiculo> vehiculos;

    public RepositorioRematriculaciones() {
        vehiculos = new HashSet<>();
    }

    public boolean registrarVehiculo(Vehiculo v) {
        boolean añadido = vehiculos.add(v);
        return añadido;
    }

    public Vehiculo buscarPorVin(String vin) {
        Vehiculo encontrado = null;

        for (Vehiculo v : vehiculos) {
            if (v.getVin().equalsIgnoreCase(vin)) {
                encontrado = v;
            }
        }

        return encontrado;
    }

    public void registrarRematriculacion(String vin, String nuevaMatricula, LocalDate fecha)
            throws RegistroException {

        Vehiculo v = buscarPorVin(vin);

        if (v == null) {
            throw new RegistroException("Vehículo no encontrado");
        }

        for (Matriculacion m : v.getHistorico()) {
            if (m.getFecha().equals(fecha)) {
                throw new RegistroException("Ya existe una matriculación ese día");
            }
        }

        v.getHistorico().add(new Matriculacion(nuevaMatricula, fecha));
        v.setMatriculaActual(nuevaMatricula);
    }

    public ArrayList<Vehiculo> vehiculosPorPropietario(String propietario) {
        ArrayList<Vehiculo> lista = new ArrayList<>();

        for (Vehiculo v : vehiculos) {
            if (v.getPropietario().equalsIgnoreCase(propietario)) {
                lista.add(v);
            }
        }

        // ordenar por matrícula actual
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getMatriculaActual()
                        .compareToIgnoreCase(lista.get(j).getMatriculaActual()) > 0) {

                    Vehiculo aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }

    public ArrayList<Matriculacion> historialOrdenado(String vin) {
        ArrayList<Matriculacion> lista = new ArrayList<>();

        Vehiculo v = buscarPorVin(vin);

        if (v != null) {
            lista = v.getHistorico();
        }

        // ordenar por fecha
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getFecha().isAfter(lista.get(j).getFecha())) {
                    Matriculacion aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        return lista;
    }
}

