package Controller;

import Model.Venta;
import java.util.List;

public interface IVentasRepository {
    void guardar(Venta venta);
    List<Venta> obtenerTodos();
    Venta buscarPorId(int id);
    boolean actualizar(Venta venta);
    boolean eliminar(int id);
}