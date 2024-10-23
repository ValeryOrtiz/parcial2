package co.edu.uniquindio.parcial2.parcial2.model;

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;

    public Persona(int edad, String cedula, String apellido, String nombre) {
        this.edad = edad;
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                '}';
    }
}
