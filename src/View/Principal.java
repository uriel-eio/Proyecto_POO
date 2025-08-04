package View;

import Controller.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import Model.*;
import Util.ManejoErrores;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Principal extends javax.swing.JFrame {

    // Controladores
    private PeliculasController controladorPeliculas;
    private VentasController controladorVentas;
    private ClienteController controladorCliente;
    private SalasController controladorSalas;
    private AppController controladorApp;
    
    // Variables de estado
    private Cliente clienteSeleccionado;
    private Pelicula peliculaSeleccionada;
    
    // Botones de control de ventana
    private JButton btnSalir;
    private JButton btnMaximizar;
    
    public Principal() {
        initComponents();
        btnSalir = new JButton("Salir");
        btnMaximizar = new JButton("Maximizar");

        btnSalir.setBackground(Color.RED);
        btnMaximizar.setBackground(Color.GREEN);

        btnSalir.addActionListener(e -> System.exit(0));
        
        btnMaximizar.addActionListener(e -> {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(true);  
        });

        btnMaximizar.setBounds(450, 10, 100, 30); 
        btnSalir.setBounds(450, 50, 100, 30);

        this.add(btnMaximizar);
        this.add(btnSalir);

        configurarTablaPeliculas();
        // Configuración puramente visual
        UIManager.put("TabbedPane.selected", new Color(57, 62, 70));
        jTabbedPane2.setForeground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setSize(600, 430);
        this.setBackground(new Color(0, 0, 0, 0));
    }

    public void setControllers(AppController app, ClienteController clientes, PeliculasController peliculas, SalasController salas, VentasController ventas) {
        this.controladorApp = app;
        this.controladorCliente = clientes;
        this.controladorPeliculas = peliculas;
        this.controladorSalas = salas;
        this.controladorVentas = ventas;
        
        // Configurar eventos una vez que tenemos los controladores
        configurarEventos();
    }
    
    private void configurarEventos() {
        // Eventos de la pestaña películas
        botonAgregarPeliculaP.addActionListener(e -> {
            try {
                controladorPeliculas.agregarNuevaPelicula();
            } catch (Exception ex) {
                ManejoErrores.mostrarError("Error al agregar película", ex, this);
            }
        });
        
        // Eventos de la pestaña clientes
        botonBuscarClienteV.addActionListener(e -> buscarCliente());
        botonCarritoC.addActionListener(e -> abrirCarrito());
        botonRegistrarC1.addActionListener(e -> registrarCliente());
        botonModificar.addActionListener(e -> modificarCliente());
        
        // Eventos de la pestaña salas
        botonCambiarPeliculaSa1.addActionListener(e -> {
            try {
                controladorSalas.asignarPeliculaASala();
            } catch (Exception ex) {
                ManejoErrores.mostrarError("Error al asignar película a sala", ex, this);
            }
        });
        
        // Eventos de la pestaña ventas
        comboSalasV.addActionListener(e -> seleccionarSala());
    }
    
    private void configurarTablaPeliculas() {
        tablePeli.getColumnModel().getColumn(3).setCellRenderer(new RenderizadorImagenes());
        tablePeli.setRowHeight(300); 
    }
    
    public void configurarTablaClientes() {
        tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientes.getTableHeader().setReorderingAllowed(false);
        tableClientes.getTableHeader().setResizingAllowed(false);
        // Tamaño de cada columna
        tableClientes.getColumnModel().getColumn(0).setPreferredWidth(170);
        tableClientes.getColumnModel().getColumn(1).setPreferredWidth(175);
        tableClientes.getColumnModel().getColumn(2).setPreferredWidth(187);
        // Altura de cada renglón
        tableClientes.setRowHeight(20);
    }
    
    // Métodos para manejar acciones del usuario
    
    private void buscarCliente() {
        try {
            String cedulaStr = textFieldClienteV.getText().trim();
            if (cedulaStr.isEmpty() || "Ingrese Cédula".equals(cedulaStr)) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, ingrese una cédula para buscar", 
                    "Campo vacío", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            controladorCliente.buscarClienteVentas(this);
        } catch (Exception ex) {
            ManejoErrores.mostrarError("Error al buscar cliente", ex, this);
        }
    }
    
    private void abrirCarrito() {
        try {
            if (tableClientes.getSelectedRow() != -1) {
                long cedula = Long.parseLong(String.valueOf(
                    ((DefaultTableModel)tableClientes.getModel()).getValueAt(
                        tableClientes.getSelectedRow(), 1
                    )
                ));
                
                Cliente cliente = controladorCliente.buscarClientePorCedula(cedula);
                if (cliente != null) {
                    controladorVentas.abrirCarrito(cliente);
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Seleccione un cliente primero", 
                    "Aviso", 
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            ManejoErrores.mostrarError("Error al abrir carrito", ex, this);
        }
    }
    
    private void registrarCliente() {
        try {
            controladorCliente.crearCliente(this);
            controladorCliente.iniciarTablaClientes(this);
            controladorCliente.cargarClientesEnVista();
        } catch (Exception ex) {
            ManejoErrores.mostrarError("Error al registrar cliente", ex, this);
        }
    }
    
    private void modificarCliente() {
        try {
            if (tableClientes.getSelectedRow() != -1) {
                long cedula = Long.parseLong(String.valueOf(
                    ((DefaultTableModel)tableClientes.getModel()).getValueAt(
                        tableClientes.getSelectedRow(), 1
                    )
                ));
                
                String nuevoTelefono = JOptionPane.showInputDialog(
                    this, 
                    "Ingrese el teléfono del cliente", 
                    "Ingrese teléfono", 
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
                    if (!nuevoTelefono.matches("[0-9]*$")) {
                        JOptionPane.showMessageDialog(this, 
                            "Ingresó un formato de teléfono incorrecto\n   No ponga ni letras ni símbolos", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (nuevoTelefono.length() != 10) {
                        JOptionPane.showMessageDialog(this, 
                            "Su teléfono tiene más/menos números de los que debería", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    controladorCliente.modificarTelefonoCliente(this, nuevoTelefono, cedula);
                    tableClientes.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Seleccione el Cliente que quiere modificar", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ManejoErrores.mostrarError("Error al modificar cliente", ex, this);
        }
    }
    
    private void seleccionarSala() {
        try {
            if (comboSalasV.getSelectedIndex() <= 0) {
                return;
            }

            this.spinnerTicketsV.setValue(0);

            boolean isVip = comboSalasV.getSelectedItem().equals("VIP");

            // Verificar cliente
            String cedulaStr = textFieldClienteV.getText().trim();
            if (cedulaStr.isEmpty() || "Ingrese Cédula".equals(cedulaStr)) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, busque un cliente primero", 
                    "Cliente no seleccionado", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Obtener la sala seleccionada desde la tabla
            int filaSeleccionada = tableSalas.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, 
                    "Seleccione una sala primero", 
                    "Aviso", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Obtener datos de la sala seleccionada
            String idSala = (String) tableSalas.getValueAt(filaSeleccionada, 0);

            // Usar controladorSalas para buscar la sala
            Sala sala = controladorSalas.buscarSalaPorId(idSala);
            if (sala != null) {
                SelecAsientos ventanaAsientos = new SelecAsientos(sala, isVip);
                ventanaAsientos.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Error al obtener información de la sala", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ManejoErrores.mostrarError("Error al seleccionar sala", ex, this);
        }
    }
    
    // Métodos para actualizar la UI desde los controladores
    
    public void actualizarTablaSalas(ArrayList<Sala> salas) {
        DefaultTableModel model = (DefaultTableModel) tableSalas.getModel();
        model.setRowCount(0);

        for (Sala sala : salas) {
            String tituloPelicula;
            if (sala.getPelicula() != null) {
                tituloPelicula = sala.getPelicula().obtenerTitulo();
            } else {
                tituloPelicula = "Sin Asignar";
            }

            Object[] fila = new Object[]{
                sala.obtenerId(),
                sala.getNombre(),
                sala.getCapacidad(),
                sala.getMarcaVIP(), // Usamos el método que devuelve "X" o ""
                tituloPelicula
            };
            model.addRow(fila);
        }
    }
    
    public void actualizarComboPeliculas(ArrayList<Pelicula> peliculas) {
        comboPeliculasSa1.removeAllItems();
        comboPeliculasSa1.addItem("Seleccione una película"); // Ítem de encabezado

        for (Pelicula pelicula : peliculas) {
            comboPeliculasSa1.addItem(pelicula.obtenerTitulo()); // Solo el título
        }
    }
    
    public void actualizarTablaClientes(ArrayList<Cliente> clientes) {
        DefaultTableModel modelo = (DefaultTableModel) tableClientes.getModel();
        modelo.setRowCount(0); // Limpia la tabla
        
        for (Cliente cliente : clientes) {
            modelo.addRow(new Object[]{
                cliente.getNombre(),
                cliente.getCedula(),
                cliente.getTelefono()
            });
        }
    }
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        botonesFecha = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelSalas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSalas = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        comboPeliculasSa1 = new javax.swing.JComboBox<>();
        botonCambiarPeliculaSa1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panelVentas = new javax.swing.JPanel();
        label$1T2 = new javax.swing.JLabel();
        comboClientesV = new javax.swing.JComboBox<>();
        labelPrecioV = new javax.swing.JLabel();
        textFieldPrecioV = new javax.swing.JTextField();
        botonAgregarCarritoV = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        textFieldClienteV = new javax.swing.JTextField();
        labelNombreCliente = new javax.swing.JLabel();
        botonBuscarClienteV = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboSalasV = new javax.swing.JComboBox<>();
        labelMostrarPeli = new javax.swing.JLabel();
        labelPelicula = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        fecha3 = new javax.swing.JRadioButton();
        fecha4 = new javax.swing.JRadioButton();
        fecha5 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelCantidadTicketsV = new javax.swing.JLabel();
        spinnerTicketsV = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelPeliculas = new javax.swing.JPanel();
        botonAgregarPeliculaP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeli = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelClientes = new javax.swing.JPanel();
        botonCarritoC = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        botonRegistrarC1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(500, 400));

        jTabbedPane2.setBackground(new java.awt.Color(38, 75, 120));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(700, 900));

        panelSalas.setBackground(new java.awt.Color(3, 30, 68));
        panelSalas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSalas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableSalas.setBackground(new java.awt.Color(204, 204, 204));
        tableSalas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tableSalas.setForeground(new java.awt.Color(0, 0, 0));
        tableSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Capacidad", "VIP", "Película"
            }
        ));
        tableSalas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableSalas.setFocusable(false);
        jScrollPane2.setViewportView(tableSalas);
        if (tableSalas.getColumnModel().getColumnCount() > 0) {
            tableSalas.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        panelSalas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 290));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboPeliculasSa1.setBackground(new java.awt.Color(14, 66, 134));
        comboPeliculasSa1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboPeliculasSa1.setForeground(new java.awt.Color(255, 255, 255));
        comboPeliculasSa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Películas" }));

        botonCambiarPeliculaSa1.setBackground(new java.awt.Color(14, 66, 134));
        botonCambiarPeliculaSa1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonCambiarPeliculaSa1.setForeground(new java.awt.Color(255, 255, 255));
        botonCambiarPeliculaSa1.setText("Cambiar ");
        botonCambiarPeliculaSa1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCambiarPeliculaSa1.setFocusPainted(false);
        botonCambiarPeliculaSa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPeliculaSa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboPeliculasSa1, 0, 140, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(botonCambiarPeliculaSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPeliculasSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarPeliculaSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panelSalas.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 320, 50));

        jButton5.setBackground(new java.awt.Color(14, 66, 134));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Maximizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelSalas.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        jButton7.setBackground(new java.awt.Color(14, 66, 134));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelSalas.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jTabbedPane2.addTab("Salas", panelSalas);

        panelVentas.setBackground(new java.awt.Color(3, 30, 68));
        panelVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label$1T2.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        label$1T2.setForeground(new java.awt.Color(255, 255, 255));
        label$1T2.setText("$");
        panelVentas.add(label$1T2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        comboClientesV.setBackground(new java.awt.Color(153, 153, 153));
        comboClientesV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboClientesV.setForeground(new java.awt.Color(255, 255, 255));
        comboClientesV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes" }));
        comboClientesV.setFocusable(false);
        comboClientesV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesVActionPerformed(evt);
            }
        });
        panelVentas.add(comboClientesV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 137, 107, 26));

        labelPrecioV.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N
        labelPrecioV.setForeground(new java.awt.Color(255, 255, 255));
        labelPrecioV.setText("Precio Total");
        panelVentas.add(labelPrecioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        textFieldPrecioV.setEditable(false);
        textFieldPrecioV.setBackground(new java.awt.Color(102, 102, 102));
        textFieldPrecioV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        textFieldPrecioV.setForeground(new java.awt.Color(255, 255, 255));
        textFieldPrecioV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldPrecioV.setText("Precio");
        textFieldPrecioV.setBorder(null);
        textFieldPrecioV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPrecioVActionPerformed(evt);
            }
        });
        panelVentas.add(textFieldPrecioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 60, 26));

        botonAgregarCarritoV.setBackground(new java.awt.Color(153, 153, 153));
        botonAgregarCarritoV.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonAgregarCarritoV.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarCarritoV.setText("Agregar al carrito");
        botonAgregarCarritoV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregarCarritoV.setFocusPainted(false);
        botonAgregarCarritoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCarritoVActionPerformed(evt);
            }
        });
        panelVentas.add(botonAgregarCarritoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 140, 40));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 0, 11)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("  Para ver la película pulse la flecha.");
        jTextArea1.setAlignmentX(1.0F);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setFocusable(false);
        jTextArea1.setMargin(new java.awt.Insets(22, 2, 2, 2));
        panelVentas.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 210, 20));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        textFieldClienteV.setBackground(new java.awt.Color(102, 102, 102));
        textFieldClienteV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        textFieldClienteV.setForeground(new java.awt.Color(255, 255, 255));
        textFieldClienteV.setText("Ingrese Cédula");
        textFieldClienteV.setBorder(null);
        textFieldClienteV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldClienteVFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldClienteVFocusLost(evt);
            }
        });
        textFieldClienteV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldClienteVActionPerformed(evt);
            }
        });
        textFieldClienteV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldClienteVKeyTyped(evt);
            }
        });

        labelNombreCliente.setFont(new java.awt.Font("Calibri Light", 3, 13)); // NOI18N
        labelNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombreCliente.setText("Nombre Cliente");

        botonBuscarClienteV.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarClienteV.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonBuscarClienteV.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarClienteV.setText("Buscar");
        botonBuscarClienteV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonBuscarClienteV.setFocusPainted(false);
        botonBuscarClienteV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(botonBuscarClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(labelNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonBuscarClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelNombreCliente))
        );

        panelVentas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 90));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboSalasV.setBackground(new java.awt.Color(153, 153, 153));
        comboSalasV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboSalasV.setForeground(new java.awt.Color(255, 255, 255));
        comboSalasV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sala", "VIP", "Estandar" }));
        comboSalasV.setFocusable(false);
        comboSalasV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSalasVItemStateChanged(evt);
            }
        });
        comboSalasV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                comboSalasVMouseDragged(evt);
            }
        });
        comboSalasV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboSalasVFocusLost(evt);
            }
        });
        comboSalasV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboSalasVMouseClicked(evt);
            }
        });
        comboSalasV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSalasVActionPerformed(evt);
            }
        });

        labelMostrarPeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Next.png"))); // NOI18N
        labelMostrarPeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMostrarPeliMouseClicked(evt);
            }
        });

        labelPelicula.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        labelPelicula.setForeground(new java.awt.Color(255, 255, 255));
        labelPelicula.setText("-----------------------");
        labelPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Película", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(comboSalasV, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMostrarPeli)
                .addGap(18, 18, 18)
                .addComponent(labelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPelicula)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMostrarPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSalasV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        panelVentas.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 300, 60));

        jPanel16.setBackground(new java.awt.Color(102, 102, 102));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        fecha3.setBackground(new java.awt.Color(102, 102, 102));
        botonesFecha.add(fecha3);
        fecha3.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        fecha3.setForeground(new java.awt.Color(255, 255, 255));
        fecha3.setText("26/ 07 / 2025");
        fecha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha3ActionPerformed(evt);
            }
        });

        fecha4.setBackground(new java.awt.Color(102, 102, 102));
        botonesFecha.add(fecha4);
        fecha4.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        fecha4.setForeground(new java.awt.Color(255, 255, 255));
        fecha4.setText("27 / 07 / 2025");
        fecha4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha4ActionPerformed(evt);
            }
        });

        fecha5.setBackground(new java.awt.Color(102, 102, 102));
        botonesFecha.add(fecha5);
        fecha5.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        fecha5.setForeground(new java.awt.Color(255, 255, 255));
        fecha5.setText("28 / 07 / 2025");
        fecha5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha3)
                    .addComponent(fecha4)
                    .addComponent(fecha5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fecha3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fecha4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fecha5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelVentas.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, 90));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        panelVentas.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 180, 50));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        labelCantidadTicketsV.setFont(new java.awt.Font("Calibri Light", 2, 16)); // NOI18N
        labelCantidadTicketsV.setForeground(new java.awt.Color(255, 255, 255));
        labelCantidadTicketsV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCantidadTicketsV.setText("Cantidad");

        spinnerTicketsV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        spinnerTicketsV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        spinnerTicketsV.setEnabled(false);
        spinnerTicketsV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTicketsVStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(labelCantidadTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spinnerTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidadTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        panelVentas.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 170, 50));

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelVentas.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));

        jButton4.setText("Maximizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelVentas.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, -1));

        jTabbedPane2.addTab("Ventas", panelVentas);

        panelPeliculas.setBackground(new java.awt.Color(3, 30, 68));
        panelPeliculas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAgregarPeliculaP.setBackground(new java.awt.Color(14, 66, 134));
        botonAgregarPeliculaP.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonAgregarPeliculaP.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarPeliculaP.setText("Agregar Película");
        botonAgregarPeliculaP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregarPeliculaP.setFocusPainted(false);
        botonAgregarPeliculaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPeliculaPActionPerformed(evt);
            }
        });
        panelPeliculas.add(botonAgregarPeliculaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 130, 30));

        tablePeli = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablePeli.setBackground(new java.awt.Color(204, 204, 204));
        tablePeli.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        tablePeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Género", "Clasificación", ""
            }
        ));
        tablePeli.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablePeli.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablePeli.setFocusable(false);
        jScrollPane1.setViewportView(tablePeli);
        if (tablePeli.getColumnModel().getColumnCount() > 0) {
            tablePeli.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        panelPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 310));

        jButton1.setBackground(new java.awt.Color(14, 66, 134));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelPeliculas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        jButton2.setBackground(new java.awt.Color(14, 66, 134));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jButton2.setText("Maximizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelPeliculas.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        jTabbedPane2.addTab("Peliculas", panelPeliculas);

        panelClientes.setBackground(new java.awt.Color(3, 30, 68));
        panelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCarritoC.setBackground(new java.awt.Color(14, 66, 134));
        botonCarritoC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonCarritoC.setForeground(new java.awt.Color(255, 255, 255));
        botonCarritoC.setText("Carrito");
        botonCarritoC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCarritoC.setFocusPainted(false);
        botonCarritoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarritoCActionPerformed(evt);
            }
        });
        panelClientes.add(botonCarritoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 90, 30));

        botonModificar.setBackground(new java.awt.Color(14, 66, 134));
        botonModificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("Modificar");
        botonModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonModificar.setFocusPainted(false);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        panelClientes.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 90, 30));

        tableClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableClientes.setBackground(new java.awt.Color(204, 204, 204));
        tableClientes.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        tableClientes.setForeground(new java.awt.Color(0, 0, 0));
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cédula", "Teléfono"
            }
        ));
        tableClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableClientes.setFocusable(false);
        jScrollPane4.setViewportView(tableClientes);

        panelClientes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 400));

        botonRegistrarC1.setBackground(new java.awt.Color(14, 66, 134));
        botonRegistrarC1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonRegistrarC1.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrarC1.setText("Registrar");
        botonRegistrarC1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegistrarC1.setFocusPainted(false);
        botonRegistrarC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarC1ActionPerformed(evt);
            }
        });
        panelClientes.add(botonRegistrarC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 90, 30));

        jButton6.setBackground(new java.awt.Color(14, 66, 134));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Maximizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelClientes.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 90, -1));

        jButton8.setBackground(new java.awt.Color(14, 66, 134));
        jButton8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelClientes.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 90, -1));

        jTabbedPane2.addTab("Clientes", panelClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldClienteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldClienteVActionPerformed
    }//GEN-LAST:event_textFieldClienteVActionPerformed
    private void botonBuscarClienteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteVActionPerformed
        buscarCliente();
    }//GEN-LAST:event_botonBuscarClienteVActionPerformed

    private void textFieldClienteVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldClienteVFocusGained
        if(textFieldClienteV.getText().equals("") == true){
            textFieldClienteV.setText("Ingrese Cédula");
        }
    }//GEN-LAST:event_textFieldClienteVFocusGained

    private void textFieldClienteVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldClienteVFocusLost
        if(textFieldClienteV.getText().equals("") == true){
            textFieldClienteV.setText("Ingrese Cédula");
        }
    }//GEN-LAST:event_textFieldClienteVFocusLost

    private void botonAgregarCarritoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCarritoVActionPerformed
    try {
        // Verificar si hay un cliente seleccionado
        String cedulaStr = textFieldClienteV.getText().trim();
        if (cedulaStr.isEmpty() || "Ingrese Cédula".equals(cedulaStr)) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, busque un cliente primero", 
                "Cliente no seleccionado", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Buscar el cliente
        long cedula = Long.parseLong(cedulaStr);
        Cliente cliente = controladorCliente.buscarClientePorCedula(cedula);
        
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, 
                "No se encontró el cliente con la cédula ingresada", 
                "Cliente no encontrado", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verificar si hay sala seleccionada
        int filaSeleccionada = tableSalas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, 
                "Seleccione una sala primero", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Verificar cantidad de tickets
        int cantidadTickets = (int) spinnerTicketsV.getValue();
        if (cantidadTickets <= 0) {
            JOptionPane.showMessageDialog(this, 
                "Seleccione al menos un ticket", 
                "Cantidad inválida", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Llamar al controlador para agregar al carrito
        controladorVentas.agregarAlCarrito(this, cliente, cantidadTickets);
        
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, 
            "Error en el formato de la cédula", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        ManejoErrores.mostrarError("Error al agregar al carrito", ex, this);
    }
    }//GEN-LAST:event_botonAgregarCarritoVActionPerformed

    private void textFieldPrecioVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrecioVActionPerformed
    }//GEN-LAST:event_textFieldPrecioVActionPerformed

    private void comboSalasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSalasVActionPerformed
     this.spinnerTicketsV.setValue(0);
    
    boolean isVip = comboSalasV.getSelectedItem().equals("VIP"); // "VIP" o "Estándar"
    
    // Obtener la sala seleccionada desde la tabla
    int filaSeleccionada = tableSalas.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una sala primero.");
        return;
    }

    String idSala = (String) tableSalas.getValueAt(filaSeleccionada, 0);
    // Usar el controlador para acceder al repositorio
    Sala sala = controladorSalas.buscarSalaPorId(idSala);

    if (sala != null) {
        SelecAsientos ventanaAsientos = new SelecAsientos(sala, isVip); // Pasar isVip
        ventanaAsientos.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo encontrar la sala seleccionada.");
    }   
    }//GEN-LAST:event_comboSalasVActionPerformed

    private void comboSalasVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSalasVItemStateChanged
    }//GEN-LAST:event_comboSalasVItemStateChanged

    private void comboSalasVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSalasVFocusLost
    }//GEN-LAST:event_comboSalasVFocusLost

    private void comboSalasVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSalasVMouseClicked
    }//GEN-LAST:event_comboSalasVMouseClicked

    private void comboSalasVMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSalasVMouseDragged
    }//GEN-LAST:event_comboSalasVMouseDragged

    private void labelMostrarPeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMostrarPeliMouseClicked

    }//GEN-LAST:event_labelMostrarPeliMouseClicked

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if(tableClientes.getSelectedRow() != -1){
            long cedula = Long.parseLong(String.valueOf( ((DefaultTableModel)tableClientes.getModel()).getValueAt(tableClientes.getSelectedRow(), 1) ) );
            
            String nuevoTelefono = "";
            try {
                nuevoTelefono = JOptionPane.showInputDialog(this, "        Ingrese el teléfono del cliente", "Ingrese teléfono", JOptionPane.QUESTION_MESSAGE);
                if(!nuevoTelefono.matches("[0-9]*$")){
                    JOptionPane.showMessageDialog(this, "Ingresó un formato de teléfono incorrecto\n   No ponga ni letras ni símbolos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(nuevoTelefono.length() != 10){
                    JOptionPane.showMessageDialog(this, "Su teléfono tiene más/menos números de los que debería", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                return;
            }
            controladorCliente.modificarTelefonoCliente(this, nuevoTelefono, cedula);
            tableClientes.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el Cliente que quiere modificar", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonRegistrarC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarC1ActionPerformed
        controladorCliente.crearCliente(this);
        controladorCliente.iniciarTablaClientes(this);
        controladorCliente.cargarClientesEnVista();
    }//GEN-LAST:event_botonRegistrarC1ActionPerformed

    private void comboClientesVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesVActionPerformed
        if(String.valueOf(comboClientesV.getSelectedItem()).equals("Clientes")){
            labelNombreCliente.setText("Nombre Cliente");
            return;
        }
        
        long cedula = Long.parseLong(String.valueOf(comboClientesV.getSelectedItem()));
        
        Cliente cliente = controladorCliente.buscarClientePorCedula(cedula);
        
        if (cliente != null){
            labelNombreCliente.setText(cliente.getNombre());
        } else {
            labelNombreCliente.setText("Cliente no encontrado");
        }
    }//GEN-LAST:event_comboClientesVActionPerformed

    private void textFieldClienteVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldClienteVKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textFieldClienteVKeyTyped

    private void botonCarritoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarritoCActionPerformed
        abrirCarrito();
    }//GEN-LAST:event_botonCarritoCActionPerformed

    private void spinnerTicketsVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTicketsVStateChanged
        //controlador.calcularPrecioVentas(this);
    }//GEN-LAST:event_spinnerTicketsVStateChanged

    private void fecha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha3ActionPerformed

    private void fecha4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha4ActionPerformed

    private void fecha5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha5ActionPerformed

    private void botonAgregarPeliculaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPeliculaPActionPerformed
        controladorPeliculas.agregarNuevaPelicula();
    }//GEN-LAST:event_botonAgregarPeliculaPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    System.exit(0);    
    }//GEN-LAST:event_jButton8ActionPerformed

    private void botonCambiarPeliculaSa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPeliculaSa1ActionPerformed
        //controlador.botonCambiarPeliculasSalas(this);
        controladorSalas.asignarPeliculaASala();
    }//GEN-LAST:event_botonCambiarPeliculaSa1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCarritoV;
    private javax.swing.JButton botonAgregarPeliculaP;
    private javax.swing.JButton botonBuscarClienteV;
    private javax.swing.JButton botonCambiarPeliculaSa1;
    private javax.swing.JButton botonCarritoC;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonRegistrarC1;
    public javax.swing.ButtonGroup botonesFecha;
    public javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JComboBox<String> comboClientesV;
    public javax.swing.JComboBox<String> comboPeliculasSa1;
    public javax.swing.JComboBox<String> comboSalasV;
    public javax.swing.JRadioButton fecha3;
    public javax.swing.JRadioButton fecha4;
    public javax.swing.JRadioButton fecha5;
    public javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label$1T2;
    private javax.swing.JLabel labelCantidadTicketsV;
    public javax.swing.JLabel labelMostrarPeli;
    private javax.swing.JLabel labelNombreCliente;
    public javax.swing.JLabel labelPelicula;
    private javax.swing.JLabel labelPrecioV;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelPeliculas;
    private javax.swing.JPanel panelSalas;
    private javax.swing.JPanel panelVentas;
    public javax.swing.JSpinner spinnerTicketsV;
    public javax.swing.JTable tableClientes;
    public javax.swing.JTable tablePeli;
    public javax.swing.JTable tableSalas;
    public javax.swing.JTextField textFieldClienteV;
    public javax.swing.JTextField textFieldPrecioV;
    // End of variables declaration//GEN-END:variables


    public JButton getBotonAgregarCarritoV() {
        return botonAgregarCarritoV;
    }

    public void setBotonAgregarCarritoV(JButton botonAgregarCarritoV) {
        this.botonAgregarCarritoV = botonAgregarCarritoV;
    }

    public JButton getBotonAgregarPeliculaP() {
        return botonAgregarPeliculaP;
    }

    public void setBotonAgregarPeliculaP(JButton botonAgregarPeliculaP) {
        this.botonAgregarPeliculaP = botonAgregarPeliculaP;
    }

    public JButton getBotonBuscarClienteV() {
        return botonBuscarClienteV;
    }

    public void setBotonBuscarClienteV(JButton botonBuscarClienteV) {
        this.botonBuscarClienteV = botonBuscarClienteV;
    }

    public JButton getBotonCambiarPeliculaSa1() {
        return botonCambiarPeliculaSa1;
    }

    public void setBotonCambiarPeliculaSa1(JButton botonCambiarPeliculaSa1) {
        this.botonCambiarPeliculaSa1 = botonCambiarPeliculaSa1;
    }

    public JButton getBotonCarritoC() {
        return botonCarritoC;
    }

    public void setBotonCarritoC(JButton botonCarritoC) {
        this.botonCarritoC = botonCarritoC;
    }

    public JButton getBotonModificar() {
        return botonModificar;
    }

    public void setBotonModificar(JButton botonModificar) {
        this.botonModificar = botonModificar;
    }

    public JButton getBotonRegistrarC1() {
        return botonRegistrarC1;
    }

    public void setBotonRegistrarC1(JButton botonRegistrarC1) {
        this.botonRegistrarC1 = botonRegistrarC1;
    }

    public ButtonGroup getBotonesFecha() {
        return botonesFecha;
    }

    public void setBotonesFecha(ButtonGroup botonesFecha) {
        this.botonesFecha = botonesFecha;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public ButtonGroup getButtonGroup2() {
        return buttonGroup2;
    }

    public void setButtonGroup2(ButtonGroup buttonGroup2) {
        this.buttonGroup2 = buttonGroup2;
    }

    public JComboBox<String> getComboClientesV() {
        return comboClientesV;
    }

    public void setComboClientesV(JComboBox<String> comboClientesV) {
        this.comboClientesV = comboClientesV;
    }

    public JComboBox<String> getComboPeliculasSa1() {
        return comboPeliculasSa1;
    }

    public void setComboPeliculasSa1(JComboBox<String> comboPeliculasSa1) {
        this.comboPeliculasSa1 = comboPeliculasSa1;
    }

    public JComboBox<String> getComboSalasV() {
        return comboSalasV;
    }

    public void setComboSalasV(JComboBox<String> comboSalasV) {
        this.comboSalasV = comboSalasV;
    }

    public JRadioButton getFecha3() {
        return fecha3;
    }

    public void setFecha3(JRadioButton fecha3) {
        this.fecha3 = fecha3;
    }

    public JRadioButton getFecha4() {
        return fecha4;
    }

    public void setFecha4(JRadioButton fecha4) {
        this.fecha4 = fecha4;
    }

    public JRadioButton getFecha5() {
        return fecha5;
    }

    public void setFecha5(JRadioButton fecha5) {
        this.fecha5 = fecha5;
    }

    public ButtonGroup getGrupoBotones() {
        return grupoBotones;
    }

    public void setGrupoBotones(ButtonGroup grupoBotones) {
        this.grupoBotones = grupoBotones;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel12() {
        return jPanel12;
    }

    public void setjPanel12(JPanel jPanel12) {
        this.jPanel12 = jPanel12;
    }

    public JPanel getjPanel16() {
        return jPanel16;
    }

    public void setjPanel16(JPanel jPanel16) {
        this.jPanel16 = jPanel16;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JTabbedPane getjTabbedPane2() {
        return jTabbedPane2;
    }

    public void setjTabbedPane2(JTabbedPane jTabbedPane2) {
        this.jTabbedPane2 = jTabbedPane2;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JLabel getLabel$1T2() {
        return label$1T2;
    }

    public void setLabel$1T2(JLabel label$1T2) {
        this.label$1T2 = label$1T2;
    }

    public JLabel getLabelCantidadTicketsV() {
        return labelCantidadTicketsV;
    }

    public void setLabelCantidadTicketsV(JLabel labelCantidadTicketsV) {
        this.labelCantidadTicketsV = labelCantidadTicketsV;
    }

    public JLabel getLabelMostrarPeli() {
        return labelMostrarPeli;
    }

    public void setLabelMostrarPeli(JLabel labelMostrarPeli) {
        this.labelMostrarPeli = labelMostrarPeli;
    }

    public JLabel getLabelNombreCliente() {
        return labelNombreCliente;
    }

    public void setLabelNombreCliente(JLabel labelNombreCliente) {
        this.labelNombreCliente = labelNombreCliente;
    }

    public JLabel getLabelPelicula() {
        return labelPelicula;
    }

    public void setLabelPelicula(JLabel labelPelicula) {
        this.labelPelicula = labelPelicula;
    }

    public JLabel getLabelPrecioV() {
        return labelPrecioV;
    }

    public void setLabelPrecioV(JLabel labelPrecioV) {
        this.labelPrecioV = labelPrecioV;
    }

    public JPanel getPanelClientes() {
        return panelClientes;
    }

    public void setPanelClientes(JPanel panelClientes) {
        this.panelClientes = panelClientes;
    }

    public JPanel getPanelPeliculas() {
        return panelPeliculas;
    }

    public void setPanelPeliculas(JPanel panelPeliculas) {
        this.panelPeliculas = panelPeliculas;
    }

    public JPanel getPanelSalas() {
        return panelSalas;
    }

    public void setPanelSalas(JPanel panelSalas) {
        this.panelSalas = panelSalas;
    }

    public JPanel getPanelVentas() {
        return panelVentas;
    }

    public void setPanelVentas(JPanel panelVentas) {
        this.panelVentas = panelVentas;
    }

    public JSpinner getSpinnerTicketsV() {
        return spinnerTicketsV;
    }

    public void setSpinnerTicketsV(JSpinner spinnerTicketsV) {
        this.spinnerTicketsV = spinnerTicketsV;
    }

    public JTable getTableClientes() {
        return tableClientes;
    }

    public void setTableClientes(JTable tableClientes) {
        this.tableClientes = tableClientes;
    }

    public JTable getTablePeli() {
        return tablePeli;
    }

    public void setTablePeli(JTable tablePeli) {
        this.tablePeli = tablePeli;
    }

    public JTable getTableSalas() {
        return tableSalas;
    }

    public void setTableSalas(JTable tableSalas) {
        this.tableSalas = tableSalas;
    }

    public JTextField getTextFieldClienteV() {
        return textFieldClienteV;
    }

    public void setTextFieldClienteV(JTextField textFieldClienteV) {
        this.textFieldClienteV = textFieldClienteV;
    }

    public JTextField getTextFieldPrecioV() {
        return textFieldPrecioV;
    }

    public void setTextFieldPrecioV(JTextField textFieldPrecioV) {
        this.textFieldPrecioV = textFieldPrecioV;
    }

    public void setControllers(ClienteController controladorCliente, PeliculasController controladorPeliculas, SalasController controladorSalas, VentasController controladorVentas) {
        this.controladorCliente = controladorCliente;
        this.controladorPeliculas = controladorPeliculas;
        this.controladorSalas = controladorSalas;
        this.controladorVentas = controladorVentas;
    }

}
