package Model;
import java.util.ArrayList;

public class CarritoModelo {
    private ArrayList<OrdenCompra> ordenesEnCarrito;

    public CarritoModelo() {
        this.ordenesEnCarrito = new ArrayList<>();
    }

    public void agregarOrden(OrdenCompra orden) {
        this.ordenesEnCarrito.add(orden);
    }


    public void eliminarOrden(int numOrden) {
        OrdenCompra ordenAEliminar = null;

        // Recorre toda la lista de órdenes del carrito
        for (OrdenCompra orden : ordenesEnCarrito) {
            // Compara el número de la orden actual con el que buscamos
            if (orden.getNumOrden() == numOrden) {
                ordenAEliminar = orden;
                break;
            }
        }
        if (ordenAEliminar != null) {
            ordenesEnCarrito.remove(ordenAEliminar);
        }
    }

    public OrdenCompra buscarOrden(int numOrden) {
        for (OrdenCompra orden : ordenesEnCarrito) {
            if (orden.getNumOrden() == numOrden) {
                return orden;
            }
        }
        return null; // No se encontró la orden.
    }

    public ArrayList<OrdenCompra> getOrdenesEnCarrito() {
        return ordenesEnCarrito;
    }
}
