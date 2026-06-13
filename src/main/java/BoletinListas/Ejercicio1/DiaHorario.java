package BoletinListas.Ejercicio1;

public class DiaHorario {
    private String nombreDia;
    private String[] modulos;

    public DiaHorario(String nombreDia, String[] modulos) {
        this.nombreDia = nombreDia;
        this.modulos = new String[6];
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public String[] getModulos() {
        return modulos;
    }

    public void setModulos(int hora, String modulo) {
        modulos[hora] = modulo;
    }
}
