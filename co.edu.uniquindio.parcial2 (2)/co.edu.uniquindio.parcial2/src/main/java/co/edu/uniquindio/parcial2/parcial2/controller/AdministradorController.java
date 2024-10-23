package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;

import java.util.List;


public class AdministradorController {
    ModelFactory modelFactory;

    public  AdministradorController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Cliente> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public List<Objeto> obtenerObjetos() {
        return modelFactory.obtenerObjetos();
    }

    public Objeto obtenerObjeto(String idObjeto){
        return modelFactory.obtenerObjeto(idObjeto);
    }

    public List<Objeto> obtenerObjetosRango(int rango) {
        return modelFactory.obtenerObjetosRango(rango);
    }

    public List<Cliente> obtenerClientesRango(int rango) {
        return modelFactory.obtenerClientesRango(rango);
    }

    public List<Objeto> obtenerObjetosDisponibles() {
        return modelFactory.obtenerObjetosDisponibles();
    }

    public List<Objeto> obtenerObjetosNoDisponibles() {
        return modelFactory.obtenerObjetosNoDisponibles();
    }
}
