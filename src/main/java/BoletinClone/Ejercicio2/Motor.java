package BoletinClone.Ejercicio2;

public class Motor {

    private String tipo;
    private int cv;
    private boolean enMarcha;

    public Motor(String tipo, int cv, boolean enMarcha) {
        this.tipo = tipo;
        this.cv = cv;
        this.enMarcha = enMarcha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public boolean isEnMarcha() {
        return enMarcha;
    }

    public void setEnMarcha(boolean enMarcha) {
        this.enMarcha = enMarcha;
    }

    public Motor clonar() {
        Motor copia = new Motor(tipo, cv, enMarcha);
        return copia;
    }

    @Override
    public String toString() {
        return "Motor tipo: " + tipo + ", CV: " + cv + ", enMarcha: " + enMarcha;
    }
}


