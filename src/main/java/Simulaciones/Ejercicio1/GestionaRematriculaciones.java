package Simulaciones.Ejercicio1;

import java.time.LocalDate;

public class GestionaRematriculaciones {
    static void main(String[] args) {
        {

            RepositorioRematriculaciones repo = new RepositorioRematriculaciones();

            Vehiculo v1 = new Vehiculo("VIN001", "1234ABC", "Toyota", "Corolla", "Rojo",
                    2010, LocalDate.of(2010, 5, 10), "Carlos Ruiz");

            Vehiculo v2 = new Vehiculo("VIN002", "5678DEF", "Ford", "Focus", "Azul",
                    2015, LocalDate.of(2015, 3, 20), "Carlos Ruiz");

            Vehiculo v3 = new Vehiculo("VIN003", "9999ZZZ", "Seat", "Ibiza", "Negro",
                    2020, LocalDate.of(2020, 7, 1), "Ana López");

            repo.registrarVehiculo(v1);
            repo.registrarVehiculo(v2);
            repo.registrarVehiculo(v3);

            try {
                repo.registrarRematriculacion("VIN001", "1111AAA", LocalDate.of(2022, 5, 10));
                repo.registrarRematriculacion("VIN001", "2222BBB", LocalDate.of(2023, 3, 15));
                repo.registrarRematriculacion("VIN002", "7777CCC", LocalDate.of(2023, 3, 15));
            } catch (RegistroException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            System.out.println("Vehículo VIN001:");
            System.out.println(repo.buscarPorVin("VIN001"));

            System.out.println("Histórico VIN001:");
            for (Matriculacion m : repo.historialOrdenado("VIN001")) {
                System.out.println(m);
            }

            System.out.println("Vehículos de Carlos Ruiz ordenados por matrícula:");
            for (Vehiculo v : repo.vehiculosPorPropietario("Carlos Ruiz")) {
                System.out.println(v);
            }
        }
    }
}
