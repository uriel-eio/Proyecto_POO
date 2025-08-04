package Model;

import java.util.ArrayList;
import Util.ManejoErrores;

/**
 * Lógica de negocio relacionada con órdenes de compra
 */
public class LogicaOrdenes {
    
    /**
     * Crea una nueva orden de compra
     * @param funcion La función para la que se compran entradas
     * @param asientos Los asientos seleccionados
     * @param cliente El cliente que realiza la compra
     * @return La orden creada
     */
    public OrdenCompra crearOrden(Funcion funcion, ArrayList<Asiento> asientos, Cliente cliente) {
        try {
            // Verificar que haya un carrito
            CarritoModelo carrito = obtenerOCrearCarrito(cliente);
            
            // Generar número de orden
            int numeroOrden = carrito.getOrdenesEnCarrito().size() + 1;
            
            // Crear la orden
            OrdenCompra nuevaOrden = new OrdenCompra(numeroOrden, funcion, asientos);
            
            // Agregar al carrito
            carrito.agregarOrden(nuevaOrden);
            
            // Reservar los asientos
            reservarAsientos(asientos);
            
            return nuevaOrden;
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al crear la orden", e);
            return null;
        }
    }
    
    /**
     * Obtiene el carrito existente o crea uno nuevo
     */
    private CarritoModelo obtenerOCrearCarrito(Cliente cliente) {
        if (cliente.getCarritoModel() != null) {
            return cliente.getCarritoModel();
        } else {
            CarritoModelo nuevoCarrito = new CarritoModelo();
            cliente.setCarritoModel(nuevoCarrito);
            return nuevoCarrito;
        }
    }
    
    /**
     * Reserva los asientos seleccionados
     */
    private void reservarAsientos(ArrayList<Asiento> asientos) {
        for (Asiento asiento : asientos) {
            if (!asiento.obtenerEstado()) {
                asiento.reservar();
            }
        }
    }
    
    /**
     * Realiza el pago de una orden
     * @param numOrden Número de la orden a pagar
     * @param cliente Cliente que realiza el pago
     * @return true si el pago fue exitoso
     */
    public boolean pagarOrden(int numOrden, Cliente cliente) {
        try {
            // Verificar que el cliente tenga un carrito
            if (cliente.getCarritoModel() == null) {
                return false;
            }
            
            // Buscar la orden
            OrdenCompra orden = cliente.getCarritoModel().buscarOrden(numOrden);
            if (orden == null) {
                return false;
            }
            
            // Verificar que no esté pagada
            if (orden.isPagada()) {
                return false;
            }
            
            // Marcar como pagada
            orden.setPagada(true);
            return true;
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al procesar el pago", e);
            return false;
        }
    }
    
    /**
     * Obtiene todas las órdenes de un cliente
     * @param cliente El cliente
     * @return Lista de órdenes o lista vacía si no hay
     */
    public ArrayList<OrdenCompra> obtenerOrdenesCliente(Cliente cliente) {
        if (cliente != null && cliente.getCarritoModel() != null) {
            return cliente.getCarritoModel().getOrdenesEnCarrito();
        }
        return new ArrayList<>();
    }
}