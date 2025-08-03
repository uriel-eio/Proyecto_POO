package Controller;

import Model.Cliente;
import Model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import View.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ClienteController {
    // #### Variables con los datos principales ####
    private RepositorioClientes repoClientes;
    //private Cliente clienteActivo;
    private Principal vista;

    // #### VARIABLES DE MANEJO DE ESTADO ####
    //private Cliente clienteActivo;
    //private Carrito vistaCarritoActiva; // Debe ser de tipo 'Carrito' (la Vista/JFrame)
    
    public ClienteController(Sala sala) {
        this.repoClientes = new RepositorioClientes();
        //Creamos los archivos .txt con datos si no existen
        //repoClientes.inicializarDatosPredeterminados();
        //this.vista = new SelecAsientos(); // Crea la vista sin pasarle la sala
        //agregarBotonesAsientos();
    }

    public ClienteController(RepositorioClientes repoClientes, Principal vista) {
        this.repoClientes = repoClientes;
        this.vista = vista;
        //Creamos los archivos .txt con datos si no existen
        //repoClientes.inicializarDatosPredeterminados();
    }
    
    /*public void buscarClienteV(Principal principal){
        // Se verifica si se ingresó alguna cédula
        if(principal.textFieldCedulaC.getText().equals("Ingrese Cédula")){
            JOptionPane.showMessageDialog(principal, "Ingrese la cédula del Cliente que desee buscar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Se verifica si la cédula ingresada pertenece al de algun Cliente
        String cedulaBuscar = String.valueOf(principal.textFieldCedulaC.getText());
        for (int i = 0; i < principal.tableClientes.getRowCount(); i++) {
            if(String.valueOf(principal.tableClientes.getValueAt(i, 1)).equals(cedulaBuscar)){
                principal.tableClientes.changeSelection(i, 1, false, false);
                principal.textFieldCedulaC.setText("Ingrese Cédula");
                return;
            }
        }
        
       JOptionPane.showMessageDialog(principal, "La Cédula que ingresó no pertenece a la de ningún Cliente", "Error", JOptionPane.ERROR_MESSAGE);
    }*/
    
    public void buscarClienteVentas(Principal principal){
        // Verifica si se ingresó alguna cédula
        String cedulaTexto = principal.textFieldClienteV.getText();
        if (cedulaTexto.equals("Ingrese Cédula") || cedulaTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(principal, "Ingrese la cédula del Cliente que desee buscar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long cedulaBuscar;
        try {
            cedulaBuscar = Long.parseLong(cedulaTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(principal, "Ingrese una cédula válida (solo números)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        RepositorioClientes repo = new RepositorioClientes();
        ArrayList<Cliente> clientes = repo.obtenerCliente();

        Cliente clienteEncontrado = null;
        for (Cliente c : clientes) {
            if (c.getCedula() == cedulaBuscar) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado == null) {
            JOptionPane.showMessageDialog(principal, "La cédula ingresada no pertenece a ningún cliente", "Error", JOptionPane.ERROR_MESSAGE);
            principal.textFieldClienteV.setText("Ingrese Cédula");
            return;
        }

        // Si lo encuentras, aquí puedes hacer lo que necesites (mostrar datos, llenar campos, etc.)
        JOptionPane.showMessageDialog(principal, "¡Cliente encontrado!\nNombre: " + clienteEncontrado.getNombre());
        principal.textFieldClienteV.setText("Ingrese Cédula");
        
    }
    
    public Cliente buscarClientePorCedula(long cedula) {
        return repoClientes.buscarClientePorCedula(cedula);
    }
    
    public void crearCliente(Principal principal){
        boolean flag1, flag2; flag1=flag2=false;
        
        // Validamos la cédula
        long cedula = 0;
        
        do{
            flag1 = flag2 = false;
            try {
                    cedula = Integer.parseInt(JOptionPane.showInputDialog(principal, "        Ingrese la cédula del cliente\n          (De 1 millon a 30millones)", "Ingrese cédula", JOptionPane.QUESTION_MESSAGE));
                    if(!String.valueOf(cedula).matches("[0-9]*$")){
                        JOptionPane.showMessageDialog(principal, "Ingresó una cédula inválida\n  (No ingrese ni letras ni símbolos)", "Error", JOptionPane.ERROR_MESSAGE);
                        flag1= true;
                    }
                    if(cedula < 1000000 || cedula > 30000000){
                        JOptionPane.showMessageDialog(principal, "Ingresó un número inválido\n  (De 1 millon a 30millones)", "Error", JOptionPane.ERROR_MESSAGE);
                        flag2 = true;
                    }
            } catch (Exception e) {
                return;
            }
        }while(flag1 == true || flag2 == true);
        
        // Validamos el nombre
        String nombre = "";
        
        do{
            flag1 = false;
            try {
                nombre = JOptionPane.showInputDialog(principal, "    Ingrese el nombre del Cliente", "Ingrese nombre", JOptionPane.QUESTION_MESSAGE);
                if(!nombre.matches("[a-zA-Z ]*$")){
                    JOptionPane.showMessageDialog(principal, "Ingresó un nombre inválido\n  (No ingrese números ni símbolos)", "Error", JOptionPane.ERROR_MESSAGE);
                    flag1 = true;
                    System.out.println(flag1);
                }
            } catch (Exception e) {
                return;
            }
        }while(flag1 == true);
        
        // Validamos el teléfono
        String telefono = "";
        
        do{
            flag1 = flag2 = false;
            try {
                telefono = JOptionPane.showInputDialog(principal, "        Ingrese el teléfono del cliente", "Ingrese teléfono", JOptionPane.QUESTION_MESSAGE);
                if(!telefono.matches("[0-9]*$")){
                    JOptionPane.showMessageDialog(principal, "Ingresó un formato de teléfono incorrecto\n   No ponga ni letras ni símbolos", "Error", JOptionPane.ERROR_MESSAGE);
                    flag1 = true;
                }
                if(telefono.length() != 10){
                    JOptionPane.showMessageDialog(principal, "Su teléfono tiene más/menos números de los que debería", "Error", JOptionPane.ERROR_MESSAGE);
                    flag2 = true;
                }
            } catch (Exception e) {
                return;
            }
        }while(flag1 == true || flag2 == true);
        
        Cliente cliente = new Cliente(cedula, nombre, telefono);
        
        repoClientes.guardarCliente(cliente);
        
        this.cargarClientesEnVista();
    }
    
    public void iniciarTablaClientes(Principal principal){
        // Permitir la selección de solo una fila
        principal.tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Denegar el acceso a modificar
        principal.tableClientes.getTableHeader().setReorderingAllowed(false);
        principal.tableClientes.getTableHeader().setResizingAllowed(false);
        // Tamaño de cada columna
        principal.tableClientes.getColumnModel().getColumn(0).setPreferredWidth(170);
        principal.tableClientes.getColumnModel().getColumn(1).setPreferredWidth(175);
        principal.tableClientes.getColumnModel().getColumn(2).setPreferredWidth(187);
        // Altura de cada renglón
        principal.tableClientes.setRowHeight(20);
    }
    
    public void modificarTelefonoCliente(Principal principal, String nuevoTelefono, long cedula) {
        // desde el archivo obetengo la lita y la transformo en un array
        RepositorioClientes repo = new RepositorioClientes();
        ArrayList<Cliente> clientes = repo.obtenerCliente();

        // busca el cliente y modificar su fono
        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getCedula() == cedula) {
                c.setTelefono(nuevoTelefono);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt"))) {
                for (Cliente c : clientes) {
                    bw.write(c.toCSV());
                    bw.newLine();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(principal, "Error al guardar el cliente modificado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        for (int i = 0; i < principal.tableClientes.getRowCount(); i++) {
            if (cedula == Long.parseLong(String.valueOf(principal.tableClientes.getValueAt(i, 1)))) {
                principal.tableClientes.setValueAt(nuevoTelefono, i, 2);
            }
        }
    }
    
    public void cargarClientesEnVista() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tableClientes.getModel();
        modelo.setRowCount(0); // Limpiar la tabla primero

        ArrayList<Cliente> clientes = repoClientes.obtenerCliente(); // Obtener todos los clientes
        vista.actualizarTablaClientes(clientes);

        for (Cliente cliente : clientes) {
            modelo.addRow(new Object[]{
                cliente.getNombre(),
                cliente.getCedula(),
                cliente.getTelefono()
            });

            // También puedes llenar el comboBox de clientes si lo necesitas
            //principal.comboClientesV.addItem(String.valueOf(cliente.getCedula()));
        }
    }
    
}