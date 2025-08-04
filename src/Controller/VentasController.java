package Controller;

import Model.Venta;
import java.util.List;

/**
 * Controlador para la gestión de ventas siguiendo el patrón MVC y principios SOLID.
 * Principio de Responsabilidad Única: Solo maneja operaciones relacionadas con ventas
 */
public class VentasController {
    
    private final IVentasView view;
    private final IVentasRepository repository;
    
    /**
     * Constructor con inyección de dependencias (Principio de Inversión de Dependencias)
     */
    public VentasController(IVentasView view, IVentasRepository repository) {
        this.view = view;
        this.repository = repository;
    }
    
    /**
     * Crear una nueva venta
     */
    public void crearVenta(Venta venta) {
        repository.guardar(venta);
        view.mostrarMensaje("Venta creada exitosamente");
        actualizarVistaVentas();
    }
    
    /**
     * Obtener todas las ventas
     */
    public List<Venta> obtenerVentas() {
        return repository.obtenerTodos();
    }
    
    /**
     * Buscar venta por ID
     */
    public Venta buscarVentaPorId(int id) {
        return repository.buscarPorId(id);
    }
    
    /**
     * Actualizar una venta
     */
    public void actualizarVenta(Venta venta) {
        boolean actualizado = repository.actualizar(venta);
        if (actualizado) {
            view.mostrarMensaje("Venta actualizada exitosamente");
            actualizarVistaVentas();
        } else {
            view.mostrarMensaje("No se encontró la venta con ID: " + venta.getId());
        }
    }
    
    /**
     * Eliminar una venta
     */
    public void eliminarVenta(int id) {
        boolean eliminado = repository.eliminar(id);
        if (eliminado) {
            view.mostrarMensaje("Venta eliminada exitosamente");
            actualizarVistaVentas();
        } else {
            view.mostrarMensaje("No se encontró la venta con ID: " + id);
        }
    }
    
    /**
     * Actualizar la vista con los datos actuales de ventas
     */
    private void actualizarVistaVentas() {
        view.mostrarVentas(repository.obtenerTodos());
    }
}