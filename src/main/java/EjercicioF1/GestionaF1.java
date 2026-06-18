package EjercicioF1;

import java.util.List;

public class GestionaF1 {
    static void main(String[] args) {
        RepositorioF1 repo = new RepositorioF1();

        Escuderia e1 = new Escuderia("Red Bull", "EEUU", 8);
        Escuderia e2 = new Escuderia("Aston Martin", "Francia", 3);
        Escuderia e3 = new Escuderia("Mercedes", "España", 7);
        Escuderia e4 = new Escuderia("Haas", "Italia", 5);

        Piloto p1 = new Piloto(1, "Sebastián Vettel", 50);
        Piloto p2 = new Piloto(2, "Fernando Alonso", 200);
        Piloto p3 = new Piloto(3, "Leclerc", 30);
        Piloto p4 = new Piloto(4, "Mario García", 150);
        Piloto p5 = new Piloto(5, "Lewis Hamilton", 180);
        Piloto p6 = new Piloto(6, "Gonzalo Benítez", 60);

        try {
            repo.agregarPilotoAEscuderia(e1, p1);
            repo.agregarPilotoAEscuderia(e1, p5);
            repo.agregarPilotoAEscuderia(e2, p2);
            repo.agregarPilotoAEscuderia(e3, p3);
            repo.agregarPilotoAEscuderia(e4, p4);
            repo.agregarPilotoAEscuderia(e4, p6);
        } catch (F1Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Pilotos de Red Bull ordenados por puntos:");
            List<Piloto> ordenados = repo.getOrdenadosPorPuntos("Red Bull");
            for (Piloto p : ordenados) {
                System.out.println(p);
            }
        } catch (F1Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Pilotos de escuderías con menos de 6 trofeos:");
        List<Piloto> filtrados = repo.getPilotosDeEscuderiasSegunNumPremios(6);
        for (Piloto p : filtrados) {
            System.out.println(p);
        }
    }
}
