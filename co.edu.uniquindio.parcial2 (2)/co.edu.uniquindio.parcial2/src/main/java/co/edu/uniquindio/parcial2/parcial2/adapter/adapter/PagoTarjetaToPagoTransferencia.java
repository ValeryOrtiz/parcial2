package co.edu.uniquindio.parcial2.parcial2.adapter.adapter;

import co.edu.uniquindio.parcial2.parcial2.adapter.services.IPagoNew;
import co.edu.uniquindio.parcial2.parcial2.adapter.services.IPagoOld;

public class PagoTarjetaToPagoTransferencia implements IPagoOld {
    public IPagoNew pagoTarjeta;

    public PagoTarjetaToPagoTransferencia(IPagoNew pagoTarjeta) {
        this.pagoTarjeta = pagoTarjeta;
    }

    @Override
    public String getTipoPago() {
        return pagoTarjeta.getTipoPagoNuevo();
    }

    @Override
    public String[] getDatos() {
        return pagoTarjeta.getDatosNuevos();
    }
}
