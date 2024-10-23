package co.edu.uniquindio.parcial2.parcial2.services;

import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;

import java.time.LocalDateTime;
import java.util.List;

public interface IModelFactoryService {
    List<Cliente> obtenerClientes();

    List<Prestamo> obtenerPrestamoEspecifico(LocalDateTime rango);

    List<Prestamo> obtenerPrestamoRango(LocalDateTime rangoInicial, LocalDateTime rangoFinal);
}
