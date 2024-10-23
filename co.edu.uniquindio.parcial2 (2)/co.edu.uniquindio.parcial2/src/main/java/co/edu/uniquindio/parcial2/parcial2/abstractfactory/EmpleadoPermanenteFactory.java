package co.edu.uniquindio.parcial2.parcial2.abstractfactory;

public class EmpleadoPermanenteFactory extends EmpleadoFactory {
    @Override
    public Empleado crearEmpleado(String nombre) {
        return new EmpleadoPermanente(nombre);
    }
}
