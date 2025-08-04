package View;

import Controller.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import org.netbeans.lib.awtextra.AbsoluteLayout;
public class Inicio extends javax.swing.JFrame {
    private AuthController authController;
    private ImageIcon imagenOriginal; 
    
    public Inicio(AuthController authController) {
        this.authController = authController;
        initComponents();

        // ——— Aquí cargas la imagen otra vez en el JLabel ———
        jLabelImagen1.setIcon(
            new javax.swing.ImageIcon(
                getClass().getResource("/images/BannerInicio.png")
            )
        );

        // Ahora guardas la imagen original para poder escalarla luego
        imagenOriginal = (ImageIcon) jLabelImagen1.getIcon();

        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../images/icono.png")).getImage());

        // Listener para redimensionar dinámicamente
        jLabelImagen1.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                if (imagenOriginal != null) {
                    RenderizadorImagenes.ajustarImagenEnLabel(jLabelImagen1, imagenOriginal);
                }
            }
        });
    }

    public void setControlador(AuthController authController) {
        this.authController = authController;
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonInicioSesion = new javax.swing.JButton();
        jLabelQuestion = new javax.swing.JLabel();
        jLabelImagen1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 21, 49));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 344));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 344));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsuario.setBackground(new java.awt.Color(0, 21, 49));
        jTextFieldUsuario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 420, 40));

        jPasswordField.setBackground(new java.awt.Color(0, 21, 49));
        jPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField.setBorder(null);
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyTyped(evt);
            }
        });
        jPanel1.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 420, 30));

        jButtonInicioSesion.setBackground(new java.awt.Color(14, 42, 83));
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
        jPanel1.add(jButtonInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 450, 60));

        jLabelQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Question.png"))); // NOI18N
        jLabelQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelQuestionMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, -1, -1));

        jLabelImagen1.setText("jLabel1");
        jPanel1.add(jLabelImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (imagenOriginal != null) {
            RenderizadorImagenes.ajustarImagenEnLabel(jLabelImagen1, imagenOriginal);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jTextFieldUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioFocusGained
        if(jTextFieldUsuario.getText().equals("Ingrese su usuario") == true){
            jTextFieldUsuario.setText("");
        }
    }//GEN-LAST:event_jTextFieldUsuarioFocusGained

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
        this.authController.intentarLogin();
    }//GEN-LAST:event_jButtonInicioSesionActionPerformed

    private void jLabelQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuestionMouseClicked
        JOptionPane.showMessageDialog(this, "User: admin\nPassword: admin");
    }//GEN-LAST:event_jLabelQuestionMouseClicked

    private void jPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyTyped
        char tecla = evt.getKeyChar();
        if(tecla == KeyEvent.VK_ENTER){
            jButtonInicioSesion.doClick();
        }
    }//GEN-LAST:event_jPasswordFieldKeyTyped

    private void jTextFieldUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyTyped
    }//GEN-LAST:event_jTextFieldUsuarioKeyTyped

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonInicioSesion;
    private javax.swing.JLabel jLabelImagen1;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField jPasswordField;
    public javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
