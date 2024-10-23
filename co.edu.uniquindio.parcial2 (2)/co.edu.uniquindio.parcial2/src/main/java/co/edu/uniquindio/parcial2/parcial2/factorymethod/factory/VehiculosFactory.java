package co.edu.uniquindio.parcial2.parcial2.factorymethod.factory;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.model.Bicicletas;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.model.Coches;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.model.Motocicletas;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.model.Vehiculos;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IVehiculo;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IVehiculoFactory;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.TipoVehiculo;

public class VehiculosFactory implements IVehiculoFactory {
    @Override
    public IVehiculo crearVehiculo(TipoVehiculo tipo) {
        switch (tipo) {
            case COCHES:
                return new Coches();
            case MOTOCICLETAS:
                return new Motocicletas();
            case BICICLETA:
                return new Bicicletas();
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido");
        }
    }

}
