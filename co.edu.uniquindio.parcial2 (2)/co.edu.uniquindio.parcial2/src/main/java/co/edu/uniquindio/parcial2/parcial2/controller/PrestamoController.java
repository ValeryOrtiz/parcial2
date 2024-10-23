package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;

import java.time.LocalDateTime;
import java.util.List;

public class PrestamoController {
    ModelFactory modelFactory;

    public  PrestamoController(){
        modelFactory = ModelFactory.getInstance();
    }


    public List<Prestamo> obtenerPrestamoEspecifico(LocalDateTime rango) {
        return modelFactory.obtenerPrestamoEspecifico(rango);
    }

    public List<Prestamo> obtenerPrestamoRango(LocalDateTime rangoInicial, LocalDateTime rangoFinal) {
        return modelFactory.obtenerPrestamoRango(rangoInicial, rangoFinal);
    }
}
