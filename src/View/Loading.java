package View;

import java.awt.Color;
import javax.swing.ImageIcon;

public class Loading extends javax.swing.JFrame { 

    public Loading() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../images/icono.png")).getImage());
        this.setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingBar = new javax.swing.JProgressBar();
        jLabelPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadingBar.setBackground(new java.awt.Color(237, 192, 180));
        loadingBar.setForeground(new java.awt.Color(51, 51, 51));
        loadingBar.setBorderPainted(false);
        loadingBar.setFocusable(false);
        getContentPane().add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 154, 220, 53));

        jLabelPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TicketBisel.png"))); // NOI18N
        getContentPane().add(jLabelPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelPic;
    public javax.swing.JProgressBar loadingBar;
    // End of variables declaration//GEN-END:variables
}
