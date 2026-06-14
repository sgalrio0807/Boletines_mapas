package BoletinMapas.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class RegistroTrafico {

    private HashSet<Vehiculo> vehiculos;

    public RegistroTrafico() {
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

        for (Rematriculacion r : v.getRematriculaciones()) {
            if (r.getFecha().equals(fecha)) {
                throw new RegistroException("Ya existe una rematriculación ese día");
            }
        }

        Rematriculacion nueva = new Rematriculacion(
                vin,
                v.getMatriculaActual(),
                nuevaMatricula,
                fecha
        );

        v.getRematriculaciones().add(nueva);
        v.setMatriculaActual(nuevaMatricula);
    }

    public ArrayList<Vehiculo> vehiculosPorPropietario(String propietario) {
        ArrayList<Vehiculo> lista = new ArrayList<>();

        for (Vehiculo v : vehiculos) {
            if (v.getPropietario().equalsIgnoreCase(propietario)) {
                lista.add(v);
            }
        }

        // ordenar por matrícula
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

    public ArrayList<Rematriculacion> rematriculacionesPorAño(int año) {
        ArrayList<Rematriculacion> lista = new ArrayList<>();

        for (Vehiculo v : vehiculos) {
            for (Rematriculacion r : v.getRematriculaciones()) {
                if (r.getFecha().getYear() == año) {
                    lista.add(r);
                }
            }
        }

        return lista;
    }

    public ArrayList<Rematriculacion> historialVehiculo(String vin) {
        ArrayList<Rematriculacion> lista = new ArrayList<>();

        Vehiculo v = buscarPorVin(vin);

        if (v != null) {
            lista = v.getRematriculaciones();
        }

        return lista;
    }
}

