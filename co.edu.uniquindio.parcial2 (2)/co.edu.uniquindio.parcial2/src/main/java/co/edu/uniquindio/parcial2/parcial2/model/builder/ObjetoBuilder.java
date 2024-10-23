package co.edu.uniquindio.parcial2.parcial2.model.builder;

import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.parcial2.services.Estado;

public class ObjetoBuilder {
    private String nombre;
    private Prestamo prestamoAsociado;
    private Estado estado;
    private String idObjeto;

    public ObjetoBuilder nombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ObjetoBuilder prestamoAsociado(Prestamo prestamoAsociado){
        this.prestamoAsociado=prestamoAsociado;
        return this;
    }

    public ObjetoBuilder estado(Estado estado){
        this.estado=estado;
        return this;
    }

    public ObjetoBuilder idObjeto(String idObjeto){
        this.idObjeto=idObjeto;
        return this;
    }

    public Objeto build(){
        return new Objeto(nombre,
                prestamoAsociado,
                estado,
                idObjeto);
    }
}
