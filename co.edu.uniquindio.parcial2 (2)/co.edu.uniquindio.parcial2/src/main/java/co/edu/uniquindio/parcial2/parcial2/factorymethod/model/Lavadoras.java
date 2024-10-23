package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IElectrodomesticos;

public class Lavadoras implements IElectrodomesticos {
    @Override
    public void descripcion() {
        System.out.println("Principalmente para clientes en rentas de vivienda a largo plazo.");
    }
}
