package BoletinListas.Ejercicio1;

import java.util.ArrayList;

public class Horario {
    private ArrayList<DiaHorario> dias;

    public Horario() {
        this.dias = new ArrayList<>();
    }

    public void agregarDia(DiaHorario dia) {
        this.dias.add(dia);
    }

    public ArrayList<DiaHorario> getDias() {
        return dias;
    }

    public void setDias(ArrayList<DiaHorario> dias) {
        this.dias = dias;
    }
}


