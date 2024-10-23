package co.edu.uniquindio.parcial2.parcial2.model;

import co.edu.uniquindio.parcial2.parcial2.model.builder.ClienteBuilder;
import co.edu.uniquindio.parcial2.parcial2.model.builder.PrestamoBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private String numeroPrestamo;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaEntrega;
    private String descripcion;
    private Cliente clienteAsociado;
    private Empleado empleadoAsociado;
    private List<Objeto> objetos = new ArrayList<>();

    public Prestamo(String numeroPrestamo,
                    LocalDateTime fechaPrestamo,
                    LocalDateTime fechaEntrega,
                    String descripcion,
                    Cliente clienteAsociado,
                    Empleado empleadoAsociado) {
        this.numeroPrestamo = numeroPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.clienteAsociado = clienteAsociado;
        this.empleadoAsociado = empleadoAsociado;
    }

    public static PrestamoBuilder builder(){
        return new PrestamoBuilder();
    }

    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "numeroPrestamo='" + numeroPrestamo + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaEntrega=" + fechaEntrega +
                ", descripcion='" + descripcion + '\'' +
                ", clienteAsociado=" + clienteAsociado +
                ", empleadoAsociado=" + empleadoAsociado +
                ", objetos=" + objetos +
                '}';
    }
}
