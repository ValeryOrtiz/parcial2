package co.edu.uniquindio.parcial2.parcial2.factory;

import co.edu.uniquindio.parcial2.parcial2.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.PrestamoUq;
import co.edu.uniquindio.parcial2.parcial2.services.IModelFactoryService;
import co.edu.uniquindio.parcial2.parcial2.services.IPrestamoMapping;
import co.edu.uniquindio.parcial2.parcial2.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoUq prestamoUq;
    private IPrestamoMapping mapper;

    public static ModelFactory getInstance() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new PrestamoMappingImpl();
        prestamoUq = DataUtil.inicializarDatos();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return prestamoUq.getClientes();
    }

    public List<Objeto> obtenerObjetos() {
        return prestamoUq.getObjetos();
    }

    public Objeto obtenerObjeto(String idObjeto) {
        return prestamoUq.obtenerObjeto(idObjeto);
    }

    public List<Objeto> obtenerObjetosRango(int rango) {
        return prestamoUq.obtenerObjetosRango(rango);
    }

    public boolean crearCliente(Cliente cliente) {
        return prestamoUq.crearCliente(cliente);
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return prestamoUq.actualizarCliente(cedula,cliente);
    }

    public boolean eliminarCliente(Cliente clienteSeleccionado) {
        return prestamoUq.eliminarCliente(clienteSeleccionado.getCedula());
    }

    public List<Cliente> obtenerClientesRango(int rango) {
        return prestamoUq.obtenerClientesRango(rango);
    }

    public List<Objeto> obtenerObjetosDisponibles() {
        return prestamoUq.obtenerObjetosDisponibles();
    }

    public List<Objeto> obtenerObjetosNoDisponibles() {
        return prestamoUq.obtenerObjetosNoDisponibles();
    }

    public List<Empleado> obtenerEmpleados() {
        return prestamoUq.getEmpleados();
    }

    public boolean eliminarEmpleado(Empleado empleadoSeleccionado) {
        return prestamoUq.eliminarEmpleado(empleadoSeleccionado.getCedula());
    }

    public boolean crearEmpleado(Empleado empleado) {
        return prestamoUq.crearEmpleado(empleado);
    }

    public boolean actualizarEmpleado(String cedula, Empleado empleado) {
        return prestamoUq.actualizarEmpleado(cedula,empleado);
    }

    public boolean actualizarObjeto(String idObjeto, Objeto objeto) {
        return prestamoUq.actualizarObjeto(idObjeto, objeto);
    }

    public boolean crearObjeto(Objeto objeto) {
        return prestamoUq.crearObjeto(objeto);
    }

    public boolean eliminarObjeto(Objeto objeto) {
        return prestamoUq.eliminarObjeto(objeto.getIdObjeto());
    }

    public List<Objeto> obtenerObjetosNoPrestamos() {
        return prestamoUq.obtenerObjetosNoPrestamos();
    }

    public List<Objeto> obtenerObjetosPrestamos() {
        return prestamoUq.obtenerObjetosPrestamos();
    }

    public Cliente obtenerCliente(String cedula) {
        return prestamoUq.obtenerCliente(cedula);
    }
}
