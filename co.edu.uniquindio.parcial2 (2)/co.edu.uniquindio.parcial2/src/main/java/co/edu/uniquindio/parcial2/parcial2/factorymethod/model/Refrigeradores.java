package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IElectrodomesticos;

public class Refrigeradores implements IElectrodomesticos {
    @Override
    public void descripcion() {
        System.out.println("Para eventos o uso doméstico temporal.");
    }
}
