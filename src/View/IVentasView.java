package View;

import Model.Venta;
import java.util.List;

/**
 * Interfaz para vistas que muestran ventas
 */
public interface IVentasView {
    void mostrarVentas(List<Venta> ventas);
    void mostrarVenta(Venta venta);
    void mostrarMensaje(String mensaje);
}