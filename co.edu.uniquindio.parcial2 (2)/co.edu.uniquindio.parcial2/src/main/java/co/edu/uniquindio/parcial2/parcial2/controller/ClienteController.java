package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;

import java.util.List;

public class ClienteController {
    ModelFactory modelFactory;

    public  ClienteController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Cliente> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public boolean crearCliente(Cliente cliente) {
        return modelFactory.crearCliente(cliente);
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return modelFactory.actualizarCliente(cedula,cliente);
    }

    public boolean eliminarCliente(Cliente clienteSeleccionado) {
        return modelFactory.eliminarCliente(clienteSeleccionado);
    }
}
