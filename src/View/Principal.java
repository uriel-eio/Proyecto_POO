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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Principal extends javax.swing.JFrame {

    private PeliculasController controladorPeliculas;
    private VentasController controladorVentas;
    private ClienteController controladorCliente;
    private SalasController controladorSalas;
    private AppController controladorApp;
    //private JLabel labelMostrarPeli;
    
    public Principal() {
        initComponents();
        
        // Configuración visual básica
        UIManager.put("TabbedPane.selected", new Color(57, 62, 70));
        jTabbedPane2.setForeground(Color.BLACK);
        try {
            setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
        } catch (Exception e) {
            System.err.println("No se pudo cargar el icono: " + e.getMessage());
        }
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(850, 440);
        // Se elimina la línea problemática que causaba el error
        
        configurarTablaPeliculas();
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
    
    private void configurarTablaPeliculas() {
        try {
            tablePeli.getColumnModel().getColumn(3).setCellRenderer(new RenderizadorImagenes());
            tablePeli.setRowHeight(300);
        } catch (Exception e) {
            System.err.println("Error al configurar tabla de películas: " + e.getMessage());
        }
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
    
   /* private void abrirCarrito() {
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
    }*/
    
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
    
    private void registrarCliente() {
        try {
            controladorCliente.crearCliente(this);
            controladorCliente.iniciarTablaClientes(this);
            controladorCliente.cargarClientesEnVista();
            controladorCliente.cargarClientesEnComboBox(this.getComboClientesV());

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
    // si esto funciona soy dios
    
    private void seleccionarSala() {
       /* try {
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
        }*/
    }
    
    private void configurarEventos() {
        // Eventos de la pestaña películas
       /* botonAgregarPeliculaP.addActionListener(e -> {
            try {
                controladorPeliculas.agregarNuevaPelicula();
            } catch (Exception ex) {
                ManejoErrores.mostrarError("Error al agregar película", ex, this);
            }
        });*/
            tableSalas.getSelectionModel().addListSelectionListener(e -> {
        // La condición !e.getValueIsAdjusting() asegura que el codigo se ejecute
        // solo una vez por clic (cuando se suelta el mouse), y no dos veces.
            if (!e.getValueIsAdjusting()) {
                controladorSalas.salaSeleccionada();
                }
        });
        // Eventos de la pestaña clientes
        botonBuscarClienteV.addActionListener(e -> buscarCliente());
//        botonCarritoC.addActionListener(e -> abrirCarrito());
        botonRegistrarC1.addActionListener(e -> registrarCliente());
        botonModificar.addActionListener(e -> modificarCliente());
        
        // Eventos de la pestaña salas
        /*botonCambiarPeliculaSa1.addActionListener(e -> {
            try {
                controladorSalas.asignarPeliculaASala();
            } catch (Exception ex) {
                ManejoErrores.mostrarError("Error al asignar película a sala", ex, this);
            }
        });*/
        
        // Eventos de la pestaña ventas
        comboSalasV.addActionListener(e -> seleccionarSala());
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
    public void mostrarPrecioFinalVenta(double precio) {
        String precioFormateado = String.format("%.2f", precio);
        labelPrecioFinal.setText("$" + precioFormateado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textFieldClienteV = new javax.swing.JTextField();
        labelNombreCliente = new javax.swing.JLabel();
        botonBuscarClienteV = new javax.swing.JButton();
        labelTotalPagar = new javax.swing.JLabel();
        labelPrecioFinal = new javax.swing.JLabel();
        botonAgregarCarritoV1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboSalasV = new javax.swing.JComboBox<>();
        labelPelicula = new javax.swing.JLabel();
        comboClientesV = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        labelCantidadTicketsV = new javax.swing.JLabel();
        spinnerTicketsV = new javax.swing.JSpinner();
        botonAgregarCarritoV = new javax.swing.JButton();
        botonAsignarAsientos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSalas = new javax.swing.JTable();
        comboPeliculasSa1 = new javax.swing.JComboBox<>();
        botonCambiarPeliculaSa1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePeli = new javax.swing.JTable();
        botonAgregarPeliculaP = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        botonModificar = new javax.swing.JButton();
        botonRegistrarC1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        textFieldClienteV.setBackground(new java.awt.Color(102, 102, 102));
        textFieldClienteV.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
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

        labelNombreCliente.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombreCliente.setText("Nombre Cliente");

        botonBuscarClienteV.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarClienteV.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonBuscarClienteV.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarClienteV.setText("Buscar");
        botonBuscarClienteV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonBuscarClienteV.setFocusPainted(false);
        botonBuscarClienteV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteVActionPerformed(evt);
            }
        });

        labelTotalPagar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotalPagar.setText("Total a pagar:");

        labelPrecioFinal.setFont(new java.awt.Font("Calibri Light", 3, 13)); // NOI18N
        labelPrecioFinal.setForeground(new java.awt.Color(255, 255, 255));
        labelPrecioFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        botonAgregarCarritoV1.setBackground(new java.awt.Color(153, 153, 153));
        botonAgregarCarritoV1.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        botonAgregarCarritoV1.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarCarritoV1.setText("Marcar como pagado");
        botonAgregarCarritoV1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregarCarritoV1.setFocusPainted(false);
        botonAgregarCarritoV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCarritoV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(labelPrecioFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonBuscarClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(labelNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(botonAgregarCarritoV1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscarClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(botonAgregarCarritoV1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboSalasV.setBackground(new java.awt.Color(153, 153, 153));
        comboSalasV.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
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

        labelPelicula.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        labelPelicula.setForeground(new java.awt.Color(255, 255, 255));
        labelPelicula.setText("-----------------------");
        labelPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Película", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        comboClientesV.setBackground(new java.awt.Color(153, 153, 153));
        comboClientesV.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboClientesV.setForeground(new java.awt.Color(255, 255, 255));
        comboClientesV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes" }));
        comboClientesV.setFocusable(false);
        comboClientesV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboSalasV, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboClientesV, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(labelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPelicula)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSalasV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboClientesV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        labelCantidadTicketsV.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelCantidadTicketsV.setForeground(new java.awt.Color(255, 255, 255));
        labelCantidadTicketsV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCantidadTicketsV.setText("Cantidad");

        spinnerTicketsV.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        spinnerTicketsV.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        spinnerTicketsV.setEnabled(true);
        spinnerTicketsV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTicketsVStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(labelCantidadTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spinnerTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidadTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerTicketsV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        botonAgregarCarritoV.setBackground(new java.awt.Color(51, 51, 51));
        botonAgregarCarritoV.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        botonAgregarCarritoV.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarCarritoV.setText("Mostrar Ventas");
        botonAgregarCarritoV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregarCarritoV.setFocusPainted(false);
        botonAgregarCarritoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCarritoVActionPerformed(evt);
            }
        });

        botonAsignarAsientos.setBackground(new java.awt.Color(51, 51, 51));
        botonAsignarAsientos.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        botonAsignarAsientos.setForeground(new java.awt.Color(255, 255, 255));
        botonAsignarAsientos.setText("Buscar Asientos");
        botonAsignarAsientos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAsignarAsientos.setFocusPainted(false);
        botonAsignarAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarAsientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAsignarAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAgregarCarritoV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAsignarAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregarCarritoV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Ventas", jPanel6);

        tableSalas.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        tableSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Capacidad", "VIP", "Pelicula"
            }
        ));
        jScrollPane1.setViewportView(tableSalas);

        comboPeliculasSa1.setBackground(new java.awt.Color(102, 102, 102));
        comboPeliculasSa1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        comboPeliculasSa1.setForeground(new java.awt.Color(255, 255, 255));
        comboPeliculasSa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Películas" }));

        botonCambiarPeliculaSa1.setBackground(new java.awt.Color(102, 102, 102));
        botonCambiarPeliculaSa1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonCambiarPeliculaSa1.setForeground(new java.awt.Color(255, 255, 255));
        botonCambiarPeliculaSa1.setText("Cambiar ");
        botonCambiarPeliculaSa1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCambiarPeliculaSa1.setFocusPainted(false);
        botonCambiarPeliculaSa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPeliculaSa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(comboPeliculasSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCambiarPeliculaSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPeliculasSa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarPeliculaSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Salas", jPanel4);

        tablePeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Genero", "Restriccion", "Imagen"
            }
        ));
        jScrollPane2.setViewportView(tablePeli);
        if (tablePeli.getColumnModel().getColumnCount() > 0) {
            tablePeli.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        botonAgregarPeliculaP.setBackground(new java.awt.Color(102, 102, 102));
        botonAgregarPeliculaP.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonAgregarPeliculaP.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarPeliculaP.setText("Agregar Película");
        botonAgregarPeliculaP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregarPeliculaP.setFocusPainted(false);
        botonAgregarPeliculaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPeliculaPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAgregarPeliculaP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonAgregarPeliculaP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Peliculas", jPanel7);

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Cedula", "Telefono"
            }
        ));
        jScrollPane3.setViewportView(tableClientes);

        botonModificar.setBackground(new java.awt.Color(102, 102, 102));
        botonModificar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("Modificar");
        botonModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonModificar.setFocusPainted(false);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonRegistrarC1.setBackground(new java.awt.Color(102, 102, 102));
        botonRegistrarC1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonRegistrarC1.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrarC1.setText("Registrar");
        botonRegistrarC1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegistrarC1.setFocusPainted(false);
        botonRegistrarC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarC1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(botonRegistrarC1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarC1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Clientes", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCambiarPeliculaSa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPeliculaSa1ActionPerformed
        //controlador.botonCambiarPeliculasSalas(this);
        controladorSalas.asignarPeliculaASala();
    }//GEN-LAST:event_botonCambiarPeliculaSa1ActionPerformed

    private void botonAgregarPeliculaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPeliculaPActionPerformed
        controladorPeliculas.agregarNuevaPelicula();
    }//GEN-LAST:event_botonAgregarPeliculaPActionPerformed

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

    private void textFieldClienteVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldClienteVFocusGained
        if(textFieldClienteV.getText().equals("Ingrese Cédula") == true){
            textFieldClienteV.setText("");
        }
    }//GEN-LAST:event_textFieldClienteVFocusGained

    private void textFieldClienteVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldClienteVFocusLost
        if(textFieldClienteV.getText().equals("") == true){
            textFieldClienteV.setText("Ingrese Cédula");
        }
    }//GEN-LAST:event_textFieldClienteVFocusLost

    private void textFieldClienteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldClienteVActionPerformed

    }//GEN-LAST:event_textFieldClienteVActionPerformed

    private void textFieldClienteVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldClienteVKeyTyped
        char validar = evt.getKeyChar();

        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textFieldClienteVKeyTyped

    private void botonBuscarClienteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteVActionPerformed
        controladorCliente.buscarClienteVentas(this);
    }//GEN-LAST:event_botonBuscarClienteVActionPerformed

    private void spinnerTicketsVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTicketsVStateChanged
        //controlador.calcularPrecioVentas(this);
    }//GEN-LAST:event_spinnerTicketsVStateChanged

    private void botonAgregarCarritoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCarritoVActionPerformed

    }//GEN-LAST:event_botonAgregarCarritoVActionPerformed

    private void botonAsignarAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarAsientosActionPerformed

    }//GEN-LAST:event_botonAsignarAsientosActionPerformed

    private void comboClientesVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesVActionPerformed
        String seleccion = (String) comboClientesV.getSelectedItem();

          if (seleccion == null || seleccion.equals("Seleccione un cliente")) {
              textFieldClienteV.setText("Ingrese Cédula");
              labelNombreCliente.setText("Nombre Cliente");
              return;
          }

          // Dividimos el string para obtener la cédula
          String[] partes = seleccion.split(" - ");
          if (partes.length < 2) {
              return;
          }

          String cedulaStr = partes[partes.length - 1].trim();

          Cliente cliente = controladorCliente.buscarClientePorCedula(Long.parseLong(cedulaStr));

          // Si encontramos al cliente, actualizamos los campos de la vista
          if (cliente != null) {
              textFieldClienteV.setText(String.valueOf(cliente.getCedula()));
              labelNombreCliente.setText(cliente.getNombre());
          } else {
              labelNombreCliente.setText("Cliente no encontrado");
          }
    }//GEN-LAST:event_comboClientesVActionPerformed

    private void comboSalasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSalasVActionPerformed
       /* this.spinnerTicketsV.setValue(0);

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
        }*/
    }//GEN-LAST:event_comboSalasVActionPerformed

    private void comboSalasVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSalasVMouseClicked

    }//GEN-LAST:event_comboSalasVMouseClicked

    private void comboSalasVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSalasVFocusLost

    }//GEN-LAST:event_comboSalasVFocusLost

    private void comboSalasVMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSalasVMouseDragged

    }//GEN-LAST:event_comboSalasVMouseDragged

    private void comboSalasVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSalasVItemStateChanged

    }//GEN-LAST:event_comboSalasVItemStateChanged

    private void botonAgregarCarritoV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCarritoV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarCarritoV1ActionPerformed

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

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
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

    public JTabbedPane getjTabbedPane2() {
        return jTabbedPane2;
    }

    public void setjTabbedPane2(JTabbedPane jTabbedPane2) {
        this.jTabbedPane2 = jTabbedPane2;
    }

    public JLabel getLabelCantidadTicketsV() {
        return labelCantidadTicketsV;
    }

    public void setLabelCantidadTicketsV(JLabel labelCantidadTicketsV) {
        this.labelCantidadTicketsV = labelCantidadTicketsV;
    }
    public void mostrarPeliculaEnLabel(String nombrePelicula) {
        if (nombrePelicula == null || nombrePelicula.isEmpty() || nombrePelicula.equals("Sin Asignar")) {
            labelPelicula.setText("-----------------------"); // Texto por defecto
        } else {
            labelPelicula.setText(nombrePelicula);
        }
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCarritoV;
    public javax.swing.JButton botonAgregarCarritoV1;
    private javax.swing.JButton botonAgregarPeliculaP;
    public javax.swing.JButton botonAsignarAsientos;
    private javax.swing.JButton botonBuscarClienteV;
    private javax.swing.JButton botonCambiarPeliculaSa1;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonRegistrarC1;
    public javax.swing.JComboBox<String> comboClientesV;
    public javax.swing.JComboBox<String> comboPeliculasSa1;
    public javax.swing.JComboBox<String> comboSalasV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelCantidadTicketsV;
    private javax.swing.JLabel labelNombreCliente;
    public javax.swing.JLabel labelPelicula;
    private javax.swing.JLabel labelPrecioFinal;
    private javax.swing.JLabel labelTotalPagar;
    public javax.swing.JSpinner spinnerTicketsV;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTable tablePeli;
    private javax.swing.JTable tableSalas;
    public javax.swing.JTextField textFieldClienteV;
    // End of variables declaration//GEN-END:variables
}
