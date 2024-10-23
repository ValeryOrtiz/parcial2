package co.edu.uniquindio.parcial2.parcial2.prototype.model;

import co.edu.uniquindio.parcial2.parcial2.prototype.service.Clonable;

public class Vehiculo implements Clonable {
    private String tipo;
    private String modelo;

    public Vehiculo(String tipo, String modelo) {
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public void mostrarDetalles() {
        System.out.println("Vehículo: " + tipo + " Modelo: " + modelo);
    }

    @Override
    public Vehiculo clonar() {
        try {
            return (Vehiculo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
