package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;

import java.util.List;

public class EmpleadoController {
    ModelFactory modelFactory;

    public  EmpleadoController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Empleado> obtenerEmpleados() {
        return modelFactory.obtenerEmpleados();
    }

    public boolean eliminarEmpleado(Empleado empleadoSeleccionado) {
        return modelFactory.eliminarEmpleado(empleadoSeleccionado);
    }

    public boolean crearEmpleado(Empleado empleado) {
        return modelFactory.crearEmpleado(empleado);
    }

    public boolean actualizarEmpleado(String cedula, Empleado empleado) {
        return modelFactory.actualizarEmpleado(cedula,empleado);
    }
}
