package View;
import Controller.*;
import Model.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Carrito extends javax.swing.JFrame {
    private Principal principal;
    private VentasController controladorVentas;

    public Carrito(VentasController controladorVentas, Principal principal) {
        this.controladorVentas = controladorVentas;
        this.principal = principal;
    }
    
    //son cosas que aniado para que funcione el VentasController
    public void mostrarDatosCliente(Cliente cliente) {
        lblNombre.setText(cliente.getNombre());
        lblCedula.setText(String.valueOf(cliente.getCedula()));
    }
    
    /*tienen que agregar los metodos para abrir y cerrar en todas las ventanas
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        controlador.cerrarSesion();
        this.dispose();
        principal.setVisible(true);
    }*/
    
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

    public void setControladorVentas(VentasController controladorVentas) {
        this.controladorVentas = controladorVentas;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCarrito = new javax.swing.JTable();
        botonRegresar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        botonPagar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableCarrito = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableCarrito.setBackground(new java.awt.Color(204, 204, 204));
        tableCarrito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tableCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden N°", "Cantidad", "Sala", "Tipo", "Película", "Fecha", "Precio", "¿Pagada?"
            }
        ));
        tableCarrito.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableCarrito.setFocusable(false);
        jScrollPane1.setViewportView(tableCarrito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 610, 190));

        botonRegresar.setBackground(new java.awt.Color(153, 153, 153));
        botonRegresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegresar.setFocusPainted(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 90, 30));

        labelNombre.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Carrito");
        jPanel1.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 220, -1));

        botonPagar.setBackground(new java.awt.Color(153, 153, 153));
        botonPagar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonPagar.setForeground(new java.awt.Color(255, 255, 255));
        botonPagar.setText("Pagar Orden");
        botonPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonPagar.setFocusPainted(false);
        botonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarActionPerformed(evt);
            }
        });
        jPanel1.add(botonPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 110, 30));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 240, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
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

            // Le pasamos únicamente el ID al controladorVentas
            controladorVentas.pagarOrden(numOrden);
        } else {
            // Mensaje de error si no hay nada seleccionado
            JOptionPane.showMessageDialog(this, "Seleccione la orden de compra que quiere pagar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botonPagarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPagar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelNombre;
    public javax.swing.JTable tableCarrito;
    // End of variables declaration//GEN-END:variables
}
