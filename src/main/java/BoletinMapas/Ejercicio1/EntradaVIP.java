package BoletinMapas.Ejercicio1;

import java.time.LocalDate;

public class EntradaVIP {
    private String codigo;
    private LocalDate fecha;
    private TipoEntrada tipo;
    private EstadoEntrada estado;
    private Influencer influencer;

    public EntradaVIP(String codigo, LocalDate fecha, TipoEntrada tipo, Influencer influencer) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = EstadoEntrada.ENVIADA;
        this.influencer = influencer;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrada tipo) {
        this.tipo = tipo;
    }

    public EstadoEntrada getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntrada estado) {
        this.estado = estado;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    @Override
    public String toString() {
        return "EntradaVip{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", tipo=" + tipo +
                ", estado=" + estado +
                ", influencer=" + influencer +
                '}';
    }
}
