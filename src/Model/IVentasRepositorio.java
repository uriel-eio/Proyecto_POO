package Model;

import java.util.List;

/**
 * Interfaz para el repositorio de ventas
 */
public interface IVentasRepositorio {
    void guardar(Venta venta);
    List<Venta> obtenerTodos();
    Venta buscarPorId(int id);
    boolean actualizar(Venta venta);
    boolean eliminar(int id);
}