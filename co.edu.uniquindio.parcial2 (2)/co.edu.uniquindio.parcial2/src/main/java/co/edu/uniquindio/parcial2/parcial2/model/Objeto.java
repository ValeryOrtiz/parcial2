package co.edu.uniquindio.parcial2.parcial2.model;

import co.edu.uniquindio.parcial2.parcial2.model.builder.ClienteBuilder;
import co.edu.uniquindio.parcial2.parcial2.model.builder.ObjetoBuilder;
import co.edu.uniquindio.parcial2.parcial2.services.Estado;

import java.util.ArrayList;
import java.util.List;

public class Objeto {
    private String nombre;
    private Prestamo prestamoAsociado;
    private Estado estado;
    private String idObjeto;
    private List<Prestamo> prestamos = new ArrayList<>();


    public static ObjetoBuilder builder(){
        return new ObjetoBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public Objeto(String nombre, Prestamo prestamoAsociado, Estado estado, String idObjeto) {
        this.nombre = nombre;
        this.prestamoAsociado = prestamoAsociado;
        this.estado = estado;
        this.idObjeto = idObjeto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrestamoAsociado(Prestamo prestamoAsociado) {
        this.prestamoAsociado = prestamoAsociado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public Prestamo getPrestamoAsociado() {
        return prestamoAsociado;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", prestamoAsociado=" + prestamoAsociado +
                ", estado=" + estado +
                ", idObjeto='" + idObjeto + '\'' +
                '}';
    }
}
