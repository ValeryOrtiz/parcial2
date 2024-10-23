package co.edu.uniquindio.parcial2.parcial2.abstractfactory;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract void mostrarDetalles();
}
