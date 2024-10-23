package co.edu.uniquindio.parcial2.parcial2.adapter.factory;

import co.edu.uniquindio.parcial2.parcial2.adapter.services.IPagoOld;

public class PasarelaPagoFactory {
    public void realizarPago(IPagoOld pagoTransferencia){
        System.out.println("Realizando proceso de pago");
        System.out.println("Se verifican los datos de pago");
        for(int i=0; i<pagoTransferencia.getDatos().length; i++){
            System.out.println("- " + pagoTransferencia.getDatos()[i] + " ");
        }
        System.out.println("Realizando el pago en la pasarela");
        System.out.println("Se realizo el " + pagoTransferencia.getTipoPago());
        System.out.println("--------------------------------------------------");
    }
}
