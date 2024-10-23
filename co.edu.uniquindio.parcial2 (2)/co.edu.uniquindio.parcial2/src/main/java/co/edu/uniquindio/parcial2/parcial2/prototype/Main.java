package co.edu.uniquindio.parcial2.parcial2.prototype;

import co.edu.uniquindio.parcial2.parcial2.prototype.model.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Vehiculo original = new Vehiculo("Sedán", "Toyota Corolla");
        Vehiculo copia = original.clonar();
        original.mostrarDetalles();
        copia.mostrarDetalles();
    }
}
