package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IVehiculo;

public class Bicicletas implements IVehiculo {

    @Override
    public void descripcion() {
        System.out.println("Para clientes eco-conscientes o eventos en zonas urbanas.");
    }
}
