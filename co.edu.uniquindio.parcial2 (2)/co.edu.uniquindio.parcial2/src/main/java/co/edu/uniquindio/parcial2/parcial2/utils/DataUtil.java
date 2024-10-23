package co.edu.uniquindio.parcial2.parcial2.utils;

import co.edu.uniquindio.parcial2.parcial2.model.*;
import co.edu.uniquindio.parcial2.parcial2.services.Estado;

import java.time.LocalDateTime;

public class DataUtil {
    public static PrestamoUq inicializarDatos() {
        PrestamoUq prestamoUq = new PrestamoUq();
        Cliente cliente1 = Cliente.builder()
                .cedula("1234")
                .nombre("juan")
                .apellido("arias")
                .edad(17)
                .build();
        Cliente cliente2 = Cliente.builder()
                .cedula("2345")
                .nombre("Ana")
                .apellido("cardenas")
                .edad(25)
                .build();
        Cliente cliente3 = Cliente.builder()
                .cedula("3456")
                .nombre("Pedro")
                .apellido("perez")
                .edad(40)
                .build();
        Empleado empleado1 = Empleado.builder()
                .cedula("4567")
                .nombre("Valery")
                .apellido("Ortiz")
                .edad(18)
                .build();
        Empleado empleado2 = Empleado.builder()
                .cedula("5678")
                .nombre("Santiago")
                .apellido("Navarro")
                .edad(24)
                .build();
        Empleado empleado3 = Empleado.builder()
                .cedula("6789")
                .nombre("Sol")
                .apellido("Islas")
                .edad(35)
                .build();
        Prestamo prestamo1 = Prestamo.builder()
                .fechaPrestamo(LocalDateTime.of(2024, 10, 9, 12, 12, 12))
                .descripcion("Dejo la cedula de comprobante")
                .numeroPrestamo("420")
                .fechaEntrega(LocalDateTime.of(2024, 10, 15, 12, 12, 12))
                .clienteAsociado(cliente1)
                .empleadoAsociado(empleado1)
                .build();
        Prestamo prestamo2= Prestamo.builder()
                .fechaPrestamo(LocalDateTime.of(2024, 11, 9, 12, 12, 12))
                .descripcion("Lo saco en la plaza")
                .numeroPrestamo("505")
                .fechaEntrega(LocalDateTime.of(2024, 11, 15, 12, 12, 12))
                .clienteAsociado(cliente2)
                .empleadoAsociado(empleado2)
                .build();
        Prestamo prestamo3 = Prestamo.builder()
                .fechaPrestamo(LocalDateTime.of(2024, 12, 9, 12, 12, 12))
                .descripcion("Para la clase de fisica")
                .numeroPrestamo("101")
                .fechaEntrega(LocalDateTime.of(2024, 12, 15, 12, 12, 12))
                .clienteAsociado(cliente3)
                .empleadoAsociado(empleado3)
                .build();
        Prestamo prestamo4 = Prestamo.builder()
                .fechaPrestamo(LocalDateTime.of(2024, 1, 9, 12, 12, 12))
                .descripcion("Estudiante con credencial")
                .numeroPrestamo("123")
                .fechaEntrega(LocalDateTime.of(2024, 1, 15, 12, 12, 12))
                .clienteAsociado(cliente1)
                .empleadoAsociado(empleado1)
                .build();
        Prestamo prestamo5 = Prestamo.builder()
                .fechaPrestamo(LocalDateTime.of(2024, 9, 9, 12, 12, 12))
                .descripcion("Clase en el exterior del edificio")
                .numeroPrestamo("234")
                .fechaEntrega(LocalDateTime.of(2024, 9, 15, 12, 12, 12))
                .clienteAsociado(cliente2)
                .empleadoAsociado(empleado2)
                .build();
        Objeto objeto1 = Objeto.builder()
                .nombre("libro")
                .idObjeto("1AAA")
                .estado(Estado.DISPONIBLE)
                .prestamoAsociado(prestamo1)
                .build();
        Objeto objeto2 = Objeto.builder()
                .nombre("Computador")
                .idObjeto("2BBB")
                .estado(Estado.NO_DISPONIBLE)
                .build();
        Objeto objeto3 = Objeto.builder()
                .nombre("Osciloscopio")
                .idObjeto("3CCC")
                .estado(Estado.DISPONIBLE)
                .prestamoAsociado(prestamo3)
                .build();
        empleado1.getPrestamosAsociados().add(prestamo1);
        empleado1.getPrestamosAsociados().add(prestamo4);
        empleado1.getPrestamosAsociados().add(prestamo2);
        empleado2.getPrestamosAsociados().add(prestamo3);
        empleado3.getPrestamosAsociados().add(prestamo5);
        objeto1.getPrestamos().add(prestamo1);
        objeto1.getPrestamos().add(prestamo2);
        objeto3.getPrestamos().add(prestamo3);
        objeto2.getPrestamos().add(prestamo4);
        objeto2.getPrestamos().add(prestamo5);
        cliente1.getPrestamosAsociados().add(prestamo1);
        cliente1.getPrestamosAsociados().add(prestamo2);
        cliente2.getPrestamosAsociados().add(prestamo3);
        prestamoUq.getObjetos().add(objeto1);
        prestamoUq.getObjetos().add(objeto2);
        prestamoUq.getObjetos().add(objeto3);
        prestamoUq.getClientes().add(cliente1);
        prestamoUq.getClientes().add(cliente2);
        prestamoUq.getClientes().add(cliente3);
        prestamoUq.getEmpleados().add(empleado1);
        prestamoUq.getEmpleados().add(empleado2);
        prestamoUq.getEmpleados().add(empleado3);
        prestamoUq.getPrestamos().add(prestamo1);
        prestamoUq.getPrestamos().add(prestamo2);
        prestamoUq.getPrestamos().add(prestamo3);
        prestamoUq.getPrestamos().add(prestamo4);
        prestamoUq.getPrestamos().add(prestamo5);
        return prestamoUq;
    }
}
