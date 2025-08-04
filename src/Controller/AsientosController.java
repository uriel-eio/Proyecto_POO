package Controller;

import Model.Sala;
import Model.Asiento;
import Model.Cliente;
import Model.Funcion;
import Model.LogicaOrdenes;
import View.SelecAsientos;
import javax.swing.JButton;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Util.ManejoErrores;

public class AsientosController {
    private final Sala sala;
    private final SelecAsientos vista;
    private final boolean isVip;
    private ArrayList<Asiento> asientosSeleccionados;
    private Funcion funcion;
    private Cliente cliente;
    private VentasController ventasController;
    
    public AsientosController(Sala sala, SelecAsientos vista, boolean isVip, 
                             Funcion funcion, Cliente cliente, 
                             VentasController ventasController) {
        this.sala = sala;
        this.vista = vista;
        this.isVip = isVip;
        this.funcion = funcion;
        this.cliente = cliente;
        this.ventasController = ventasController;
        this.asientosSeleccionados = new ArrayList<>();
        
        configurarVista();
        generarAsientos();
    }

    /**
     * Configuración inicial de la vista
     */
    private void configurarVista() {
        vista.setTitle("Selección de Asientos - " + sala.getNombre());
    }

    /**
     * Genera los botones de asientos en la vista
     */
    private void generarAsientos() {
        vista.getPanelAsientos().removeAll(); // Limpia asientos previos
        
        // Configuración para panel de 633x522 px
        int columnas = 10; // 10 columnas como en el diseño original
        int filas = (int) Math.ceil((double)sala.getAsientos().size() / columnas);
        
        // Cálculo de tamaño de botones
        int tamaño = calcularTamañoBotones(columnas, filas);
        
        // Configura el layout con 10 columnas y espaciado de 5px
        vista.getPanelAsientos().setLayout(new GridLayout(0, columnas, 5, 5));

        // Crea y añade cada botón de asiento
        for (Asiento asiento : sala.getAsientos()) {
            JButton btn = crearBotonAsiento(asiento, tamaño);
            vista.getPanelAsientos().add(btn);
        }
        
        // Actualiza la vista
        actualizarVistaAsientos();
    }
    
    /**
     * Calcula el tamaño óptimo para los botones de asientos
     */
    private int calcularTamañoBotones(int columnas, int filas) {
        // Dimensiones del panel
        int anchoPanelAsientos = 633;
        int altoPanelAsientos = 522;
        
        // Cálculo de tamaño de botones (considerando 5px de espacio entre ellos)
        int anchoBtn = (anchoPanelAsientos - ((columnas - 1) * 5)) / columnas;
        int altoBtn = (altoPanelAsientos - ((filas - 1) * 5)) / filas;
        
        // Mantiene proporción cuadrada
        return Math.min(anchoBtn, altoBtn);
    }
    
    /**
     * Actualiza la vista de asientos
     */
    private void actualizarVistaAsientos() {
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
        configurarEstiloBoton(btn, tamaño);
        
        // Si el asiento ya está reservado, mostrarlo como deshabilitado
        if (asiento.obtenerEstado()) {
            marcarAsientoReservado(btn);
        }
        
        // Efecto hover y acción de clic
        configurarInteraccionBoton(btn, asiento);
        
        return btn;
    }
    
    /**
     * Configura el estilo visual del botón de asiento
     */
    private void configurarEstiloBoton(JButton btn, int tamaño) {
        btn.setContentAreaFilled(false); // Fondo transparente
        btn.setBorderPainted(false);    // Sin bordes
        btn.setForeground(Color.BLACK); // Texto negro
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 10)); // Fuente pequeña
        btn.setPreferredSize(new Dimension(tamaño, tamaño)); // Tamaño uniforme
    }
    
    /**
     * Marca un asiento como reservado en la UI
     */
    private void marcarAsientoReservado(JButton btn) {
        btn.setEnabled(false);
        btn.setBackground(Color.GRAY);
        btn.setContentAreaFilled(true);
    }
    
    /**
     * Configura la interacción del usuario con el botón
     */
    private void configurarInteraccionBoton(JButton btn, Asiento asiento) {
        // Efecto hover sutil
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (btn.isEnabled() && !btn.getBackground().equals(Color.GREEN)) {
                    btn.setBackground(new Color(200, 200, 200));
                    btn.setContentAreaFilled(true);
                }
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (btn.isEnabled() && !btn.getBackground().equals(Color.GREEN)) {
                    btn.setContentAreaFilled(false);
                }
            }
        });
        
        // Acción al hacer clic
        btn.addActionListener(e -> manejarClicAsiento(btn, asiento));
    }
    
    /**
     * Maneja el clic en un botón de asiento
     */
    private void manejarClicAsiento(JButton btn, Asiento asiento) {
        if (btn.getBackground().equals(Color.GREEN)) {
            // Deseleccionar
            btn.setBackground(null);
            btn.setContentAreaFilled(false);
            asientosSeleccionados.remove(asiento);
        } else {
            // Seleccionar
            btn.setBackground(Color.GREEN);
            btn.setContentAreaFilled(true);
            asientosSeleccionados.add(asiento);
        }
    }
    
    /**
     * Devuelve los asientos seleccionados por el usuario
     */
    public ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }
    
    /**
     * Confirma la selección de asientos
     */
    public void confirmarSeleccion() {
        if (asientosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(vista, 
                "No ha seleccionado ningún asiento", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            // Crear la orden a través del controlador de ventas
            ventasController.crearNuevaOrden(cliente, funcion, asientosSeleccionados);
            
            JOptionPane.showMessageDialog(vista, 
                "Se han reservado " + asientosSeleccionados.size() + " asientos", 
                "Reserva exitosa", JOptionPane.INFORMATION_MESSAGE);
            
            vista.dispose();
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al confirmar la selección", e, vista);
        }
    }
    
    /**
     * Reserva los asientos seleccionados
     */
    private void reservarAsientosSeleccionados() {
        for (Asiento asiento : asientosSeleccionados) {
            asiento.reservar();
        }
    }
}