package co.edu.uniquindio.parcial2.parcial2.factorymethod.factory;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.model.*;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.*;

public class ElectrodomesticosFactory implements IElectrodomesticoFactory {
    @Override
    public IElectrodomesticos crearElectrodomestico(TipoElectrodomestico tipo) {
        switch (tipo) {
            case REFRIGERADOR:
                return new Refrigeradores();
            case TELEVISOR:
                return new Televisores();
            case LAVADORA:
                return new Lavadoras();
            default:
                throw new IllegalArgumentException("Tipo de electrodoméstico no válido");
        }
    }
}
