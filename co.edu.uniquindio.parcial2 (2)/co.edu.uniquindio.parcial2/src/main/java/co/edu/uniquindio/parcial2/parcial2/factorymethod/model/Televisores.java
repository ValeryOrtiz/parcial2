package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IElectrodomesticos;

public class Televisores implements IElectrodomesticos {
    @Override
    public void descripcion() {
        System.out.println("Para ferias, exposiciones o entretenimiento doméstico.");
    }
}
