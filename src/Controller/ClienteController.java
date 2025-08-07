package Controller;

import Model.Cliente;
import Model.IClienteRepositorio;
import View.Principal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteController {
    private final IClienteRepositorio repoClientes;
    private Principal vista;
    
    // Constructor recibe la dependencia en lugar de crearla
    public ClienteController(IClienteRepositorio repoClientes) {
        this.repoClientes = repoClientes;
    }
    
    // Método para establecer la vista después de la construcción
    public void setVista(Principal vista) {
        this.vista = vista;
    }
    
    public void iniciarTablaClientes(Principal vista) {
        this.vista = vista;
        vista.configurarTablaClientes();
    }
    
    public void cargarClientesEnVista() {
        if (vista == null) {
            return; // No hacer nada si no hay vista
        }
        
        ArrayList<Cliente> clientes = repoClientes.obtenerCliente();
        DefaultTableModel modelo = (DefaultTableModel) vista.getTableClientes().getModel();
        modelo.setRowCount(0); // Limpia la tabla
        
        for (Cliente cliente : clientes) {
            modelo.addRow(new Object[]{
                cliente.getNombre(),
                cliente.getCedula(),
                cliente.getTelefono()
            });
        }
    }
    
    public Cliente buscarClientePorCedula(long cedula) {
        return repoClientes.buscarClientePorCedula(cedula);
    }
    
    public void buscarClienteVentas(Principal vista) {
        try {
            long cedula = Long.parseLong(vista.getTextFieldClienteV().getText());
            Cliente cliente = repoClientes.buscarClientePorCedula(cedula);
            
            if (cliente != null) {
                vista.getLabelNombreCliente().setText(cliente.getNombre());
            } else {
                vista.getLabelNombreCliente().setText("Cliente no encontrado");
                JOptionPane.showMessageDialog(vista, "No se encontró ningún cliente con esa cédula", "Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese un número de cédula válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarTelefonoCliente(Principal vista, String nuevoTelefono, long cedula) {
        boolean actualizado = repoClientes.actualizarCliente(cedula, nuevoTelefono);
        
        if (actualizado) {
            JOptionPane.showMessageDialog(vista, "Teléfono actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarClientesEnVista(); // Recargar los datos en la vista
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo actualizar el teléfono", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void crearCliente(Principal vista) {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del cliente:");
            if (nombre == null || nombre.trim().isEmpty()) return;
            
            String cedulaStr = JOptionPane.showInputDialog(vista, "Ingrese la cédula del cliente:");
            if (cedulaStr == null || cedulaStr.trim().isEmpty()) return;
            long cedula = Long.parseLong(cedulaStr);
            if (cedulaStr.length() != 10) {
                JOptionPane.showMessageDialog(vista, "La cédula debe tener exactamente 10 dígitos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            String telefono = JOptionPane.showInputDialog(vista, "Ingrese el teléfono del cliente:");
            if (telefono == null || telefono.trim().isEmpty()) return;
            
            Cliente cliente = new Cliente(cedula, nombre, telefono);
            repoClientes.guardarCliente(cliente);
            
            JOptionPane.showMessageDialog(vista, "Cliente registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error en formato de cédula. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al registrar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            public void cargarClientesEnComboBox(JComboBox<String> comboBox) {

            comboBox.removeAllItems();

            comboBox.addItem("Seleccione un cliente");

            ArrayList<Cliente> clientes = repoClientes.obtenerCliente();

            for (Cliente cliente : clientes) {
                comboBox.addItem(cliente.getNombre() + " - " + cliente.getCedula());
            }
        }
}