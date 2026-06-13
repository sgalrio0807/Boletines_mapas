package BoletinListas.Ejercicio1;

public class Gestiona {
    static void main(String[] args) {
        Instituto instituto = new Instituto();
        Grupo g1 = new Grupo("g1", "Dam1", "Javi", "Aula1");
        instituto.agregarGrupo(g1);

        Estudiante e1 = new Estudiante("Sergio", "111");
        e1.agregarNota(7);
        e1.agregarNota(8);
        g1.agregarEstudiante(e1);

        try {
            instituto.mostarInfoBasicaGrupo("Dam1");
            System.out.println("Promedio Sergio: " + instituto.promedioEstudiantes("111", "Dam1"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
