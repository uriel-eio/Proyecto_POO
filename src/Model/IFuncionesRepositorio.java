package Model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz para el repositorio de funciones
 */
public interface IFuncionesRepositorio {
    List<Funcion> obtenerFunciones();
    Funcion obtenerFuncionPorId(String id);
    void agregarFuncion(Funcion funcion);
    void agregarFuncion(Pelicula pelicula, Sala sala, LocalDateTime fechaHora);
    boolean actualizarFuncion(Funcion funcion);
    boolean eliminarFuncion(String id);
}