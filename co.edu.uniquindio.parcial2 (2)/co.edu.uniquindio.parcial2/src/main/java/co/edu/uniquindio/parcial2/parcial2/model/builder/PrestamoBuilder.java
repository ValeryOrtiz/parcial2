package co.edu.uniquindio.parcial2.parcial2.model.builder;

import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;

import java.time.LocalDateTime;

public class PrestamoBuilder {
    private String numeroPrestamo;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaEntrega;
    private String descripcion;
    private Cliente clienteAsociado;
    private Empleado empleadoAsociado;

    public PrestamoBuilder numeroPrestamo(String numeroPrestamo){
        this.numeroPrestamo=numeroPrestamo;
        return this;
    }
    public PrestamoBuilder fechaPrestamo(LocalDateTime fechaPrestamo){
        this.fechaPrestamo=fechaPrestamo;
        return this;
    }
    public PrestamoBuilder fechaEntrega(LocalDateTime fechaEntrega){
        this.fechaEntrega=fechaEntrega;
        return this;
    }
    public PrestamoBuilder descripcion(String descripcion){
        this.descripcion=descripcion;
        return this;
    }
    public  PrestamoBuilder clienteAsociado(Cliente clienteAsociado){
        this.clienteAsociado=clienteAsociado;
        return this;
    }
    public  PrestamoBuilder empleadoAsociado(Empleado empleadoAsociado){
        this.empleadoAsociado=empleadoAsociado;
        return this;
    }
    public Prestamo build(){
        return new Prestamo(numeroPrestamo,
                fechaPrestamo,
                fechaEntrega,
                descripcion,
                clienteAsociado,
                empleadoAsociado);
    }
}
