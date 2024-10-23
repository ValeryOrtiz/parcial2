package co.edu.uniquindio.parcial2.parcial2.factorymethod.model;

import co.edu.uniquindio.parcial2.parcial2.factorymethod.services.IElectrodomesticos;

public class Electrodomesticos implements IElectrodomesticos {
    private String tipo;

    public Electrodomesticos(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void descripcion() {
        switch (tipo) {
            case "Refrigerador":
                System.out.println("Para eventos o uso doméstico temporal.");
                break;
            case "Televisor":
                System.out.println("Para ferias, exposiciones o entretenimiento doméstico.");
                break;
            case "Lavadora":
                System.out.println("Principalmente para clientes en rentas de vivienda a largo plazo.");
                break;
            default:
                System.out.println("Tipo de electrodoméstico no reconocido.");
        }
    }
}
