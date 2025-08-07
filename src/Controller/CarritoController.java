package Controller;

import Model.*;
import View.Carrito;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Util.ManejoErrores;

public class CarritoController {
    private final Carrito vista;
    private final Cliente cliente;
    private final LogicaOrdenes logicaOrdenes;
    
    public CarritoController(Carrito vista) {
        this.vista = vista;
        this.cliente = null; // No hay un cliente específico.
        this.logicaOrdenes = new LogicaOrdenes();

        // Llamamos a los métodos para preparar la vista y llenarla con todas las ventas
        vista.prepararComoRegistroGlobal();
        ArrayList<OrdenCompra> todasLasVentas = RegistroVentasModelo.obtenerTodasLasVentas();
        vista.actualizarTabla(todasLasVentas);
    }
    /**
     * Inicializa la vista con los datos del cliente y carrito
     */
    private void inicializarVista() {
        // Mostrar datos del cliente en la vista
        vista.mostrarDatosCliente(cliente);
        
        // Cargar órdenes del carrito en la tabla
        actualizarVistaCarrito();
    }
    
    /**
     * Actualiza la vista del carrito con las órdenes actuales
     */
    private void actualizarVistaCarrito() {
        ArrayList<OrdenCompra> ordenes = logicaOrdenes.obtenerOrdenesCliente(cliente);
        vista.actualizarTabla(ordenes);
    }
    
    /**
     * Procesa el pago de una orden
     */
    public void pagarOrden(int numOrden) {
        boolean resultado = logicaOrdenes.pagarOrden(numOrden, cliente);
        
        if (resultado) {
            mostrarMensajePagoExitoso(numOrden);
        } else {
            mostrarMensajeErrorPago(numOrden);
        }
        
        // Actualizar la vista
        actualizarVistaCarrito();
    }
    
    /**
     * Muestra mensaje de pago exitoso
     */
    private void mostrarMensajePagoExitoso(int numOrden) {
        OrdenCompra orden = cliente.getCarritoModel().buscarOrden(numOrden);
        JOptionPane.showMessageDialog(vista, 
            "Orden #" + numOrden + " pagada correctamente.\n" +
            "Monto total: $" + orden.getPrecioTotal(), 
            "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra mensaje de error en el pago
     */
    private void mostrarMensajeErrorPago(int numOrden) {
        OrdenCompra orden = cliente.getCarritoModel().buscarOrden(numOrden);
        
        if (orden == null) {
            JOptionPane.showMessageDialog(vista, 
                "No se encontró la orden #" + numOrden, 
                "Error", JOptionPane.ERROR_MESSAGE);
        } else if (orden.isPagada()) {
            JOptionPane.showMessageDialog(vista, 
                "Esta orden ya ha sido pagada anteriormente.", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vista, 
                "Hubo un error al procesar el pago. Intente nuevamente.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Agrega una nueva orden al carrito
     */
    public void agregarOrden(Funcion funcion, ArrayList<Asiento> asientosSeleccionados) {
        try {
            OrdenCompra nuevaOrden = logicaOrdenes.crearOrden(funcion, asientosSeleccionados, cliente);
            
            if (nuevaOrden != null) {
                mostrarConfirmacionOrdenAgregada(funcion, asientosSeleccionados, nuevaOrden);
                actualizarVistaCarrito();
            }
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al agregar la orden", e, vista);
        }
    }
    
    /**
     * Muestra confirmación cuando se agrega una orden
     */
    private void mostrarConfirmacionOrdenAgregada(Funcion funcion, ArrayList<Asiento> asientosSeleccionados, OrdenCompra nuevaOrden) {
        JOptionPane.showMessageDialog(vista, 
            "Se ha agregado una nueva orden al carrito.\n" +
            "Película: " + funcion.getPelicula().obtenerTitulo() + "\n" +
            "Asientos: " + asientosSeleccionados.size() + "\n" +
            "Total: $" + nuevaOrden.getPrecioTotal(), 
            "Orden Agregada", JOptionPane.INFORMATION_MESSAGE);
    }
}