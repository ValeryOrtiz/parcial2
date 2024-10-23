package co.edu.uniquindio.parcial2.parcial2.model.builder;

import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;

public class EmpleadoBuilder {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;

    public EmpleadoBuilder nombre(String nombre) {
        this.nombre=nombre;
        return this;
    }

    public EmpleadoBuilder apellido(String apellido) {
        this.apellido=apellido;
        return this;
    }

    public EmpleadoBuilder cedula(String cedula) {
        this.cedula=cedula;
        return this;
    }

    public EmpleadoBuilder edad(int edad) {
        this.edad=edad;
        return this;
    }

    public Empleado build() {
        return new Empleado(nombre,
                apellido,
                cedula,
                edad);
    }
}
