package co.edu.uniquindio.parcial2.parcial2.model;

import co.edu.uniquindio.parcial2.parcial2.model.builder.EmpleadoBuilder;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona{
    private List<Prestamo> prestamosAsociados = new ArrayList<>();

    public Empleado( String nombre, String apellido,String cedula, int edad) {
        super(edad, cedula, apellido, nombre);
    }

    public Empleado() {
    }

    public static EmpleadoBuilder builder(){
        return new EmpleadoBuilder();
    }

    public List<Prestamo> getPrestamosAsociados() {
        return prestamosAsociados;
    }
}
