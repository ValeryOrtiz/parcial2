package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IVehiculo;

public class Coches implements IVehiculo {
    @Override
    public void descripcion() {
        System.out.println("Para uso personal o viajes de negocios.");
    }
}
