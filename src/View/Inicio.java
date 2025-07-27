package com.mycompany.proyectoprograii.view;

import controller.Controlador;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {
    Controlador controlador;
    
    public Inicio(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../images/icono.png")).getImage());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelSeparador2 = new javax.swing.JLabel();
        jLabelSeparador1 = new javax.swing.JLabel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelCerrar = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonFantasma = new javax.swing.JButton();
        jButtonInicioSesion = new javax.swing.JButton();
        jLabelQuestion = new javax.swing.JLabel();
        jLabelAcerca = new javax.swing.JLabel();
        jLabelImagen1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 344));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 344));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 344));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSeparador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Separador.png"))); // NOI18N
        jLabelSeparador2.setText("jLabel1");
        jPanel1.add(jLabelSeparador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1000, 4));
        jLabelSeparador2.getAccessibleContext().setAccessibleDescription("");

        jLabelSeparador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Separador.png"))); // NOI18N
        jPanel1.add(jLabelSeparador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 4));

        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Minimizar.png"))); // NOI18N
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, -1, -1));

        jLabelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Equis.png"))); // NOI18N
        jLabelCerrar.setAlignmentY(0.0F);
        jLabelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, -1));

        jTextFieldUsuario.setBackground(new java.awt.Color(43, 43, 43));
        jTextFieldUsuario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario.setText("Ingrese su usuario");
        jTextFieldUsuario.setBorder(null);
        jTextFieldUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsuarioFocusLost(evt);
            }
        });
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 172, 170, 30));

        jPasswordField.setBackground(new java.awt.Color(43, 43, 43));
        jPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField.setText("jPasswordField1");
        jPasswordField.setBorder(null);
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyTyped(evt);
            }
        });
        jPanel1.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 235, 140, 30));

        jButtonFantasma.setBackground(new java.awt.Color(43, 43, 43));
        jButtonFantasma.setBorder(null);
        jButtonFantasma.setBorderPainted(false);
        jButtonFantasma.setFocusPainted(false);
        jButtonFantasma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFantasmaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFantasma, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, -1));

        jButtonInicioSesion.setBackground(new java.awt.Color(38, 38, 38));
        jButtonInicioSesion.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        jButtonInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInicioSesion.setText("Acceder");
        jButtonInicioSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonInicioSesion.setFocusPainted(false);
        jButtonInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioSesionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, 100, 40));

        jLabelQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Question.png"))); // NOI18N
        jLabelQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelQuestionMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, -1, -1));

        jLabelAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAcercaMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelAcerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 210, 50));

        jLabelImagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BannerInicio.png"))); // NOI18N
        jPanel1.add(jLabelImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1000, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 344));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        try {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el sistema?", "Salir", dialogButton);
            if(result == 0){
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jLabelCerrarMouseClicked

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
        this.setState(com.mycompany.proyectoprograii.view.Inicio.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizarMouseClicked

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jTextFieldUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioFocusGained
        if(jTextFieldUsuario.getText().equals("Ingrese su usuario") == true){
            jTextFieldUsuario.setText("");
        }
    }//GEN-LAST:event_jTextFieldUsuarioFocusGained

    private void jButtonFantasmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFantasmaActionPerformed
    }//GEN-LAST:event_jButtonFantasmaActionPerformed

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        if(jPasswordField.getText().equals("jPasswordField1") == true){
            jPasswordField.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jTextFieldUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioFocusLost
        if(jTextFieldUsuario.getText().trim().equals("") == true){
            jTextFieldUsuario.setText("Ingrese su usuario");
        }
    }//GEN-LAST:event_jTextFieldUsuarioFocusLost

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
        if(jPasswordField.getText().trim().equals("") == true){
            jPasswordField.setText("jPasswordField1");
        }
    }//GEN-LAST:event_jPasswordFieldFocusLost

    private void jButtonInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioSesionActionPerformed
        this.controlador.iniciarSesion(this);
    }//GEN-LAST:event_jButtonInicioSesionActionPerformed

    private void jLabelQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuestionMouseClicked
        JOptionPane.showMessageDialog(this, "User: admin\nPassword: admin");
    }//GEN-LAST:event_jLabelQuestionMouseClicked

    private void jLabelAcercaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAcercaMouseClicked
        JOptionPane.showMessageDialog(this, "Carlos Fontes & Rafael Quintero\n\t                      UNIMET\n             Ing. de Sistemas");
    }//GEN-LAST:event_jLabelAcercaMouseClicked

    private void jPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyTyped
        char tecla = evt.getKeyChar();
        if(tecla == KeyEvent.VK_ENTER){
            jButtonInicioSesion.doClick();
        }
    }//GEN-LAST:event_jPasswordFieldKeyTyped

    private void jTextFieldUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyTyped
    }//GEN-LAST:event_jTextFieldUsuarioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFantasma;
    public javax.swing.JButton jButtonInicioSesion;
    private javax.swing.JLabel jLabelAcerca;
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabelImagen1;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelSeparador1;
    private javax.swing.JLabel jLabelSeparador2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField jPasswordField;
    public javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
