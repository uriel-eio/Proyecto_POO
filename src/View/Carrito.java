package View;
import Controller.*;
import Model.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
//import model.Cliente;
//import model.OrdenCompra;
import java.util.*;
public class Carrito extends javax.swing.JFrame {
    private Principal principal;
    private Controlador controlador;
    

    public Carrito() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../images/icono.png")).getImage());
        this.setSize(720, 350);
        this.setLocationRelativeTo(null);
    }
    
    public void actualizarTabla(ArrayList<OrdenCompra> ordenes) {
        DefaultTableModel model = (DefaultTableModel) tableCarrito.getModel();
        model.setRowCount(0); // Limpia la tabla

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for (OrdenCompra orden : ordenes) {
            Object[] fila = new Object[]{
                //@TODO: explicar mas sobre como funciona esta parte con comentarios
                orden.getNumOrden(),
                orden.getCantidadAsientos(),
                orden.getFuncion().getSala().getNombre(),
                orden.getFuncion().getPelicula().obtenerTitulo(),
                orden.getFuncion().getFechaHora().format(formatter),
                orden.getPrecioTotal(),
                orden.isPagada() ? "Sí" : "No"
            };
            model.addRow(fila);
        }
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCarrito = new javax.swing.JTable();
        botonRegresar = new javax.swing.JButton();
        labelCedula = new javax.swing.JLabel();
        labelNombre1 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        botonPagar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrito.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tableCarrito = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableCarrito.setBackground(new java.awt.Color(204, 204, 204));
        tableCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden N°", "Cantidad", "Sucursal", "Sala", "Tipo", "Película", "Fecha", "Precio", "¿Pagada?"
            }
        ));
        tableCarrito.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableCarrito.setFocusable(false);
        jScrollPane1.setViewportView(tableCarrito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 700, 140));

        botonRegresar.setBackground(new java.awt.Color(153, 153, 153));
        botonRegresar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegresar.setFocusPainted(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 90, 30));

        labelCedula.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        labelCedula.setText("cedula");
        jPanel1.add(labelCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 36, 130, 30));

        labelNombre1.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        labelNombre1.setText("Cédula:");
        jPanel1.add(labelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 60, -1));

        labelNombre.setFont(new java.awt.Font("Calibri Light", 3, 30)); // NOI18N
        labelNombre.setText("Cliente");
        jPanel1.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 220, -1));

        botonPagar.setBackground(new java.awt.Color(153, 153, 153));
        botonPagar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        botonPagar.setForeground(new java.awt.Color(255, 255, 255));
        botonPagar.setText("Pagar Orden");
        botonPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonPagar.setFocusPainted(false);
        botonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarActionPerformed(evt);
            }
        });
        jPanel1.add(botonPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 110, 30));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 240, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Equis.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Minimizar.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoCarrito.png"))); // NOI18N
        fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagarActionPerformed
        if (tableCarrito.getSelectedRow() != -1) {
            // Obtenemos solo el ID de la orden desde la tabla
            int numOrden = (int) tableCarrito.getModel().getValueAt(tableCarrito.getSelectedRow(), 0);

            // Le pasamos únicamente el ID al controlador
            controlador.pagarOrden(numOrden);
        } else {
            // Mensaje de error si no hay nada seleccionado
            JOptionPane.showMessageDialog(this, "Seleccione la orden de compra que quiere pagar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonPagarActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        controlador.cerrarCarrito(this);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        controlador.minimizarCarrito(this);
    }//GEN-LAST:event_jLabel12MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPagar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelCedula;
    public javax.swing.JLabel labelNombre;
    public javax.swing.JLabel labelNombre1;
    public javax.swing.JTable tableCarrito;
    // End of variables declaration//GEN-END:variables
}
