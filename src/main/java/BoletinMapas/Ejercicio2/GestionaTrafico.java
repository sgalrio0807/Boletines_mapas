package BoletinMapas.Ejercicio2;

import java.time.LocalDate;

public class GestionaTrafico {
    static void main(String[] args) {
        RegistroTrafico registro = new RegistroTrafico();

        Vehiculo v1 = new Vehiculo("VIN001", "1234ABC", "Toyota", "Corolla", 2010, "Carlos Ruiz");
        Vehiculo v2 = new Vehiculo("VIN002", "5678DEF", "Ford", "Focus", 2015, "Carlos Ruiz");
        Vehiculo v3 = new Vehiculo("VIN003", "9999ZZZ", "Seat", "Ibiza", 2020, "Ana López");

        registro.registrarVehiculo(v1);
        registro.registrarVehiculo(v2);
        registro.registrarVehiculo(v3);

        try {
            registro.registrarRematriculacion("VIN001", "1111AAA", LocalDate.of(2022, 5, 10));
            registro.registrarRematriculacion("VIN001", "2222BBB", LocalDate.of(2023, 3, 15));
            registro.registrarRematriculacion("VIN002", "7777CCC", LocalDate.of(2023, 3, 15));
        } catch (RegistroException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Vehículo VIN001:");
        System.out.println(registro.buscarPorVin("VIN001"));
        System.out.println("Historial:");
        for (Rematriculacion r : registro.historialVehiculo("VIN001")) {
            System.out.println(r);
        }

        System.out.println("Vehículos de Carlos Ruiz ordenados por matrícula:");
        for (Vehiculo v : registro.vehiculosPorPropietario("Carlos Ruiz")) {
            System.out.println(v);
        }

        System.out.println("Rematriculaciones del año 2023:");
        for (Rematriculacion r : registro.rematriculacionesPorAño(2023)) {
            System.out.println(r);
        }
    }
}