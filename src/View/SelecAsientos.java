package View;

import Model.Asiento;
import Model.Sala;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;

public class SelecAsientos extends javax.swing.JFrame {
    
    private static final Logger LOGGER = Logger.getLogger(SelecAsientos.class.getName());
    
    // Atributos principales
    private final Sala sala;
    private final boolean isVip;
    private ArrayList<Asiento> asientosSeleccionados = new ArrayList<>();
    
    /**
     * Constructor básico para la vista de selección de asientos
     * @param sala La sala donde se seleccionarán asientos
     * @param isVip Indica si se trata de una sala VIP
     */
    public SelecAsientos(Sala sala, boolean isVip) {
        this.sala = sala;
        this.isVip = isVip;
        
        // Inicializar componentes visuales
        initComponents();
        
        // Configuración adicional
        configurarVentana();
        
        try {
            // Inicializar asientos manualmente
            inicializarAsientos();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al inicializar asientos", e);
            JOptionPane.showMessageDialog(this, 
                "Error al inicializar asientos: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Configura aspectos visuales y comportamiento de la ventana
     */
    private void configurarVentana() {
        // Centrar ventana en pantalla
        setLocationRelativeTo(null);
        
        // Configurar título y encabezado
        setTitle("Selección de Asientos - " + sala.getNombre());
        
        // Mostrar información de la película si está disponible
        if (sala.getPelicula() != null) {
            jLabel1.setText("Selecciona los Asientos: " + sala.getPelicula().obtenerTitulo());
        }
        
        // Configurar colores y aspecto visual
        jPanel1.setBackground(new Color(70, 70, 70));
        jPanel2.setBackground(new Color(50, 50, 50));
        
        // Configurar el panel de asientos
        jPanel2.setLayout(new GridLayout(0, 8, 5, 5)); // 8 asientos por fila con espacio entre ellos
    }
    
    /**
     * Inicializa los asientos en el panel
     */
    private void inicializarAsientos() {
        // Limpiar panel
        jPanel2.removeAll();
        
        // Usar GridLayout para organizar los asientos
        int columnas = 8;
        jPanel2.setLayout(new GridLayout(0, columnas, 5, 5));
        
        // Lista para guardar asientos seleccionados
        asientosSeleccionados = new ArrayList<>();
        
        // Crear botones para cada asiento
        for (Asiento asiento : sala.getAsientos()) {
            JButton boton = crearBotonAsiento(asiento);
            jPanel2.add(boton);
        }
        
        // Actualizar la vista
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    /**
     * Obtiene el panel donde se mostrarán los asientos
     * @return El panel de asientos
     */
    public javax.swing.JPanel getPanelAsientos() {
        return jPanel2;
    }
    
    /**
     * Crea un botón para un asiento con el estilo adecuado
     * @param asiento El asiento a representar
     * @return El botón configurado
     */
    public JButton crearBotonAsiento(Asiento asiento) {
        JButton boton = new JButton(asiento.obtenerNumero());
        
        // Configurar aspecto visual
        boton.setPreferredSize(new Dimension(60, 40));
        boton.setBackground(asiento.isVIP() ? new Color(200, 170, 0) : new Color(100, 100, 200));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        
        // Si el asiento ya está reservado, deshabilitarlo
        if (asiento.obtenerEstado()) {
            boton.setEnabled(false);
            boton.setBackground(Color.GRAY);
        }
        
        // Agregar acción de selección
        boton.addActionListener(e -> manejarSeleccionAsiento(boton, asiento));
        
        return boton;
    }
    
    /**
     * Maneja la selección y deselección de asientos
     * @param boton El botón presionado
     * @param asiento El asiento asociado al botón
     */
    private void manejarSeleccionAsiento(JButton boton, Asiento asiento) {
        if (boton.getBackground().equals(Color.GREEN)) {
            // Deseleccionar asiento
            boton.setBackground(asiento.isVIP() ? new Color(200, 170, 0) : new Color(100, 100, 200));
            asientosSeleccionados.remove(asiento);
        } else {
            // Seleccionar asiento
            boton.setBackground(Color.GREEN);
            asientosSeleccionados.add(asiento);
        }
    }
    
    /**
     * Obtiene la lista de asientos seleccionados
     * @return Lista de asientos seleccionados
     */
    public ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }
    
    /**
     * Confirma los asientos seleccionados
     */
    private void confirmarAsientos() {
        // Verificar si hay asientos seleccionados
        if (asientosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No ha seleccionado ningún asiento", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Confirmar selección
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de confirmar la selección de " + 
            asientosSeleccionados.size() + " asientos?",
            "Confirmar selección",
            JOptionPane.YES_NO_OPTION);
            
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        
        // Reservar los asientos seleccionados
        for (Asiento asiento : asientosSeleccionados) {
            asiento.reservar();
        }
        
        // Guardar asientos en archivo
        guardarAsientosEnArchivo();
        
        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, 
            "Se han seleccionado " + asientosSeleccionados.size() + 
            " asientos correctamente.",
            "Selección confirmada", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Cerrar ventana
        this.dispose();
    }
    
    /**
     * Guarda la selección de asientos en un archivo CSV
     */
    private void guardarAsientosEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("confirmarAsientos.csv"))) {
            // Escribir encabezado
            bw.write("Numero,Estado,VIP\n");
            
            // Escribir asientos reservados
            for (Asiento asiento : sala.getAsientos()) {
                if (asiento.obtenerEstado()) { // asiento reservado
                    bw.write(asiento.obtenerNumero() + ",Reservado," + asiento.isVIP() + "\n");
                }
            }
            
            // Asegurar que se escriban todos los datos
            bw.flush();
            
            LOGGER.log(Level.INFO, "Asientos guardados en archivo correctamente");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al guardar los asientos", e);
            JOptionPane.showMessageDialog(this, 
                "Error al guardar los asientos seleccionados: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Utopia", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecciona los Asientos:");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        btnVolver.setBackground(new java.awt.Color(102, 102, 102));
        btnVolver.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(102, 102, 102));
        btnConfirmar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar Asientos");
        btnConfirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jButton1.setText("PANTALLA");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //método del botón volver para cerrar únicamente la ventana y que no se cierre todo el programa.
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Confirmar si desea salir sin guardar cambios
        if (!asientosSeleccionados.isEmpty()) {
            int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro que desea salir sin confirmar su selección?", 
                "Confirmar salida", 
                JOptionPane.YES_NO_OPTION);
                
            if (respuesta != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmarAsientos();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

