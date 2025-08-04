package Controller;

import Model.Venta;
import java.util.List;

public interface IVentasView {
    void mostrarVentas(List<Venta> ventas);
    void mostrarVenta(Venta venta);
    void mostrarMensaje(String mensaje);
}