package co.edu.uniquindio.parcial2.parcial2.abstractfactory;

public class EmpleadoPermanente extends Empleado {
    public EmpleadoPermanente(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Permanente: " + nombre);
    }
}
