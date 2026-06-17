package Simulaciones.Ejercicio4;

import java.util.Objects;

public class Usuario implements Comparable<Usuario> {

    private String nombre;
    private String password;

    public Usuario(String nombre, String password) throws UserMemoryException {
        if (nombre == null || nombre.length() < 6) {
            throw new UserMemoryException("Usuario no es correcto");
        }
        if (!passwordValida(password)) {
            throw new UserMemoryException("La clave no cumple alguno de estos requisitos: contiene mayúsuculas, minúsculas y números y tiene 8 o más caracteres");
        }
        this.nombre = nombre;
        this.password = password;
    }

    private boolean passwordValida(String pass) {
        boolean valida = false;

        if (pass != null && pass.length() >= 8) {
            boolean may = false;
            boolean min = false;
            boolean num = false;

            for (int i = 0; i < pass.length(); i++) {
                char c = pass.charAt(i);
                if (Character.isUpperCase(c)) {
                    may = true;
                } else if (Character.isLowerCase(c)) {
                    min = true;
                } else if (Character.isDigit(c)) {
                    num = true;
                }
            }

            if (may && min && num) {
                valida = true;
            }
        }

        return valida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws UserMemoryException {
        if (!passwordValida(password)) {
            throw new UserMemoryException("La clave no cumple alguno de estos requisitos: contiene mayúsuculas, minúsculas y números y tiene 8 o más caracteres");
        }
        this.password = password;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}

