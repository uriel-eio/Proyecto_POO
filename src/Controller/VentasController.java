package Controller;

import Model.Cliente;
import Model.CarritoModelo;
import Model.OrdenCompra;
import Model.RepositorioClientes;
import Model.RepositorioSalas;
import Model.Sala;
import View.Principal;
import View.Carrito;
import View.SelecAsientos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentasController {
    // --- Dependencias de Modelo y Vista ---
    private final RepositorioClientes repoClientes;
    private final RepositorioSalas repoSalas;
    private final Principal vistaPrincipal;

    // --- Variables de Estado ---
    private Cliente clienteActivo;
    private Carrito vistaCarritoActiva;

    /**
     * Constructor del controlador de ventas.
     * Recibe los repositorios necesarios y la vista principal.
     *
     * @param repoClientes Repositorio de clientes
     * @param repoSalas    Repositorio de salas
     * @param vistaPrincipal Vista principal del sistema
     */
    public VentasController(RepositorioClientes repoClientes, RepositorioSalas repoSalas, Principal vistaPrincipal) {
        this.repoClientes = repoClientes;
        this.repoSalas = repoSalas;
        this.vistaPrincipal = vistaPrincipal;
    }

    /**
     * Orquesta la apertura de la ventana del carrito para un cliente específico.
     *
     * @param principal La ventana principal (vista)
     * @param cedula    La cédula del cliente cuyo carrito se va a abrir
     */
    public void abrirCarrito(Principal principal, long cedula) {
        // Busca al cliente
        Cliente clienteEncontrado = repoClientes.buscarClientePorCedula(cedula);
        if (clienteEncontrado == null) {
            JOptionPane.showMessageDialog(vistaPrincipal, "No se encontró el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Guarda el estado: establece el cliente activo y crea la nueva vista del carrito
        this.clienteActivo = clienteEncontrado;
        this.vistaCarritoActiva = new Carrito();

        // Configura las relaciones entre los componentes
        vistaCarritoActiva.setControladorVentas(this);
        vistaCarritoActiva.setPrincipal(vistaPrincipal);

        // "Pinta" la vista con los datos del modelo
        vistaCarritoActiva.labelNombre.setText(clienteActivo.getNombre());

        ArrayList<OrdenCompra> ordenes = clienteActivo.getCarritoModel().getOrdenesEnCarrito();
        vistaCarritoActiva.actualizarTabla(ordenes);

        // Gestiona la visibilidad de las ventanas
        vistaPrincipal.setVisible(false);
        vistaCarritoActiva.setVisible(true);
    }

    /**
     * Procesa el pago de una orden de compra específica.
     *
     * @param numOrden El ID de la orden a pagar
     */
    public void pagarOrden(int numOrden) {
        if (this.clienteActivo == null) {
            JOptionPane.showMessageDialog(vistaCarritoActiva, "Error: No hay un cliente activo.", "Error de Sesión", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
     * Maneja la acción de seleccionar una sala y abrir la ventana de selección de asientos.
     *
     * @param tablaSalas Tabla de salas (JTable) donde el usuario selecciona la sala
     */
    public void manejarSeleccionAsientos(javax.swing.JTable tablaSalas) {
        int filaSeleccionada = tablaSalas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Debes seleccionar una sala primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(vistaPrincipal, "No se encontró la sala seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        abrirSeleccionAsientos(salaSeleccionada);
    }


    /**
     * Abre la ventana de selección de asientos para la sala dada.
     *
     * @param salaSeleccionada Sala que se quiere mostrar para selección de asientos
     */
    public void abrirSeleccionAsientos(Sala salaSeleccionada) {
        if (salaSeleccionada == null) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Sala inválida o no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean esVip = salaSeleccionada.isVip();
        SelecAsientos vistaAsientos = new SelecAsientos(salaSeleccionada, esVip);
        vistaAsientos.setVisible(true);
    }

    /**
     * Pendiente: crea una orden de compra a partir de las selecciones en la pestaña "Ventas"
     * y la añade al carrito del cliente activo.
     */
    /*public void agregarOrdenAlCarrito() {
        JOptionPane.showMessageDialog(vistaPrincipal, "Funcionalidad 'Agregar al Carrito' pendiente de implementación.", "Pendiente", JOptionPane.INFORMATION_MESSAGE);
    }*/
}
