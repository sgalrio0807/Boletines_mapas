package BoletinOrdenaciones2.Ejercicio3;

import java.util.Objects;

public class Usuario {

    private static int contador = 1;

    private int id;
    private String nombreCompleto;
    private String email;

    public Usuario(String nombreCompleto, String email) {
        this.id = contador;
        contador++;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

