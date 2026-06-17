package Simulaciones.Ejercicio8;

import java.time.LocalDateTime;

public class Partida {

    private static int contador = 1;

    private int id;
    private LocalDateTime fechaHora;
    private Videojuego videojuego;
    private String equipoRival;
    private Resultado resultado;
    private int puntos;

    public Partida(LocalDateTime fechaHora, Videojuego videojuego, String equipoRival, Resultado resultado) {

        this.id = contador;
        contador++;
        this.fechaHora = fechaHora;
        this.videojuego = videojuego;
        this.equipoRival = equipoRival;
        this.resultado = resultado;
        this.puntos = calcularPuntos(resultado);
    }

    private int calcularPuntos(Resultado r) {
        int p = 0;

        if (r == Resultado.VICTORIA) {
            p = 3;
        } else if (r == Resultado.EMPATE) {
            p = 1;
        } else {
            p = 0;
        }

        return p;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public String getEquipoRival() {
        return equipoRival;
    }

    public void setEquipoRival(String equipoRival) {
        this.equipoRival = equipoRival;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
        this.puntos = calcularPuntos(resultado);
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", videojuego=" + videojuego +
                ", equipoRival='" + equipoRival + '\'' +
                ", resultado=" + resultado +
                ", puntos=" + puntos +
                '}';
    }
}

