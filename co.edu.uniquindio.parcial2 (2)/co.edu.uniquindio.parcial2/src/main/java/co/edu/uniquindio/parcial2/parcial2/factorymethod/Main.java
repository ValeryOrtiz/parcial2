package co.edu.uniquindio.parcial2.parcial2.factorymethod;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.factory.ElectrodomesticosFactory;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.factory.VehiculosFactory;
import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.*;

public class Main {
    public static void main(String[] args) {
        factoryMethod();
    }

    private static void factoryMethod() {
        System.out.println("Ejemplo Factory Method - Todo-en-Uno");
        IVehiculoFactory vehiculosFactory = new VehiculosFactory();
        IElectrodomesticoFactory electrodomesticosFactory = new ElectrodomesticosFactory();
        IVehiculo coche = vehiculosFactory.crearVehiculo(TipoVehiculo.COCHES);
        IVehiculo bicicleta = vehiculosFactory.crearVehiculo(TipoVehiculo.BICICLETA);
        IVehiculo motocicleta = vehiculosFactory.crearVehiculo(TipoVehiculo.MOTOCICLETAS);
        IElectrodomesticos refrigerador = electrodomesticosFactory.crearElectrodomestico(TipoElectrodomestico.REFRIGERADOR);
        IElectrodomesticos televisor = electrodomesticosFactory.crearElectrodomestico(TipoElectrodomestico.TELEVISOR);
        IElectrodomesticos lavadora = electrodomesticosFactory.crearElectrodomestico(TipoElectrodomestico.LAVADORA);
        coche.descripcion();
        bicicleta.descripcion();
        motocicleta.descripcion();
        refrigerador.descripcion();
        televisor.descripcion();
        lavadora.descripcion();
    }

}
