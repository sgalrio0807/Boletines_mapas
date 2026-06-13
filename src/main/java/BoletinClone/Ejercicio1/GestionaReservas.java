package BoletinClone.Ejercicio1;

public class GestionaReservas {
    static void main(String[] args) {
        RepositorioReservas repo = new RepositorioReservas();

        Reserva r1 = new Reserva("Carlos Ruiz", "Roma", "14A", 220);
        Reserva r2 = new Reserva("Carla Ruiz", "Roma", "14B", 220);

        repo.agregarReserva(r1);
        repo.agregarReserva(r2);

        Reserva reservaPrevia = repo.obtenerPorId(1);

        System.out.println("Reservas iniciales:");
        repo.mostrarReservas();

        reservaPrevia.setAsiento("22C");
        reservaPrevia.setPrecio(195);

        System.out.println("Reserva original en el repositorio:");
        System.out.println(repo.obtenerPorId(1));

        System.out.println("Reserva previa modificada:");
        System.out.println(reservaPrevia);

        System.out.println("¿Son diferentes?");
        System.out.println(repo.obtenerPorId(1) == reservaPrevia);

        Reserva simulada = repo.cambiarAsiento(2, "3D", false);

        System.out.println("Simulación (no modifica):");
        System.out.println(simulada);

        System.out.println("Lista original tras simular:");
        repo.mostrarReservas();

        repo.cambiarAsiento(2, "3D", true);

        System.out.println("Lista tras confirmar:");
        repo.mostrarReservas();
    }
}
