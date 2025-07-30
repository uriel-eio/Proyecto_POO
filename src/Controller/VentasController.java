package Controller;

import Model.Cliente;
import Model.CarritoModelo;
import Model.OrdenCompra;
import Model.RepositorioClientes;
import View.Principal;
import View.Carrito;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentasController {
    //--- Dependencias de Modelo y Vista--
    private final RepositorioClientes repoClientes;
    private final Principal vistaPrincipal;
    //--- Variables de Estado--
    private Cliente clienteActivo;
    private Carrito vistaCarritoActiva;

    public VentasController(RepositorioClientes repoClientes, Principal vistaPrincipal) {
        this.repoClientes = repoClientes;
        this.vistaPrincipal = vistaPrincipal;
    }

    /**
     * Orquesta la apertura de la ventana del carrito para un cliente específico.
     * @param cedula La cédula del cliente cuyo carrito se va a abrir.
     */
    
    public void abrirCarrito(Principal principal, long cedula) {
        // Buscamos al cliente
        Cliente clienteEncontrado = repoClientes.buscarClientePorCedula(cedula);
        if (clienteEncontrado == null) {
            JOptionPane.showMessageDialog(vistaPrincipal, "No se encontró el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Guarda el estado: establece el cliente activo y crea la nueva VISTA del carrito
        this.clienteActivo = clienteEncontrado;
        this.vistaCarritoActiva = new Carrito();
        // Configura las relaciones entre los componentes
        vistaCarritoActiva.setControladorVentas(this);
        vistaCarritoActiva.setPrincipal(vistaPrincipal);
        // "Pinta" la Vista con los datos del Modelo
        vistaCarritoActiva.labelNombre.setText(clienteActivo.getNombre());
        //De donde es esto? lo comento por si acaso
        //vistaCarritoActiva.labelCedula.setText(String.valueOf(clienteActivo.getCedula()));
        
        ArrayList<OrdenCompra> ordenes = clienteActivo.getCarritoModel().getOrdenesEnCarrito();
        vistaCarritoActiva.actualizarTabla(ordenes);
        // Gestiona la visibilidad de las ventanas
        vistaPrincipal.setVisible(false);
        vistaCarritoActiva.setVisible(true);
    }

    /**
     * Procesa el pago de una orden de compra específica.
     * @param numOrden El ID de la orden a pagar.
     */
    public void pagarOrden(int numOrden) {
        if (this.clienteActivo == null) {
            JOptionPane.showMessageDialog(vistaCarritoActiva, "Error: No hay un cliente activo.", "Error de Sesión", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TODO COMENTEN
        CarritoModelo carritoDelCliente = clienteActivo.getCarritoModel();
        OrdenCompra ordenAPagar = carritoDelCliente.buscarOrden(numOrden);
        if (ordenAPagar != null) {
            if (ordenAPagar.isPagada()) {
                JOptionPane.showMessageDialog(vistaCarritoActiva, "Esta orden ya ha sido pagada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            ordenAPagar.setPagada(true);
            vistaCarritoActiva.actualizarTabla(carritoDelCliente.getOrdenesEnCarrito());
            JOptionPane.showMessageDialog(vistaCarritoActiva, "¡Orden de Compra pagada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vistaCarritoActiva, "No se encontró la orden de compra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Crea una OrdenCompra a partir de las selecciones en la pestaña "Ventas"
     * y la añade al carrito del cliente activo.
     * Pendiente de implementación.
     */
    /*public void agregarOrdenAlCarrito() {
       istaPrincipal, "Funcionalidad 'Agregar al Carrito' pendiente de implementación.", "Pendiente", JOptionPane.INFORMATION_MESSAGE);
    }*/
}