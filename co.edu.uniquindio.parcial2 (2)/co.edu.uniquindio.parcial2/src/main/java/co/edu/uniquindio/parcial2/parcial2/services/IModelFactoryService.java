package co.edu.uniquindio.parcial2.parcial2.services;

import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;

import java.time.LocalDateTime;
import java.util.List;

public interface IModelFactoryService {
    List<Cliente> obtenerClientes();

    List<Prestamo> obtenerPrestamoEspecifico(LocalDateTime rango);

    List<Prestamo> obtenerPrestamoRango(LocalDateTime rangoInicial, LocalDateTime rangoFinal);

    List<Objeto> obtenerObjetos();

    Objeto obtenerObjeto(String idObjeto);

    List<Objeto> obtenerObjetosRango(int rango);

    boolean crearCliente(Cliente cliente);

    boolean actualizarCliente(String cedula, Cliente cliente);

    boolean eliminarCliente(Cliente clienteSeleccionado);

    List<Cliente> obtenerClientesRango(int rango);

    List<Objeto> obtenerObjetosDisponibles();

    List<Objeto> obtenerObjetosNoDisponibles();

    List<Empleado> obtenerEmpleados();

    boolean eliminarEmpleado(Empleado empleadoSeleccionado);

    boolean crearEmpleado(Empleado empleado);

    boolean actualizarEmpleado(String cedula, Empleado empleado);

    boolean actualizarObjeto(String idObjeto, Objeto objeto);

    boolean crearObjeto(Objeto objeto);

    boolean eliminarObjeto(Objeto objeto);

    List<Objeto> obtenerObjetosNoPrestamos();

    List<Objeto> obtenerObjetosPrestamos();

    Cliente obtenerCliente(String cedula);

    List<Empleado> obtenerEmpleadosRango(int rango);
}
