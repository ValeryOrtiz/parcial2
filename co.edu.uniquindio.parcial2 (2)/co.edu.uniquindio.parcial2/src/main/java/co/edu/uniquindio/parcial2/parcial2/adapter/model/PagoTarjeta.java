package co.edu.uniquindio.parcial2.parcial2.adapter.model;

import co.edu.uniquindio.parcial2.parcial2.adapter.services.IPagoNew;

public class PagoTarjeta implements IPagoNew {
    String tipoPago = "Pago por tarjeta";
    String[] datosNuevos = {"Numero tarjeta", "monto", "idDestinario"};
    @Override
    public String getTipoPagoNuevo() {
        return tipoPago;
    }

    @Override
    public String[] getDatosNuevos() {
        return datosNuevos;
    }
}
