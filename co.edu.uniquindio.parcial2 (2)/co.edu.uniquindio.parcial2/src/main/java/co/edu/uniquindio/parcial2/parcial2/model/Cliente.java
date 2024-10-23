package co.edu.uniquindio.parcial2.parcial2.model;

import co.edu.uniquindio.parcial2.parcial2.model.builder.ClienteBuilder;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private List<Prestamo> prestamosAsociados = new ArrayList<>();

    public Cliente(String nombre,String apellido, String cedula,  int edad) {
        super(edad, cedula, apellido, nombre);
    }

    public Cliente() {
    }

    public static ClienteBuilder builder(){
        return new ClienteBuilder();
    }

    public List<Prestamo> getPrestamosAsociados() {
        return prestamosAsociados;
    }
}
