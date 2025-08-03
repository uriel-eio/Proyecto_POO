package View;

import Controller.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import Model.*;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class Principal extends javax.swing.JFrame {

    private PeliculasController controladorPeliculas;
    private VentasController controladorVentas;
    private ClienteController controladorCliente;
    private SalasController controladorSalas;
    private RepositorioSalas salasRepositorio;
    private AppController controladorApp;

    
    public Principal() {
        initComponents();
        configurarTablaPeliculas();
        // Aquí va toda la configuración puramente visual
        UIManager.put("TabbedPane.selected", new Color(57, 62, 70));
        jTabbedPane2.setForeground(Color.WHITE);
        setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(600, 430);
        this.setBackground(new Color(0, 0, 0, 0));
    }

    public void setControllers(AppController app, ClienteController clientes, PeliculasController peliculas, SalasController salas, VentasController ventas) {
      this.controladorApp = app;
      this.controladorCliente = clientes;
      this.controladorPeliculas = peliculas;
      this.controladorSalas = salas;
      this.controladorVentas = ventas;
    }
    
    private void configurarTablaPeliculas() {
        tablePeli.getColumnModel().getColumn(3).setCellRenderer(new RenderizadorImagenes());
        tablePeli.setRowHeight(300); 
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
        panelPeliculas = new javax.swing.JPanel();
        botonAgregarPeliculaP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeli = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        panelClientes = new javax.swing.JPanel();
        botonCarritoC = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        botonRegistrarC1 = new javax.swing.JButton();
        panelSalas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSalas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        comboPeliculasSa1 = new javax.swing.JComboBox<>();
        botonCambiarPeliculaSa1 = new javax.swing.JButton();
        panelVentas = new javax.swing.JPanel();
        label$1T2 = new javax.swing.JLabel();
        comboClientesV = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        labelPrecioV = new javax.swing.JLabel();
        textFieldPrecioV = new javax.swing.JTextField();
        botonAgregarCarritoV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(500, 400));

        jTabbedPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(700, 900));

        panelPeliculas.setBackground(new java.awt.Color(153, 153, 153));
        panelPeliculas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAgregarPeliculaP.setBackground(new java.awt.Color(102, 102, 102));
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
        panelPeliculas.add(botonAgregarPeliculaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 130, 30));

        tablePeli = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablePeli.setBackground(new java.awt.Color(204, 204, 204));
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

        panelPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 70, 540, 250));

        jLabel4.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/peliculas.png"))); // NOI18N
        panelPeliculas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 7, -1, -1));

        jTabbedPane2.addTab("Peliculas", panelPeliculas);

        panelClientes.setBackground(new java.awt.Color(153, 153, 153));
        panelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCarritoC.setBackground(new java.awt.Color(102, 102, 102));
        botonCarritoC.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonCarritoC.setForeground(new java.awt.Color(255, 255, 255));
        botonCarritoC.setText("Carrito");
        botonCarritoC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCarritoC.setFocusPainted(false);
        botonCarritoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarritoCActionPerformed(evt);
            }
        });
        panelClientes.add(botonCarritoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 90, 30));

        botonModificar.setBackground(new java.awt.Color(102, 102, 102));
        botonModificar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("Modificar");
        botonModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonModificar.setFocusPainted(false);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        panelClientes.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 90, 30));

        tableClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableClientes.setBackground(new java.awt.Color(204, 204, 204));
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

        panelClientes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 550, 210));

        jLabel5.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clientes.png"))); // NOI18N
        panelClientes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        botonRegistrarC1.setBackground(new java.awt.Color(102, 102, 102));
        botonRegistrarC1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonRegistrarC1.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrarC1.setText("Registrar");
        botonRegistrarC1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegistrarC1.setFocusPainted(false);
        botonRegistrarC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarC1ActionPerformed(evt);
            }
        });
        panelClientes.add(botonRegistrarC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 90, 30));

        jTabbedPane2.addTab("Clientes", panelClientes);

        panelSalas.setBackground(new java.awt.Color(153, 153, 153));
        panelSalas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSalas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableSalas.setBackground(new java.awt.Color(204, 204, 204));
        tableSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Tipo", "Película"
            }
        ));
        tableSalas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableSalas.setFocusable(false);
        jScrollPane2.setViewportView(tableSalas);

        panelSalas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 540, 180));

        jLabel6.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salas.png"))); // NOI18N
        panelSalas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboPeliculasSa1.setBackground(new java.awt.Color(153, 153, 153));
        comboPeliculasSa1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboPeliculasSa1.setForeground(new java.awt.Color(255, 255, 255));
        comboPeliculasSa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Películas" }));

        botonCambiarPeliculaSa1.setBackground(new java.awt.Color(153, 153, 153));
        botonCambiarPeliculaSa1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonCambiarPeliculaSa1.setForeground(new java.awt.Color(255, 255, 255));
        botonCambiarPeliculaSa1.setText("Cambiar Película");
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
                .addGap(20, 20, 20)
                .addComponent(comboPeliculasSa1, 0, 136, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonCambiarPeliculaSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCambiarPeliculaSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPeliculasSa1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelSalas.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 320, 60));

        jTabbedPane2.addTab("Salas", panelSalas);

        panelVentas.setBackground(new java.awt.Color(153, 153, 153));
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
        panelVentas.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 375, 60, 10));

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

        jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ventas.png"))); // NOI18N
        panelVentas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 50));
        panelVentas.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

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
        panelVentas.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 107, 10));

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

        jTabbedPane2.addTab("Ventas", panelVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldClienteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldClienteVActionPerformed
    }//GEN-LAST:event_textFieldClienteVActionPerformed
    private void botonBuscarClienteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteVActionPerformed
        controladorCliente.buscarClienteVentas(this);
    }//GEN-LAST:event_botonBuscarClienteVActionPerformed

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

    private void botonAgregarCarritoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCarritoVActionPerformed
        //controlador.agregarAlCarrito(this);

    }//GEN-LAST:event_botonAgregarCarritoVActionPerformed

    private void textFieldPrecioVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrecioVActionPerformed
    }//GEN-LAST:event_textFieldPrecioVActionPerformed

    private void botonCambiarPeliculaSa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPeliculaSa1ActionPerformed
        //controlador.botonCambiarPeliculasSalas(this);
        controladorSalas.asignarPeliculaASala();
    }//GEN-LAST:event_botonCambiarPeliculaSa1ActionPerformed

    private void comboSalasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSalasVActionPerformed
        this.spinnerTicketsV.setValue(0);
        
        boolean isVip = comboSalasV.getSelectedItem().equals("VIP"); // "VIP" o "Estándar"
        this.spinnerTicketsV.setValue(0); // Resetear spinner

        // Obtener la sala seleccionada (ej: desde una tabla)
        int filaSeleccionada = tableSalas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una sala primero.");
            return;
        }

        String nombreSala = (String) tableSalas.getValueAt(filaSeleccionada, 0);
        Sala sala = salasRepositorio.buscarSalaPorNombre(nombreSala);

        if (sala != null) {
            SelecAsientos ventanaAsientos = new SelecAsientos(sala, isVip); // Pasar isVip
            ventanaAsientos.setVisible(true);
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
        // Buscamos que CLiente está seleccionado
        if(tableClientes.getSelectedRow() != -1){
            long cedula = Long.parseLong(String.valueOf( ((DefaultTableModel)tableClientes.getModel()).getValueAt(tableClientes.getSelectedRow(), 1) ) );
            
            String nuevoTelefono = "";
            try {
            nuevoTelefono = JOptionPane.showInputDialog(this, "        Ingrese el teléfono del cliente", "Ingrese teléfono", JOptionPane.QUESTION_MESSAGE);
            if(!nuevoTelefono.matches("[0-9]*$")){
                JOptionPane.showMessageDialog(this, "Ingresó un formato de teléfono incorrecto\n   No ponga ni letras ni símbolos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(nuevoTelefono.length() != 11){
                JOptionPane.showMessageDialog(this, "Su teléfono tiene más/menos números de los que debería", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            } catch (Exception e) {
                return;
            }
                controladorCliente.modificarTelefonoCliente(this, nuevoTelefono, cedula);
                tableClientes.clearSelection();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el Cliente que quiere modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonRegistrarC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarC1ActionPerformed
        controladorCliente.crearCliente(this);
    }//GEN-LAST:event_botonRegistrarC1ActionPerformed

    private void comboClientesVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesVActionPerformed
        
        if(String.valueOf(comboClientesV.getSelectedItem()).equals("Clientes")){
            labelNombreCliente.setText("Nombre Cliente");
            return;
        }long cedula = Long.parseLong(String.valueOf(comboClientesV.getSelectedItem()));
        
        Cliente cliente = controladorCliente.buscarClientePorCedula(cedula);
        
        if (cliente != null){
            labelNombreCliente.setText(cliente.getNombre());
        }else{
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
        //CORREGIRcontroladorVentas.abrirCarrito();
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

    public void actualizarTablaSalas(ArrayList<Sala> salas) {
        DefaultTableModel model = (DefaultTableModel) tableSalas.getModel();
        model.setRowCount(0); // Limpia la tabla
        
        //Busca la sala
        for (Sala sala : salas) {
            String tituloPelicula = (sala.getPelicula() != null) 
                        ? sala.getPelicula().obtenerTitulo() 
                        : "Sin asignar";
            
            //obtiene los datos de la sala
            Object[] fila = new Object[]{
                sala.getNombre(),
                sala.getCapacidad(),
                tituloPelicula
            };
            
            //Agrega al modelo 
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
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

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JSeparator jSeparator3) {
        this.jSeparator3 = jSeparator3;
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
