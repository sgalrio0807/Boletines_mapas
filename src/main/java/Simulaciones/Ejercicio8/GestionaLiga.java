package Simulaciones.Ejercicio8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class GestionaLiga {
    static void main(String[] args) {
        {
            RepositorioLiga repo = new RepositorioLiga();

            try {
                Equipo e1 = new Equipo("TM01", "ThunderMonkeys", "España", LocalDate.of(2018, 3, 10));
                Equipo e2 = new Equipo("DR02", "DragonRiders", "Francia", LocalDate.of(2019, 6, 5));
                Equipo e3 = new Equipo("WK03", "WarKings", "Alemania", LocalDate.of(2020, 1, 20));

                repo.registrarEquipo(e1);
                repo.registrarEquipo(e2);
                repo.registrarEquipo(e3);

                // Intento de equipo duplicado
                try {
                    repo.registrarEquipo(new Equipo("TM01", "OtroNombre", "Italia", LocalDate.of(2021, 1, 1)));
                } catch (LigaException ex) {
                    System.out.println("EXCEPCIÓN ESPERADA: " + ex.getMessage());
                }

                // Registrar partidas
                repo.registrarPartida("TM01",
                        LocalDateTime.of(2024, 5, 1, 18, 0), Videojuego.LEAGUE_OF_LEGENDS, "DragonRiders", Resultado.VICTORIA);

                repo.registrarPartida("TM01",
                        LocalDateTime.of(2024, 5, 3, 20, 0), Videojuego.VALORANT, "WarKings", Resultado.DERROTA);

                repo.registrarPartida("TM01",
                        LocalDateTime.of(2024, 5, 5, 19, 30), Videojuego.FIFA, "RandomTeam", Resultado.EMPATE);

                repo.registrarPartida("DR02",
                        LocalDateTime.of(2024, 5, 2, 17, 0), Videojuego.LEAGUE_OF_LEGENDS, "ThunderMonkeys", Resultado.DERROTA);

                repo.registrarPartida("DR02",
                        LocalDateTime.of(2024, 5, 4, 21, 0), Videojuego.CS2, "WarKings", Resultado.VICTORIA);

                repo.registrarPartida("DR02",
                        LocalDateTime.of(2024, 5, 6, 16, 0), Videojuego.ROCKET_LEAGUE, "RandomTeam2", Resultado.EMPATE);

                repo.registrarPartida("WK03",
                        LocalDateTime.of(2024, 5, 1, 19, 0), Videojuego.VALORANT, "ThunderMonkeys", Resultado.VICTORIA);

                repo.registrarPartida("WK03",
                        LocalDateTime.of(2024, 5, 3, 18, 30), Videojuego.CS2, "DragonRiders", Resultado.DERROTA);

                repo.registrarPartida("WK03",
                        LocalDateTime.of(2024, 5, 7, 20, 15), Videojuego.FIFA, "RandomTeam3", Resultado.VICTORIA);

                System.out.println("Partidas de TM01 ordenadas por fecha:");
                List<Partida> partidasTM = repo.obtenerPartidasEquipoOrdenadas("TM01");
                for (Partida p : partidasTM) {
                    System.out.println(p);
                }

                System.out.println("Partidas de DR02 en CS2:");
                List<Partida> partidasCS2 = repo.obtenerPartidasPorVideojuego("DR02", Videojuego.CS2);
                for (Partida p : partidasCS2) {
                    System.out.println(p);
                }

                System.out.println("Puntuación total de WK03:");
                int puntosWK = repo.getPuntuacionTotal("WK03");
                System.out.println("WK03 -> " + puntosWK + " puntos");

                System.out.println("Clasificación general:");
                List<Equipo> clasificacion = repo.getClasificacionGeneral();
                for (Equipo e : clasificacion) {
                    int pts = repo.getPuntuacionTotal(e.getCodigo());
                    System.out.println(e.getNombre() + " - " + pts + " puntos");
                }

            } catch (LigaException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
