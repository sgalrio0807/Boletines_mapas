package BoletinClone.Ejercicio2;

public class Gestiona {
    static void main(String[] args) {
        Motor motor1 = new Motor("gasolina", 100, false);
        Motor motor2 = motor1;
        motor2.setTipo("diesel");

        System.out.println("Motor1: " + motor1);
        System.out.println("Motor2: " + motor2);

        Motor motor3 = motor1.clonar();
        motor3.setTipo("electrico");

        System.out.println("Motor1 tras clonación: " + motor1);
        System.out.println("Motor3 (clon): " + motor3);

        Coche cocheOriginal = new Coche("1234ABC", "Seat Ibiza", 50000, motor1);
        Coche cocheCopia = cocheOriginal.clonar();

        cocheCopia.getMotor().setCv(300);

        System.out.println("Coche original: " + cocheOriginal);
        System.out.println("Coche copia: " + cocheCopia);
    }
}
