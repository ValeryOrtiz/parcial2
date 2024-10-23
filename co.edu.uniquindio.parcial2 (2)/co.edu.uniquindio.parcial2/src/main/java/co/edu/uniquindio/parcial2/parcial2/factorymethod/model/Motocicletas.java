package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IVehiculo;

public class Motocicletas implements IVehiculo {
    @Override
    public void descripcion() {
        System.out.println("Ideal para clientes que buscan un transporte ágil.");
    }
}
