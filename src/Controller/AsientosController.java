package Controller;

import Model.Sala;
import Model.Asiento;
import View.SelecAsientos;
import javax.swing.JButton;
import java.awt.*;

/**
 * Controlador para la gestión de la selección de asientos
 * Coordina la interacción entre la vista (SelecAsientos) y el modelo (Sala/Asiento)
 */
public class AsientosController {
    // Referencias al modelo y vista
    private final Sala sala;      // Modelo con datos de la sala
    private final SelecAsientos vista; // Vista para mostrar asientos
    private final boolean isVip;  // Tipo de sala (VIP/Estandar)

    /**
     * Constructor que inicializa el controlador
     * @param sala Modelo de datos de la sala
     * @param vista Interfaz gráfica
     * @param isVip Indica si es sala VIP
     */
    public AsientosController(Sala sala, SelecAsientos vista, boolean isVip) {
        this.sala = sala;
        this.vista = vista;
        this.isVip = isVip;
        configurarVista();
        generarAsientos();
    }

    /**
     * Configuración inicial de la vista
     * - Establece el título de la ventana
     */
    private void configurarVista() {
        vista.setTitle("Selección de Asientos - " + sala.getNombre());
    }

    /**
     * Genera los botones de asientos en la vista
     * - Calcula distribución óptima para 633x522 px
     * - Crea botones con estilo minimalista
     */
    private void generarAsientos() {
        vista.getPanelAsientos().removeAll(); // Limpia asientos previos
        
        // Configuración para panel de 633x522 px
        int columnas = 10; // 10 columnas como en el diseño original
        int filas = (int) Math.ceil((double)sala.getAsientos().size() / columnas);
        
        // Cálculo de tamaño de botones (considerando 5px de espacio entre ellos)
        int anchoBtn = (633 - ((columnas - 1) * 5)) / columnas;
        int altoBtn = (522 - ((filas - 1) * 5)) / filas;
        int tamaño = Math.min(anchoBtn, altoBtn); // Mantiene proporción cuadrada
        
        // Configura el layout con 10 columnas y espaciado de 5px
        vista.getPanelAsientos().setLayout(new GridLayout(0, columnas, 5, 5));

        // Crea y añade cada botón de asiento
        for (Asiento asiento : sala.getAsientos()) {
            JButton btn = crearBotonAsiento(asiento, tamaño);
            vista.getPanelAsientos().add(btn);
        }
        
        // Actualiza la vista
        vista.getPanelAsientos().revalidate();
        vista.getPanelAsientos().repaint();
    }

    /**
     * Crea un botón de asiento con estilo minimalista
     * @param asiento Modelo del asiento
     * @param tamaño Tamaño cuadrado del botón
     * @return JButton configurado
     */
    private JButton crearBotonAsiento(Asiento asiento, int tamaño) {
        JButton btn = new JButton(asiento.obtenerNumero());
        
        // Estilo visual minimalista
        btn.setContentAreaFilled(false); // Fondo transparente
        btn.setBorderPainted(false);    // Sin bordes
        btn.setForeground(Color.BLACK); // Texto blanco
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 10)); // Fuente pequeña
        btn.setPreferredSize(new Dimension(tamaño, tamaño)); // Tamaño uniforme
        
        // Efecto hover sutil
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                /*btn.setContentAreaFilled(true);
                btn.setBackground(new Color(80, 80, 80)); // Gris oscuro al pasar mouse
                */
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (btn.getBackground() != Color.WHITE) {
                    btn.setContentAreaFilled(false); // Vuelve a transparente si no está seleccionado
                } else {
                    btn.setContentAreaFilled(true);
                }
            }
        });
        
        // Acción al hacer clic
        btn.addActionListener(e -> {
            if (btn.getBackground() == Color.WHITE) {
                // Deseleccionar
                btn.setContentAreaFilled(false);
                asiento.liberar();
            } else {
                // Seleccionar
                btn.setContentAreaFilled(true);
                btn.setBackground(Color.WHITE); // blanco para asiento seleccionado
                asiento.reservar();
            }
        });
        
        return btn;
    }
    
    
}