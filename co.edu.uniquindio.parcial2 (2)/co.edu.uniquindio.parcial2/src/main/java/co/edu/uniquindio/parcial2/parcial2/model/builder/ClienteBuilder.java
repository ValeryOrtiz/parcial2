package co.edu.uniquindio.parcial2.parcial2.model.builder;

import co.edu.uniquindio.parcial2.parcial2.model.Cliente;

public class ClienteBuilder {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;

    public ClienteBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder apellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    public ClienteBuilder cedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public ClienteBuilder edad(int edad){
        this.edad = edad;
        return this;
    }

    public Cliente build(){
        return new Cliente(nombre, apellido, cedula, edad);
    }
}

