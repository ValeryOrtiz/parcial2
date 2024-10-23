package co.edu.uniquindio.parcial2.parcial2.model;

import co.edu.uniquindio.parcial2.parcial2.services.Estado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrestamoUq {
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private List<Objeto> objetos = new ArrayList<>();


    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public PrestamoUq() {
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public boolean crearCliente(String cedula,
                                String nombre,
                                String apellido,
                                int edad){
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado == null){
            Cliente cliente = getBuildCliente(cedula, nombre, apellido, edad);
            getClientes().add(cliente);
            return true;
        }else{
            return  false;
        }
    }

    public boolean crearCliente(Cliente nuevoCliente){
        Cliente clienteEncontrado = obtenerCliente(nuevoCliente.getCedula());
        if(clienteEncontrado == null){
            getClientes().add(nuevoCliente);
            return true;
        }else{
            return  false;
        }
    }

    public boolean eliminarCliente(String cedula) {
        Cliente clienteExistente = obtenerCliente(cedula);
        if(clienteExistente != null){
            getClientes().remove(clienteExistente);
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
        Cliente clienteExistente = obtenerCliente(cedula);
        if (clienteExistente!=null){
            for (Cliente cliente1 : clientes) {
                if (cliente1.getCedula().equals(cedula)) {
                    cliente1.setNombre(cliente.getNombre());
                    cliente1.setApellido(cliente.getApellido());
                    cliente1.setEdad(cliente.getEdad());
                    cliente1.setCedula(cliente.getCedula());
                    return true;
                }
            }
        }

        return false;
    }

    private Cliente getBuildCliente(String cedula, String nombre, String apellido, int edad) {
        return Cliente.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cedula(cedula)
                .edad(edad)
                .build();
    }

    public Cliente obtenerCliente(String cedula) {
        Cliente cliente = null;
        for (Cliente cliente1: getClientes()) {
            if(cliente1.getCedula().equalsIgnoreCase(cedula)){
                cliente = cliente1;
                break;
            }
        }

        return cliente;
    }

    private Empleado obtenerEmpleado(String cedula) {
        Empleado empleado = null;
        for (Empleado empleado1: getEmpleados()) {
            if(empleado1.getCedula().equalsIgnoreCase(cedula)){
                empleado = empleado1;
                break;
            }
        }

        return empleado;
    }

    public Objeto obtenerObjeto(String idObjeto) {
        Objeto objeto = null;
        for (Objeto objeto1 : getObjetos()) {
            if (objeto1.getIdObjeto() != null && objeto1.getIdObjeto().equalsIgnoreCase(idObjeto)) {
                objeto = objeto1;
                break;
            }
        }
        return objeto;
    }

    public List<Objeto> obtenerObjetosRango(int rango){
        List<Objeto> objetosEnRango = new ArrayList<>();
        for(Objeto i : objetos){
            if (i.getPrestamos().size()==(rango)){
                objetosEnRango.add(i);
            }
        }

        return objetosEnRango;
    }


    public List<Cliente> obtenerClientesRango(int rango) {
        List<Cliente> clientesRango = new ArrayList<>();
        for(Cliente i : clientes){
            if (i.getPrestamosAsociados().size()==(rango)){
                clientesRango.add(i);
            }
        }

        return clientesRango;
    }

    public List<Objeto> obtenerObjetosDisponibles() {
        List<Objeto> objetosDisponibles = new ArrayList<>();
        for (Objeto i : objetos){
            if (i.getEstado()== Estado.DISPONIBLE){
                objetosDisponibles.add(i);
            }
        }

        return objetosDisponibles;
    }

    public List<Objeto> obtenerObjetosNoDisponibles() {
        List<Objeto> objetosDisponibles = new ArrayList<>();
        for (Objeto i : objetos){
            if (i.getEstado()== Estado.NO_DISPONIBLE){
                objetosDisponibles.add(i);
            }
        }

        return objetosDisponibles;
    }

    public boolean eliminarEmpleado(String cedula) {
        Empleado empleadoExistente = obtenerEmpleado(cedula);
        if(empleadoExistente != null){
            getEmpleados().remove(empleadoExistente);
            return true;
        }else{
            return false;
        }
    }

    public boolean crearEmpleado(Empleado nuevoEmpleado) {
        Empleado empleadoEncontrado = obtenerEmpleado(nuevoEmpleado.getCedula());
        if(empleadoEncontrado == null){
            getEmpleados().add(nuevoEmpleado);
            return true;
        }else{
            return  false;
        }
    }

    public boolean actualizarEmpleado(String cedula, Empleado empleado) {
        Empleado empleadoExistente = obtenerEmpleado(cedula);
        if (empleadoExistente!=null){
            for (Empleado empleado1 : empleados) {
                if (empleado1.getCedula().equals(cedula)) {
                    empleado1.setNombre(empleado.getNombre());
                    empleado1.setApellido(empleado.getApellido());
                    empleado1.setEdad(empleado.getEdad());
                    empleado1.setCedula(empleado.getCedula());
                    return true;
                }
            }
        }

        return false;
    }

    public boolean eliminarObjeto(String idObjeto) {
        Objeto objetoExistente = obtenerObjeto(idObjeto);
        if(objetoExistente != null){
            getObjetos().remove(objetoExistente);
            return true;
        }else{
            return false;
        }
    }

    public boolean crearObjeto(Objeto nuevoObjeto) {
        Objeto objetoEncontrado = obtenerObjeto(nuevoObjeto.getIdObjeto());
        if(objetoEncontrado == null){
            getObjetos().add(nuevoObjeto);
            return true;
        }else{
            return  false;
        }
    }

    public boolean actualizarObjeto(String idObjeto, Objeto objeto) {
        Objeto objetoExistente = obtenerObjeto(idObjeto);
        if (objetoExistente!=null){
            for (Objeto objeto1 : objetos) {
                if (objeto1.getIdObjeto().equals(idObjeto)) {
                    objeto1.setNombre(objeto.getNombre());
                    objeto1.setIdObjeto(objeto.getIdObjeto());
                    objeto1.setEstado(objeto.getEstado());
                    return true;
                }
            }
        }

        return false;
    }

    public List<Objeto> obtenerObjetosNoPrestamos() {
        List<Objeto> objetosPrestamos = new ArrayList<>();
        for (Objeto i : objetos){
            if (i.getPrestamoAsociado()== null){
                objetosPrestamos.add(i);
            }
        }

        return objetosPrestamos;
    }
    public List<Objeto> obtenerObjetosPrestamos() {
        List<Objeto> objetosPrestamos = new ArrayList<>();
        for (Objeto i : objetos){
            if (i.getPrestamoAsociado()!= null){
                objetosPrestamos.add(i);
            }
        }

        return objetosPrestamos;
    }

    public List<Prestamo> obtenerPrestamoEspecifico(LocalDateTime rango) {
        List<Prestamo> prestamosEspecificos = new ArrayList<>();
        for (Prestamo i : prestamos){
            if (rango.equals(i.getFechaPrestamo())){
                prestamosEspecificos.add(i);
            }
        }

        return prestamosEspecificos;
    }

    public List<Prestamo> obtenerPrestamoRango(LocalDateTime rangoInicial, LocalDateTime rangoFinal) {
        List<Prestamo> prestamosRango = new ArrayList<>();
        for (Prestamo i : prestamos){
            if (rangoInicial.isBefore(i.getFechaPrestamo()) && rangoFinal.isAfter(i.getFechaPrestamo())){
                prestamosRango.add(i);
            }
        }

        return prestamosRango;
    }

    public List<Empleado> obtenerEmpleadosRango(int rango) {
        List<Empleado> empleadosRango = new ArrayList<>();
        for(Empleado i : empleados){
            if (i.getPrestamosAsociados().size()==(rango)){
                empleadosRango.add(i);
            }
        }

        return empleadosRango;
    }
}
