package View;

import Controller.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import Model.*;

public class Principal extends javax.swing.JFrame {
    Controlador controlador;

    public Principal(Controlador controlador) {
        this.controlador = controlador;
        UIManager.put("TabbedPane.selected", new Color(57,62,70));
        initComponents();
        jTabbedPane2.setForeground(Color.WHITE);
        setIconImage(new ImageIcon(getClass().getResource("../images/icono.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);      
        this.setSize(600, 430);
        this.setBackground(new Color(0,0,0,0));
        jRadioButton4.setSelected(true);
        
        //----------Inicializamos las tablas----------
        this.controlador.iniciarTablaSucursales(this);
        this.controlador.iniciarTablaSalas(this);
        this.controlador.iniciarTablaAdministrar(this);
        this.controlador.iniciarTablaClientes(this);
        this.controlador.iniciarTablaPeliculas(this);
        this.controlador.iniciarTablaTickets(this);
        
        this.controlador.iniciarRadioButons(this);
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
        panelVentas = new javax.swing.JPanel();
        label$1T2 = new javax.swing.JLabel();
        botonBuscarClienteV = new javax.swing.JButton();
        comboClientesV = new javax.swing.JComboBox<>();
        comboSucursalesV = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        labelPrecioV = new javax.swing.JLabel();
        textFieldPrecioV = new javax.swing.JTextField();
        botonAgregarCarritoV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextArea1 = new javax.swing.JTextArea();
        labelPelicula = new javax.swing.JLabel();
        textFieldUbicacion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        textFieldClienteV = new javax.swing.JTextField();
        labelNombreCliente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboSalasV = new javax.swing.JComboBox<>();
        labelMostrarPeli = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        fecha3 = new javax.swing.JRadioButton();
        fecha4 = new javax.swing.JRadioButton();
        fecha5 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelCantidadTicketsV = new javax.swing.JLabel();
        spinnerTicketsV = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fondo1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelPeliculas = new javax.swing.JPanel();
        botonModificarPeliculaP = new javax.swing.JButton();
        botonAgregarPeliculaP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeli = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        comboGeneroP = new javax.swing.JComboBox<>();
        comboIdiomaP = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        comboModificarPelicula = new javax.swing.JComboBox<>();
        textFieldPeliculaP = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        botonBuscarPeliculaP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fondo2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        panelClientes = new javax.swing.JPanel();
        botonCarritoC = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        textFieldCedulaC = new javax.swing.JTextField();
        botonBuscarClienteC = new javax.swing.JButton();
        botonRegistrarC1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        fondo3 = new javax.swing.JLabel();
        panelSalas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSalas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        comboSucursalesSalas = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        comboPeliculasSa1 = new javax.swing.JComboBox<>();
        botonCambiarPeliculaSa1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        fondo4 = new javax.swing.JLabel();
        panelSucursales = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSucursales = new javax.swing.JTable();
        botonAgregarSucursalSu = new javax.swing.JButton();
        botonModificarSucursalSu = new javax.swing.JButton();
        botonCrearSalasSu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        radioBoton3D = new javax.swing.JRadioButton();
        radioBoton2D = new javax.swing.JRadioButton();
        radioBoton4DX = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        fondo5 = new javax.swing.JLabel();
        panelTickets = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableTickets = new javax.swing.JTable();
        label$2T = new javax.swing.JLabel();
        label$3T = new javax.swing.JLabel();
        botonCambiarPrecio2DT = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textFieldPrecio3DT = new javax.swing.JTextField();
        textFieldPrecio2DT = new javax.swing.JTextField();
        label$1T = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        botonCambiarPrecio3DT = new javax.swing.JButton();
        botonCambiarPrecio4DT = new javax.swing.JButton();
        textFieldPrecio4DT = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        fondo6 = new javax.swing.JLabel();
        panelAdministrar = new javax.swing.JPanel();
        labelSalasFrecuentesA = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableAdmin = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        textFieldIngresosA = new javax.swing.JTextField();
        labelIngresosA = new javax.swing.JLabel();
        label$1T1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fondo7 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(500, 400));

        jTabbedPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(700, 900));

        panelVentas.setBackground(new java.awt.Color(255, 255, 255));
        panelVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label$1T2.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        label$1T2.setForeground(new java.awt.Color(255, 255, 255));
        label$1T2.setText("$");
        panelVentas.add(label$1T2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

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
        panelVentas.add(botonBuscarClienteV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 80, 30));

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

        comboSucursalesV.setBackground(new java.awt.Color(153, 153, 153));
        comboSucursalesV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboSucursalesV.setForeground(new java.awt.Color(255, 255, 255));
        comboSucursalesV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal" }));
        comboSucursalesV.setBorder(null);
        comboSucursalesV.setFocusable(false);
        comboSucursalesV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSucursalesVItemStateChanged(evt);
            }
        });
        comboSucursalesV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSucursalesVActionPerformed(evt);
            }
        });
        panelVentas.add(comboSucursalesV, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 130, 26));
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
        jTextArea1.setBackground(new java.awt.Color(153, 153, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 0, 11)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("  Para ver la película pulse la flecha.");
        jTextArea1.setAlignmentX(1.0F);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setFocusable(false);
        jTextArea1.setMargin(new java.awt.Insets(22, 2, 2, 2));
        panelVentas.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 160, 20));

        labelPelicula.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        labelPelicula.setForeground(new java.awt.Color(255, 255, 255));
        labelPelicula.setText("-----------------------");
        labelPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Película", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        panelVentas.add(labelPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 130, -1));

        textFieldUbicacion.setEditable(false);
        textFieldUbicacion.setBackground(new java.awt.Color(102, 102, 102));
        textFieldUbicacion.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        textFieldUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        textFieldUbicacion.setText("-----------------------");
        textFieldUbicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ubicación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        textFieldUbicacion.setVerifyInputWhenFocusTarget(false);
        textFieldUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUbicacionActionPerformed(evt);
            }
        });
        panelVentas.add(textFieldUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 130, -1));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
            .addComponent(labelNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textFieldClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(labelNombreCliente))
        );

        panelVentas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 90));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboSalasV.setBackground(new java.awt.Color(153, 153, 153));
        comboSalasV.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboSalasV.setForeground(new java.awt.Color(255, 255, 255));
        comboSalasV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sala" }));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(comboSalasV, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMostrarPeli)
                .addGap(158, 158, 158))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSalasV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMostrarPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelVentas.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 300, 110));

        jPanel16.setBackground(new java.awt.Color(102, 102, 102));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        fecha3.setBackground(new java.awt.Color(102, 102, 102));
        botonesFecha.add(fecha3);
        fecha3.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        fecha3.setForeground(new java.awt.Color(255, 255, 255));
        fecha3.setText("03 / 04 / 2018");
        fecha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha3ActionPerformed(evt);
            }
        });

        fecha4.setBackground(new java.awt.Color(102, 102, 102));
        botonesFecha.add(fecha4);
        fecha4.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        fecha4.setForeground(new java.awt.Color(255, 255, 255));
        fecha4.setText("04 / 04 / 2018");
        fecha4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha4ActionPerformed(evt);
            }
        });

        fecha5.setBackground(new java.awt.Color(102, 102, 102));
        botonesFecha.add(fecha5);
        fecha5.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        fecha5.setForeground(new java.awt.Color(255, 255, 255));
        fecha5.setText("05 / 04 / 2018");
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panelVentas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        panelVentas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelVentas.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("jButton1");
        panelVentas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jTabbedPane2.addTab("Ventas", panelVentas);

        panelPeliculas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonModificarPeliculaP.setBackground(new java.awt.Color(153, 153, 153));
        botonModificarPeliculaP.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonModificarPeliculaP.setForeground(new java.awt.Color(255, 255, 255));
        botonModificarPeliculaP.setText("Modificar");
        botonModificarPeliculaP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonModificarPeliculaP.setFocusPainted(false);
        botonModificarPeliculaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarPeliculaPActionPerformed(evt);
            }
        });
        panelPeliculas.add(botonModificarPeliculaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 80, 30));

        botonAgregarPeliculaP.setBackground(new java.awt.Color(153, 153, 153));
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
        panelPeliculas.add(botonAgregarPeliculaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 130, 30));

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
                "Nombre", "Género", "Idioma"
            }
        ));
        tablePeli.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablePeli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablePeli.setFocusable(false);
        jScrollPane1.setViewportView(tablePeli);

        panelPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 70, 540, 122));

        jLabel4.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/peliculas.png"))); // NOI18N
        panelPeliculas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 7, -1, -1));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboGeneroP.setBackground(new java.awt.Color(153, 153, 153));
        comboGeneroP.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboGeneroP.setForeground(new java.awt.Color(255, 255, 255));
        comboGeneroP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Acción", "Aventura", "Suspenso", "Amor" }));
        comboGeneroP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGeneroPActionPerformed(evt);
            }
        });

        comboIdiomaP.setBackground(new java.awt.Color(153, 153, 153));
        comboIdiomaP.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboIdiomaP.setForeground(new java.awt.Color(255, 255, 255));
        comboIdiomaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Idioma", "Español", "Inglés", "Francés" }));
        comboIdiomaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdiomaPActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Filtros");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboGeneroP, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboIdiomaP, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboIdiomaP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboGeneroP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelPeliculas.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 60));

        comboModificarPelicula.setBackground(new java.awt.Color(153, 153, 153));
        comboModificarPelicula.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboModificarPelicula.setForeground(new java.awt.Color(255, 255, 255));
        comboModificarPelicula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modificar", "Género", "Idioma" }));
        panelPeliculas.add(comboModificarPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 100, 26));

        textFieldPeliculaP.setBackground(new java.awt.Color(102, 102, 102));
        textFieldPeliculaP.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        textFieldPeliculaP.setForeground(new java.awt.Color(255, 255, 255));
        textFieldPeliculaP.setText("Ingrese Película");
        textFieldPeliculaP.setBorder(null);
        textFieldPeliculaP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldPeliculaPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldPeliculaPFocusLost(evt);
            }
        });
        textFieldPeliculaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPeliculaPActionPerformed(evt);
            }
        });
        panelPeliculas.add(textFieldPeliculaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 110, 26));
        panelPeliculas.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 90, -1));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        botonBuscarPeliculaP.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarPeliculaP.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonBuscarPeliculaP.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarPeliculaP.setText("Buscar");
        botonBuscarPeliculaP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonBuscarPeliculaP.setFocusPainted(false);
        botonBuscarPeliculaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPeliculaPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(botonBuscarPeliculaP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonBuscarPeliculaP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPeliculas.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 230, 60));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        panelPeliculas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        panelPeliculas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelPeliculas.add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setText("jButton3");
        jButton3.setBorder(null);
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton3FocusGained(evt);
            }
        });
        panelPeliculas.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jTabbedPane2.addTab("Peliculas", panelPeliculas);

        panelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCarritoC.setBackground(new java.awt.Color(153, 153, 153));
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
        panelClientes.add(botonCarritoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 90, 30));

        botonModificar.setBackground(new java.awt.Color(153, 153, 153));
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
        panelClientes.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 90, 30));

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
        tableClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableClientes.setFocusable(false);
        jScrollPane4.setViewportView(tableClientes);

        panelClientes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 550, 160));

        jLabel5.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clientes.png"))); // NOI18N
        panelClientes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelClientes.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 311, 100, 10));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        textFieldCedulaC.setBackground(new java.awt.Color(102, 102, 102));
        textFieldCedulaC.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        textFieldCedulaC.setForeground(new java.awt.Color(255, 255, 255));
        textFieldCedulaC.setText("Ingrese Cédula");
        textFieldCedulaC.setBorder(null);
        textFieldCedulaC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldCedulaCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldCedulaCFocusLost(evt);
            }
        });
        textFieldCedulaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCedulaCActionPerformed(evt);
            }
        });
        textFieldCedulaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldCedulaCKeyTyped(evt);
            }
        });

        botonBuscarClienteC.setBackground(new java.awt.Color(153, 153, 153));
        botonBuscarClienteC.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonBuscarClienteC.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarClienteC.setText("Buscar");
        botonBuscarClienteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonBuscarClienteC.setFocusPainted(false);
        botonBuscarClienteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldCedulaC, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonBuscarClienteC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarClienteC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelClientes.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 220, 60));

        botonRegistrarC1.setBackground(new java.awt.Color(153, 153, 153));
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
        panelClientes.add(botonRegistrarC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 90, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        panelClientes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        panelClientes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelClientes.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelClientes.add(fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Clientes", panelClientes);

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
        tableSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSalas.setFocusable(false);
        jScrollPane2.setViewportView(tableSalas);

        panelSalas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 540, 180));

        jLabel6.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salas.png"))); // NOI18N
        panelSalas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        comboSucursalesSalas.setBackground(new java.awt.Color(153, 153, 153));
        comboSucursalesSalas.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboSucursalesSalas.setForeground(new java.awt.Color(255, 255, 255));
        comboSucursalesSalas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal" }));
        comboSucursalesSalas.setBorder(null);
        comboSucursalesSalas.setFocusable(false);
        comboSucursalesSalas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSucursalesSalasItemStateChanged(evt);
            }
        });
        comboSucursalesSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSucursalesSalasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSucursalesSalas, 0, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(comboSucursalesSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSalas.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 180, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        panelSalas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        panelSalas.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

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

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jRadioButton1.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("2D");
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("3D");
        jRadioButton2.setFocusPainted(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("4DX");
        jRadioButton3.setFocusPainted(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("All");
        jRadioButton4.setFocusPainted(false);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelSalas.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 180, 50));

        fondo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelSalas.add(fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Salas", panelSalas);

        panelSucursales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSucursales = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableSucursales.setBackground(new java.awt.Color(204, 204, 204));
        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ubicación"
            }
        ));
        tableSucursales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSucursales.setFocusable(false);
        jScrollPane3.setViewportView(tableSucursales);

        panelSucursales.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 80, 530, 200));

        botonAgregarSucursalSu.setBackground(new java.awt.Color(153, 153, 153));
        botonAgregarSucursalSu.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonAgregarSucursalSu.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarSucursalSu.setText("Agregar Sucursal");
        botonAgregarSucursalSu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAgregarSucursalSu.setFocusPainted(false);
        botonAgregarSucursalSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarSucursalSuActionPerformed(evt);
            }
        });
        panelSucursales.add(botonAgregarSucursalSu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 130, 30));

        botonModificarSucursalSu.setBackground(new java.awt.Color(153, 153, 153));
        botonModificarSucursalSu.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonModificarSucursalSu.setForeground(new java.awt.Color(255, 255, 255));
        botonModificarSucursalSu.setText("Modificar");
        botonModificarSucursalSu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonModificarSucursalSu.setFocusPainted(false);
        botonModificarSucursalSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarSucursalSuActionPerformed(evt);
            }
        });
        panelSucursales.add(botonModificarSucursalSu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 80, 30));

        botonCrearSalasSu.setBackground(new java.awt.Color(153, 153, 153));
        botonCrearSalasSu.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonCrearSalasSu.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearSalasSu.setText("Crear Sala");
        botonCrearSalasSu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCrearSalasSu.setFocusPainted(false);
        botonCrearSalasSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearSalasSuActionPerformed(evt);
            }
        });
        panelSucursales.add(botonCrearSalasSu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 100, 30));

        jLabel7.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sucursales.png"))); // NOI18N
        panelSucursales.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        panelSucursales.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        panelSucursales.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        radioBoton3D.setBackground(new java.awt.Color(102, 102, 102));
        grupoBotones.add(radioBoton3D);
        radioBoton3D.setForeground(new java.awt.Color(255, 255, 255));
        radioBoton3D.setText("3D");
        radioBoton3D.setFocusPainted(false);
        radioBoton3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBoton3DActionPerformed(evt);
            }
        });
        panelSucursales.add(radioBoton3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 334, -1, -1));

        radioBoton2D.setBackground(new java.awt.Color(102, 102, 102));
        grupoBotones.add(radioBoton2D);
        radioBoton2D.setForeground(new java.awt.Color(255, 255, 255));
        radioBoton2D.setText("2D");
        radioBoton2D.setFocusPainted(false);
        radioBoton2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBoton2DActionPerformed(evt);
            }
        });
        panelSucursales.add(radioBoton2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        radioBoton4DX.setBackground(new java.awt.Color(102, 102, 102));
        grupoBotones.add(radioBoton4DX);
        radioBoton4DX.setForeground(new java.awt.Color(255, 255, 255));
        radioBoton4DX.setText("4DX");
        radioBoton4DX.setFocusPainted(false);
        radioBoton4DX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBoton4DXActionPerformed(evt);
            }
        });
        panelSucursales.add(radioBoton4DX, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, -1));

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        panelSucursales.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 70, 90));

        fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelSucursales.add(fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Sucursales", panelSucursales);

        panelTickets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBackground(new java.awt.Color(153, 153, 153));

        tableTickets = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableTickets.setBackground(new java.awt.Color(204, 204, 204));
        tableTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Ticket", "Cédula cliente", "Sucursal", "Sala", "Película"
            }
        ));
        tableTickets.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableTickets.setFocusable(false);
        tableTickets.setRowSelectionAllowed(false);
        jScrollPane5.setViewportView(tableTickets);

        panelTickets.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 540, 220));

        label$2T.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        label$2T.setForeground(new java.awt.Color(255, 255, 255));
        label$2T.setText("$");
        panelTickets.add(label$2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 330, -1, -1));

        label$3T.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        label$3T.setForeground(new java.awt.Color(255, 255, 255));
        label$3T.setText("$");
        panelTickets.add(label$3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 330, -1, -1));

        botonCambiarPrecio2DT.setBackground(new java.awt.Color(153, 153, 153));
        botonCambiarPrecio2DT.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonCambiarPrecio2DT.setForeground(new java.awt.Color(255, 255, 255));
        botonCambiarPrecio2DT.setText("Cambiar");
        botonCambiarPrecio2DT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCambiarPrecio2DT.setFocusPainted(false);
        botonCambiarPrecio2DT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPrecio2DTActionPerformed(evt);
            }
        });
        panelTickets.add(botonCambiarPrecio2DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 327, 68, 30));

        jLabel8.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tickets.png"))); // NOI18N
        panelTickets.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        textFieldPrecio3DT.setBackground(new java.awt.Color(102, 102, 102));
        textFieldPrecio3DT.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        textFieldPrecio3DT.setForeground(new java.awt.Color(255, 255, 255));
        textFieldPrecio3DT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "3D", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panelTickets.add(textFieldPrecio3DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 50, 40));

        textFieldPrecio2DT.setBackground(new java.awt.Color(102, 102, 102));
        textFieldPrecio2DT.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        textFieldPrecio2DT.setForeground(new java.awt.Color(255, 255, 255));
        textFieldPrecio2DT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "2D", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panelTickets.add(textFieldPrecio2DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 50, 40));

        label$1T.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        label$1T.setForeground(new java.awt.Color(255, 255, 255));
        label$1T.setText("$");
        panelTickets.add(label$1T, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 330, -1, -1));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        panelTickets.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        panelTickets.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        botonCambiarPrecio3DT.setBackground(new java.awt.Color(153, 153, 153));
        botonCambiarPrecio3DT.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonCambiarPrecio3DT.setForeground(new java.awt.Color(255, 255, 255));
        botonCambiarPrecio3DT.setText("Cambiar");
        botonCambiarPrecio3DT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCambiarPrecio3DT.setFocusPainted(false);
        botonCambiarPrecio3DT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPrecio3DTActionPerformed(evt);
            }
        });

        botonCambiarPrecio4DT.setBackground(new java.awt.Color(153, 153, 153));
        botonCambiarPrecio4DT.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonCambiarPrecio4DT.setForeground(new java.awt.Color(255, 255, 255));
        botonCambiarPrecio4DT.setText("Cambiar");
        botonCambiarPrecio4DT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCambiarPrecio4DT.setFocusPainted(false);
        botonCambiarPrecio4DT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPrecio4DTActionPerformed(evt);
            }
        });

        textFieldPrecio4DT.setBackground(new java.awt.Color(102, 102, 102));
        textFieldPrecio4DT.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        textFieldPrecio4DT.setForeground(new java.awt.Color(255, 255, 255));
        textFieldPrecio4DT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "4DX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(botonCambiarPrecio3DT, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(textFieldPrecio4DT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(botonCambiarPrecio4DT, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCambiarPrecio3DT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPrecio4DT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarPrecio4DT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelTickets.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 550, 72));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        panelTickets.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        panelTickets.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setBorder(null);
        jButton4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton4FocusGained(evt);
            }
        });
        panelTickets.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        fondo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelTickets.add(fondo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Tickets", panelTickets);

        panelAdministrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSalasFrecuentesA.setFont(new java.awt.Font("Calibri Light", 2, 36)); // NOI18N
        labelSalasFrecuentesA.setForeground(new java.awt.Color(255, 255, 255));
        labelSalasFrecuentesA.setText("Salas más frecuentadas");
        panelAdministrar.add(labelSalasFrecuentesA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        tableAdmin = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableAdmin.setBackground(new java.awt.Color(204, 204, 204));
        tableAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal", "Sala", "Tickets"
            }
        ));
        tableAdmin.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableAdmin.setFocusable(false);
        jScrollPane6.setViewportView(tableAdmin);

        panelAdministrar.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 530, 110));

        jLabel9.setFont(new java.awt.Font("Meiryo UI", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrar.png"))); // NOI18N
        panelAdministrar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelAdministrar.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 337, 80, 10));

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        textFieldIngresosA.setEditable(false);
        textFieldIngresosA.setBackground(new java.awt.Color(102, 102, 102));
        textFieldIngresosA.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        textFieldIngresosA.setForeground(new java.awt.Color(255, 255, 255));
        textFieldIngresosA.setText("0.0");
        textFieldIngresosA.setBorder(null);

        labelIngresosA.setFont(new java.awt.Font("Calibri Light", 3, 24)); // NOI18N
        labelIngresosA.setForeground(new java.awt.Color(255, 255, 255));
        labelIngresosA.setText("Ingresos");

        label$1T1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        label$1T1.setForeground(new java.awt.Color(255, 255, 255));
        label$1T1.setText("$");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIngresosA)
                .addGap(48, 48, 48)
                .addComponent(textFieldIngresosA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label$1T1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldIngresosA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIngresosA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label$1T1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAdministrar.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 320, 70));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EquisBlanca.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        panelAdministrar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MinimizarBlanca.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        panelAdministrar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        fondo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.png"))); // NOI18N
        panelAdministrar.add(fondo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Administrar", panelAdministrar);

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
        controlador.buscarClienteVentas(this);
    }//GEN-LAST:event_botonBuscarClienteVActionPerformed
    private void textFieldPeliculaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPeliculaPActionPerformed
    }//GEN-LAST:event_textFieldPeliculaPActionPerformed
    private void botonAgregarPeliculaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPeliculaPActionPerformed
        controlador.botonAgregarPelicula(this);
    try {
        // 1. Pedir y validar el título
        String titulo = JOptionPane.showInputDialog(principal, 
            "Ingrese el nombre de la película\n(No más de 20 caracteres)");
            
        if (titulo == null || titulo.isEmpty() || titulo.length() > 20) {
            JOptionPane.showMessageDialog(principal, 
                "El título debe tener entre 1 y 20 caracteres", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Pedir y validar el género
        String[] generos = {"Acción", "Amor", "Suspenso", "Aventura"};
        String genero = (String) JOptionPane.showInputDialog(
            principal,
            "Elija el género de la Película",
            "Selección Género",
            JOptionPane.QUESTION_MESSAGE,
            null,
            generos,
            generos[0]
        );
        
        if (genero == null) {
            return;
        }

        // 3. Pedir duración
        String duracionStr = JOptionPane.showInputDialog(principal,
            "Ingrese la duración en minutos");
            
        if (duracionStr == null) {
            return;
        }
        
        int duracion = Integer.parseInt(duracionStr);
        if (duracion <= 0) {
            JOptionPane.showMessageDialog(principal,
                "La duración debe ser mayor a 0 minutos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Pedir restricción de edad
        RestriccionesEdad[] edades = RestriccionesEdad.values();
        RestriccionesEdad restriccion = (RestriccionesEdad) JOptionPane.showInputDialog(
            principal,
            "Seleccione la restricción de edad",
            "Clasificación", 
            JOptionPane.QUESTION_MESSAGE,
            null,
            edades,
            edades[0]
        );

        if (restriccion == null) {
            return;
        }

        // 5. Generar ID único 
        String id = String.format("P%03d", peliculas.size() + 1);

        // 6. Crear y agregar la película usando el constructor correcto
        Pelicula pelicula = new Pelicula(id, titulo, genero, duracion, restriccion);
        peliculas.add(pelicula);
        crearPelicula(pelicula, principal);

        JOptionPane.showMessageDialog(principal,
            "Película agregada exitosamente",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(principal,
            "La duración debe ser un número válido",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(principal,
            "Error al agregar la película: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_botonAgregarPeliculaPActionPerformed
    private void textFieldCedulaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCedulaCActionPerformed
    }//GEN-LAST:event_textFieldCedulaCActionPerformed
    private void botonCambiarPrecio4DTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPrecio4DTActionPerformed
        //Ticket4DX.setPrecio(Double.parseDouble(textFieldPrecio4DT.getText()));
        //JOptionPane.showMessageDialog(this, "Cambio de precio exitoso", "Cambio de precio", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonCambiarPrecio4DTActionPerformed
    private void botonCambiarPrecio3DTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPrecio3DTActionPerformed
        //Ticket3D.setPrecio(Double.parseDouble(textFieldPrecio3DT.getText()));
        //JOptionPane.showMessageDialog(this, "Cambio de precio exitoso", "Cambio de precio", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonCambiarPrecio3DTActionPerformed
    private void botonCambiarPrecio2DTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPrecio2DTActionPerformed
        //Ticket2D.setPrecio(Double.parseDouble(textFieldPrecio2DT.getText()));
        //JOptionPane.showMessageDialog(this, "Cambio de precio exitoso", "Cambio de precio", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonCambiarPrecio2DTActionPerformed

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

    private void botonBuscarPeliculaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPeliculaPActionPerformed
        controlador.buscarPelicula(this);
    }//GEN-LAST:event_botonBuscarPeliculaPActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel3MouseClicked
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel11MouseClicked
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel13MouseClicked
    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel17MouseClicked
    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel19MouseClicked
    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel21MouseClicked
    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        controlador.cerrar(this);
    }//GEN-LAST:event_jLabel15MouseClicked
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel10MouseClicked
    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel12MouseClicked
    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel14MouseClicked
    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel18MouseClicked
    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel20MouseClicked
    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel22MouseClicked
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        controlador.minimizar(this);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void textFieldPeliculaPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPeliculaPFocusGained
        if(textFieldPeliculaP.getText().equals("Ingrese Película") == true){
            textFieldPeliculaP.setText("");
        }
    }//GEN-LAST:event_textFieldPeliculaPFocusGained

    private void textFieldPeliculaPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPeliculaPFocusLost
        if(textFieldPeliculaP.getText().equals("") == true){
            textFieldPeliculaP.setText("Ingrese Película");
        }
    }//GEN-LAST:event_textFieldPeliculaPFocusLost

    private void textFieldCedulaCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldCedulaCFocusGained
        if(textFieldCedulaC.getText().equals("Ingrese Cédula") == true){
            textFieldCedulaC.setText("");
        }
    }//GEN-LAST:event_textFieldCedulaCFocusGained

    private void textFieldCedulaCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldCedulaCFocusLost
        if(textFieldCedulaC.getText().equals("") == true){
            textFieldCedulaC.setText("Ingrese Cédula");
        }
    }//GEN-LAST:event_textFieldCedulaCFocusLost

    private void botonAgregarCarritoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCarritoVActionPerformed
        //controlador.agregarAlCarrito(this);

    }//GEN-LAST:event_botonAgregarCarritoVActionPerformed

    private void textFieldPrecioVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrecioVActionPerformed
    }//GEN-LAST:event_textFieldPrecioVActionPerformed

    private void botonAgregarSucursalSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarSucursalSuActionPerformed
        /*String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion de la sucursal");
        // Se creal el objeto sucursal
        if(ubicacion == null){
        }else if(ubicacion.length() < 4){
            JOptionPane.showMessageDialog(this, "No ingresó una ubicación válida\n   Debe ser mayor a 4 letras", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Sucursal sucursal = new Sucursal(ubicacion);
            controlador.crearSucursal(sucursal, this);
        }
    }//GEN-LAST:event_botonAgregarSucursalSuActionPerformed
*/
    private void comboSucursalesVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSucursalesVActionPerformed
    // Coloca la ubicacion de una sucursal al lado del codigo dentro del combobox en Ventas
        /*if(String.valueOf(comboSucursalesV.getSelectedItem()).equals("Sucursal")){
            textFieldUbicacion.setText("-----------------------");
        }else{
            textFieldUbicacion.setText(sucursales.buscarSucursal(sucursales.getRoot(),Integer.valueOf(String.valueOf(comboSucursalesV.getSelectedItem()))).getUbicacion());
        }
        
        controlador.mostrarPeliculasEnComboPeliculas(this);*/
    }//GEN-LAST:event_comboSucursalesVActionPerformed

    private void comboSucursalesVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSucursalesVItemStateChanged
    }//GEN-LAST:event_comboSucursalesVItemStateChanged

    private void textFieldUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUbicacionActionPerformed
    }//GEN-LAST:event_textFieldUbicacionActionPerformed

    private void botonCrearSalasSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearSalasSuActionPerformed
        controlador.crearSala(this);
        
        // Volvemos a mostrar las Salas para no tener que actualizar desde la GUI
        ((DefaultTableModel)tableSalas.getModel()).setRowCount(0);
        
        if(comboSucursalesSalas.getSelectedItem() != "Sucursal"){
            int numSucursal = Integer.parseInt(String.valueOf(comboSucursalesSalas.getSelectedItem()));
            controlador.mostrarSalasEnTablaSalas(this, numSucursal, false);
        }
        comboSucursalesV.setSelectedItem("Sucursal");
    }//GEN-LAST:event_botonCrearSalasSuActionPerformed

    private void comboSucursalesSalasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSucursalesSalasItemStateChanged
        
    }//GEN-LAST:event_comboSucursalesSalasItemStateChanged

    private void comboSucursalesSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSucursalesSalasActionPerformed
        // Se vacian las salas ya vistas
        ((DefaultTableModel)tableSalas.getModel()).setRowCount(0);
        
        if(comboSucursalesSalas.getSelectedItem() != "Sucursal"){
            int numSucursal = Integer.parseInt(String.valueOf(comboSucursalesSalas.getSelectedItem()));
            controlador.mostrarSalasEnTablaSalas(this, numSucursal, false);
        }
        
        if(comboSucursalesSalas.getSelectedItem() == "Sucursal"){
            this.jRadioButton1.setEnabled(false);
            this.jRadioButton2.setEnabled(false);
            this.jRadioButton3.setEnabled(false);
            this.jRadioButton4.setEnabled(false);
            this.jRadioButton1.setSelected(false);
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(true);
        }else{
            this.jRadioButton1.setEnabled(true);
            this.jRadioButton2.setEnabled(true);
            this.jRadioButton3.setEnabled(true);
            this.jRadioButton4.setEnabled(true);
            this.jRadioButton1.setSelected(false);
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(true);
        }
        
    }//GEN-LAST:event_comboSucursalesSalasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    }//GEN-LAST:event_jButton2ActionPerformed

    private void radioBoton3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBoton3DActionPerformed
    }//GEN-LAST:event_radioBoton3DActionPerformed

    private void radioBoton4DXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBoton4DXActionPerformed
    }//GEN-LAST:event_radioBoton4DXActionPerformed

    private void radioBoton2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBoton2DActionPerformed
    }//GEN-LAST:event_radioBoton2DActionPerformed

    private void botonModificarSucursalSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarSucursalSuActionPerformed
        // Buscamos que sucursal está seleccionada
        if(tableSucursales.getSelectedRow() != -1){
            int numSucursal = Integer.parseInt(String.valueOf( ((DefaultTableModel)tableSucursales.getModel()).getValueAt(tableSucursales.getSelectedRow(), 0) ) );
            if(numSucursal != -1){
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese la nueva ubicación de la Sucursal");
                controlador.modificarUbicacionSucursal(this, nuevoNombre, numSucursal);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione la Sucursal que quiere modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarSucursalSuActionPerformed

    private void botonCambiarPeliculaSa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPeliculaSa1ActionPerformed
        controlador.botonCambiarPeliculasSalas(this);
    }//GEN-LAST:event_botonCambiarPeliculaSa1ActionPerformed

    private void botonModificarPeliculaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarPeliculaPActionPerformed
        controlador.modificarPelicula(this);
    }//GEN-LAST:event_botonModificarPeliculaPActionPerformed

    private void comboSalasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSalasVActionPerformed
        this.spinnerTicketsV.setValue(0);
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
        this.spinnerTicketsV.setValue(0);
        if( !String.valueOf(comboSucursalesV.getSelectedItem()).equals("Sucursal") && !String.valueOf(comboSalasV.getSelectedItem()).equals("Sala") ){
            spinnerTicketsV.setEnabled(true);
        }else{
            spinnerTicketsV.setEnabled(false);
        }
        controlador.cambiarSalaVentas(this);
    }//GEN-LAST:event_labelMostrarPeliMouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        controlador.mostrarSoloSalas2D(this);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        controlador.mostrarSoloSalas3D(this);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        controlador.mostrarSoloSalas4DX(this);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)tableSalas.getModel();
        modelo.setRowCount(0);
        controlador.mostrarSalasEnTablaSalas(this, Integer.parseInt(String.valueOf(comboSucursalesSalas.getSelectedItem())), false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
                controlador.modificarTelefonoCliente(this, nuevoTelefono, cedula);
                tableClientes.clearSelection();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el Cliente que quiere modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonRegistrarC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarC1ActionPerformed
        controlador.crearCliente(this);
    }//GEN-LAST:event_botonRegistrarC1ActionPerformed

    private void comboClientesVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesVActionPerformed
        if(String.valueOf(comboClientesV.getSelectedItem()).equals("Clientes")){
            labelNombreCliente.setText("Nombre Cliente");
            return;
        }
        
        long cedula = Long.parseLong(String.valueOf(comboClientesV.getSelectedItem()));
        labelNombreCliente.setText(controlador.clientes.buscarCliente(controlador.clientes.getRoot(), cedula).getNombre());
    }//GEN-LAST:event_comboClientesVActionPerformed

    private void botonBuscarClienteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteCActionPerformed
        controlador.buscarCliente(this);
    }//GEN-LAST:event_botonBuscarClienteCActionPerformed

    private void textFieldClienteVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldClienteVKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textFieldClienteVKeyTyped

    private void textFieldCedulaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCedulaCKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textFieldCedulaCKeyTyped

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        controlador.mostrarPeliculasEnTablaPeliculas(this);
    }//GEN-LAST:event_jButton3FocusGained

    private void comboIdiomaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdiomaPActionPerformed
        controlador.mostrarPeliculasEnTablaPeliculas(this);
    }//GEN-LAST:event_comboIdiomaPActionPerformed

    private void comboGeneroPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneroPActionPerformed
        controlador.mostrarPeliculasEnTablaPeliculas(this);
    }//GEN-LAST:event_comboGeneroPActionPerformed

    private void botonCarritoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarritoCActionPerformed
        controlador.abrirCarrito(this);
    }//GEN-LAST:event_botonCarritoCActionPerformed

    private void spinnerTicketsVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTicketsVStateChanged
        controlador.calcularPrecioVentas(this);
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

    private void jButton4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusGained
        controlador.organizarTickets(this);
    }//GEN-LAST:event_jButton4FocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCarritoV;
    private javax.swing.JButton botonAgregarPeliculaP;
    private javax.swing.JButton botonAgregarSucursalSu;
    private javax.swing.JButton botonBuscarClienteC;
    private javax.swing.JButton botonBuscarClienteV;
    private javax.swing.JButton botonBuscarPeliculaP;
    private javax.swing.JButton botonCambiarPeliculaSa1;
    private javax.swing.JButton botonCambiarPrecio2DT;
    private javax.swing.JButton botonCambiarPrecio3DT;
    private javax.swing.JButton botonCambiarPrecio4DT;
    private javax.swing.JButton botonCarritoC;
    private javax.swing.JButton botonCrearSalasSu;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonModificarPeliculaP;
    private javax.swing.JButton botonModificarSucursalSu;
    private javax.swing.JButton botonRegistrarC1;
    public javax.swing.ButtonGroup botonesFecha;
    public javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JComboBox<String> comboClientesV;
    public javax.swing.JComboBox<String> comboGeneroP;
    public static javax.swing.JComboBox<String> comboIdiomaP;
    public javax.swing.JComboBox<String> comboModificarPelicula;
    public javax.swing.JComboBox<String> comboPeliculasSa1;
    public javax.swing.JComboBox<String> comboSalasV;
    public javax.swing.JComboBox<String> comboSucursalesSalas;
    public javax.swing.JComboBox<String> comboSucursalesV;
    public javax.swing.JRadioButton fecha3;
    public javax.swing.JRadioButton fecha4;
    public javax.swing.JRadioButton fecha5;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel fondo2;
    private javax.swing.JLabel fondo3;
    private javax.swing.JLabel fondo4;
    private javax.swing.JLabel fondo5;
    private javax.swing.JLabel fondo6;
    private javax.swing.JLabel fondo7;
    public javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JRadioButton jRadioButton2;
    public javax.swing.JRadioButton jRadioButton3;
    public javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label$1T;
    private javax.swing.JLabel label$1T1;
    private javax.swing.JLabel label$1T2;
    private javax.swing.JLabel label$2T;
    private javax.swing.JLabel label$3T;
    private javax.swing.JLabel labelCantidadTicketsV;
    private javax.swing.JLabel labelIngresosA;
    public javax.swing.JLabel labelMostrarPeli;
    private javax.swing.JLabel labelNombreCliente;
    public javax.swing.JLabel labelPelicula;
    private javax.swing.JLabel labelPrecioV;
    private javax.swing.JLabel labelSalasFrecuentesA;
    private javax.swing.JPanel panelAdministrar;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelPeliculas;
    private javax.swing.JPanel panelSalas;
    private javax.swing.JPanel panelSucursales;
    private javax.swing.JPanel panelTickets;
    private javax.swing.JPanel panelVentas;
    public javax.swing.JRadioButton radioBoton2D;
    public javax.swing.JRadioButton radioBoton3D;
    public javax.swing.JRadioButton radioBoton4DX;
    public javax.swing.JSpinner spinnerTicketsV;
    public javax.swing.JTable tableAdmin;
    public javax.swing.JTable tableClientes;
    public javax.swing.JTable tablePeli;
    public javax.swing.JTable tableSalas;
    public javax.swing.JTable tableSucursales;
    public javax.swing.JTable tableTickets;
    public javax.swing.JTextField textFieldCedulaC;
    public javax.swing.JTextField textFieldClienteV;
    private javax.swing.JTextField textFieldIngresosA;
    public javax.swing.JTextField textFieldPeliculaP;
    public javax.swing.JTextField textFieldPrecio2DT;
    public javax.swing.JTextField textFieldPrecio3DT;
    public javax.swing.JTextField textFieldPrecio4DT;
    public javax.swing.JTextField textFieldPrecioV;
    private javax.swing.JTextField textFieldUbicacion;
    // End of variables declaration//GEN-END:variables
}
