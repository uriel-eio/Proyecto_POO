package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Util.ManejoErrores;
import java.awt.HeadlessException;

public class VentasController {
    private Principal vista;
    private LogicaOrdenes logicaOrdenes;
    private final SalasRepositorio repoSalas;
    public Principal getVista() {
        return this.vista;
    }
    public VentasController(Principal vista, SalasRepositorio repoSalas) {
        this.vista = vista;
        this.logicaOrdenes = new LogicaOrdenes();
        this.repoSalas = repoSalas;
        this.vista.botonAsignarAsientos.addActionListener(e -> {
            manejarSeleccionAsientos(this.vista.getTableSalas());
        });
    }
    
    /**
     * Procesa el pago de una orden
     */
    public void pagarOrden(int numOrden, Cliente cliente) {
        try {
            boolean resultado = logicaOrdenes.pagarOrden(numOrden, cliente);
            
            if (resultado) {
                JOptionPane.showMessageDialog(vista, 
                    "Orden #" + numOrden + " pagada correctamente", 
                    "Pago exitoso", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, 
                    "Error al procesar el pago de la orden #" + numOrden, 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al pagar la orden", e, vista);
        }
    }
    
    /**
     * Abre la ventana del carrito para un cliente
     */
    public void abrirCarrito(Cliente cliente) {
        if (cliente == null) {
            JOptionPane.showMessageDialog(vista, 
                "Debe seleccionar un cliente primero", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Carrito vistaCarrito = new Carrito(this, vista);
            CarritoController carritoController = new CarritoController(vistaCarrito, cliente);
            
            vistaCarrito.setVisible(true);
            vista.setVisible(false);
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al abrir el carrito", e, vista);
        }
    }
    
    /**
     * Crea una nueva orden para un cliente
     * @param cliente
     * @param funcion
     * @param asientos
     */
    public void crearNuevaOrden(Cliente cliente, Funcion funcion, ArrayList<Asiento> asientos) {
        if (cliente == null) {
            JOptionPane.showMessageDialog(vista, 
                "Debe seleccionar un cliente primero", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            OrdenCompra nuevaOrden = logicaOrdenes.crearOrden(funcion, asientos, cliente);
            
            if (nuevaOrden != null) {
                JOptionPane.showMessageDialog(vista, 
                    "Orden creada exitosamente para la película " + 
                    funcion.getPelicula().obtenerTitulo() + 
                    " con " + asientos.size() + " asientos.\n" +
                    "Total: $" + nuevaOrden.getPrecioTotal(), 
                    "Orden Creada", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException e) {
            ManejoErrores.mostrarError("Error al crear la orden", e, vista);
        }
    }
    public void agregarAlCarrito(Principal vista, Cliente cliente, int cantidadTickets) {
    // Implementación para agregar items al carrito
    JOptionPane.showMessageDialog(vista, 
        "Se agregaron " + cantidadTickets + " tickets al carrito de " + cliente.getNombre(), 
        "Agregado al carrito", 
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    //parte que se agregara
    public void manejarSeleccionAsientos(javax.swing.JTable tablaSalas) {
        int filaSeleccionada = tablaSalas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Debes seleccionar una sala primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Nombre de la sala está en la columna 1
        String nombreSala = (String) tablaSalas.getValueAt(filaSeleccionada, 1);
        Sala salaSeleccionada = null;

        // Busca la sala en el repositorio
        for (Sala s : repoSalas.getSala()) {
            if (s.getNombre().equals(nombreSala)) {
                salaSeleccionada = s;
                break;
            }
        }

        if (salaSeleccionada == null) {
            JOptionPane.showMessageDialog(vista, "No se encontró la sala seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        abrirSeleccionAsientos(salaSeleccionada);
    }
     
// En VentasController.java
    public void abrirSeleccionAsientos(Sala salaSeleccionada) {
        if (salaSeleccionada == null) {
            JOptionPane.showMessageDialog(vista, "Sala inválida o no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Creamos la vista de asientos, pasándole el propio VentasController (`this`)
        SelecAsientos vistaAsientos = new SelecAsientos(salaSeleccionada, salaSeleccionada.isVip(), this);
        vistaAsientos.setVisible(true);
    }

}