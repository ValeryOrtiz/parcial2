package co.edu.uniquindio.parcial2.parcial2.adapter;

import co.edu.uniquindio.parcial2.parcial2.adapter.adapter.PagoTarjetaToPagoTransferencia;
import co.edu.uniquindio.parcial2.parcial2.adapter.factory.PasarelaPagoFactory;
import co.edu.uniquindio.parcial2.parcial2.adapter.model.PagoTarjeta;
import co.edu.uniquindio.parcial2.parcial2.adapter.model.PagoTransferencia;

public class Main {
    public static void main(String[] args) {
        PagoTransferencia pagoTransferencia = new PagoTransferencia();
        PagoTarjeta pagoTarjeta = new PagoTarjeta();

        PasarelaPagoFactory pasarelaPagoFactory = new PasarelaPagoFactory();
        pasarelaPagoFactory.realizarPago(pagoTransferencia);

        PagoTarjetaToPagoTransferencia pagoAdapter = new PagoTarjetaToPagoTransferencia(pagoTarjeta);
        pasarelaPagoFactory.realizarPago(pagoAdapter);
    }
}
