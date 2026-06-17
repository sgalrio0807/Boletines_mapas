package Simulaciones.Ejercicio6;

import java.util.ArrayList;

public class BancoAlimentos {

    private ArrayList<CentroLogistico> centros;

    public BancoAlimentos() {
        centros = new ArrayList<>();
    }

    public void agregarCentro(CentroLogistico c) throws BancoException {
        boolean existe = false;

        for (CentroLogistico x : centros) {
            if (x.getId() == c.getId()) {
                existe = true;
            }
        }

        if (existe) {
            throw new BancoException("El centro ya existe");
        }

        centros.add(c);
    }

    public void agregarTrabajador(Trabajador t) throws BancoException {
        CentroLogistico centro = null;

        for (CentroLogistico c : centros) {
            if (c.getId() == t.getIdCentro()) {
                centro = c;
            }
        }

        if (centro == null) {
            throw new BancoException("El centro no existe");
        }

        boolean repetido = false;

        for (Trabajador x : centro.getTrabajadores()) {
            if (x.equals(t)) {
                repetido = true;
            }
        }

        if (repetido) {
            throw new BancoException("El trabajador ya está en este centro");
        }

        centro.getTrabajadores().add(t);
    }

    public CentroLogistico obtenerCentro(int id) {
        CentroLogistico encontrado = null;

        for (CentroLogistico c : centros) {
            if (c.getId() == id) {
                encontrado = c;
            }
        }

        return encontrado;
    }

    public Trabajador obtenerTrabajador(String dni) {
        Trabajador encontrado = null;

        for (CentroLogistico c : centros) {
            for (Trabajador t : c.getTrabajadores()) {
                if (t.getDni().equalsIgnoreCase(dni)) {
                    encontrado = t;
                }
            }
        }

        return encontrado;
    }
}

