package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IVehiculo;

public class Vehiculos implements IVehiculo {
    private String tipo;

    public Vehiculos(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void descripcion() {
        switch (tipo) {
            case "Coche":
                System.out.println("Para uso personal o viajes de negocios.");
                break;
            case "Motocicleta":
                System.out.println("Ideal para clientes que buscan un transporte ágil.");
                break;
            case "Bicicleta":
                System.out.println("Para clientes eco-conscientes o eventos en zonas urbanas.");
                break;
            default:
                System.out.println("Tipo de vehículo no reconocido.");
        }
    }
}
