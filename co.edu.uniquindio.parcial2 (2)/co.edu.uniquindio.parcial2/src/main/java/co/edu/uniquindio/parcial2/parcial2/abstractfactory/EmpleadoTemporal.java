package co.edu.uniquindio.parcial2.parcial2.abstractfactory;

public class EmpleadoTemporal extends Empleado {
    public EmpleadoTemporal(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Temporal: " + nombre);
    }
}
