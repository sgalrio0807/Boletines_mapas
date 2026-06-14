package BoletinMapas.Ejercicio1;

import java.time.LocalDate;

public class GestionaComicFest {
    static void main(String[] args) {
        RegistroEntradas registro = new RegistroEntradas();

        Influencer i1 = new Influencer("Carlos Ruiz", "carlos", 50000, "Instagram");
        Influencer i2 = new Influencer("Ana López", "anita", 120000, "TikTok");
        Influencer i3 = new Influencer("Luis Pérez", "luisp", 30000, "YouTube");

        Influencer i4 = new Influencer("Marta Díaz", "martita", 200000, "Instagram");
        Influencer i5 = new Influencer("Pedro Gómez", "pedrog", 80000, "Twitch");
        Influencer i6 = new Influencer("Sara León", "sarita", 60000, "TikTok");

        Influencer i7 = new Influencer("Javi Torres", "javito", 15000, "YouTube");
        Influencer i8 = new Influencer("Laura Gil", "laurag", 10000, "Instagram");
        Influencer i9 = new Influencer("Nerea Sol", "nereasol", 5000, "TikTok");

        registro.añadirEntrada(new EntradaVIP("E1", LocalDate.now(), TipoEntrada.PLATINIUM, i1));
        registro.añadirEntrada(new EntradaVIP("E2", LocalDate.now(), TipoEntrada.PLATINIUM, i2));
        registro.añadirEntrada(new EntradaVIP("E3", LocalDate.now(), TipoEntrada.PLATINIUM, i4));

        registro.añadirEntrada(new EntradaVIP("E4", LocalDate.now(), TipoEntrada.GOLD, i5));
        registro.añadirEntrada(new EntradaVIP("E5", LocalDate.now(), TipoEntrada.GOLD, i6));
        registro.añadirEntrada(new EntradaVIP("E6", LocalDate.now(), TipoEntrada.GOLD, i3));

        registro.añadirEntrada(new EntradaVIP("E7", LocalDate.now(), TipoEntrada.SILVER, i7));
        registro.añadirEntrada(new EntradaVIP("E8", LocalDate.now(), TipoEntrada.SILVER, i8));
        registro.añadirEntrada(new EntradaVIP("E9", LocalDate.now(), TipoEntrada.SILVER, i9));

        System.out.println("Buscar influencer con entrada:");
        System.out.println(registro.buscarEntrada("carlos", "Instagram"));

        System.out.println("Buscar influencer sin entrada:");
        System.out.println(registro.buscarEntrada("pepe", "Instagram"));

        registro.confirmar("carlos", "Instagram");
        registro.confirmar("pedrog", "Twitch");
        registro.confirmar("javito", "YouTube");

        registro.cancelar("pedrog", "Twitch");

        System.out.println("Confirmados:");
        for (EntradaVIP e : registro.listarConfirmados()) {
            System.out.println(e);
        }

        System.out.println("Cancelados:");
        for (EntradaVIP e : registro.listarCancelados()) {
            System.out.println(e);
        }

        System.out.println("Pendientes:");
        for (EntradaVIP e : registro.listarPendientes()) {
            System.out.println(e);
        }

        System.out.println("Top 3 influencers por seguidores:");
        for (Influencer i : registro.top3Influencers()) {
            System.out.println(i.getNick() + " - " + i.getNumSeguidores());
        }
    }
}
