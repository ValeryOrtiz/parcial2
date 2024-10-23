package co.edu.uniquindio.parcial2.parcial2.abstractfactory;

import co.edu.uniquindio.parcial2.parcial2.abstractfactory.Empleado;
import co.edu.uniquindio.parcial2.parcial2.abstractfactory.EmpleadoFactory;
import co.edu.uniquindio.parcial2.parcial2.abstractfactory.EmpleadoPermanenteFactory;
import co.edu.uniquindio.parcial2.parcial2.abstractfactory.EmpleadoTemporalFactory;

public class Main {
    public static void main(String[] args) {
        EmpleadoFactory permanenteFactory = new EmpleadoPermanenteFactory();
        Empleado empPermanente = permanenteFactory.crearEmpleado("Juan Pérez");
        empPermanente.mostrarDetalles();

        EmpleadoFactory temporalFactory = new EmpleadoTemporalFactory();
        Empleado empTemporal = temporalFactory.crearEmpleado("Ana Gómez");
        empTemporal.mostrarDetalles();
    }
}
