package co.edu.uniquindio.parcial2.parcial2.adapter.model;

import co.edu.uniquindio.parcial2.parcial2.adapter.services.IPagoOld;

public class PagoTransferencia implements IPagoOld {
    String pago = "Pago por transferencia";
    String[] datos = {"nombre", "monto", "idDestinario"};


    @Override
    public String getTipoPago() {
        return pago;
    }

    @Override
    public String[] getDatos() {
        return datos;
    }
}
