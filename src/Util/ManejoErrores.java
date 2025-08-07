package Util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class ManejoErrores {
    
    private static final Logger LOGGER = Logger.getLogger(ManejoErrores.class.getName());
    
    public static void mostrarError(String mensaje, Exception excepcion, JFrame parent) {
        // Loguear el error para depuración
        LOGGER.log(Level.SEVERE, mensaje, excepcion);
        
        // Mostrar al usuario
        JOptionPane.showMessageDialog(
            parent, 
            mensaje + "\nDetalles técnicos: " + excepcion.getMessage(),
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    // manejo de errores para todos, todas y todes
    
    public static void mostrarError(String mensaje, Exception excepcion) {
        mostrarError(mensaje, excepcion, null);
    }
    

    public static void mostrarError(String mensaje, JFrame parent) {
        // Loguear el error para depuración
        LOGGER.log(Level.WARNING, mensaje);
        
        // Mostrar al usuario
        JOptionPane.showMessageDialog(
            parent, 
            mensaje,
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    // dialogo simple
    public static void mostrarError(String mensaje) {
        // Loguear el error para depuración
        LOGGER.log(Level.WARNING, mensaje);
        
        // Mostrar al usuario sin especificar ventana padre (null)
        JOptionPane.showMessageDialog(
            null, 
            mensaje,
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    // informacion
    public static void mostrarInfo(String mensaje, String titulo, JFrame parent) {
        JOptionPane.showMessageDialog(
            parent, 
            mensaje,
            titulo, 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public static void mostrarAdvertencia(String mensaje, String titulo, JFrame parent) {
        // Loguear la advertencia
        LOGGER.log(Level.WARNING, mensaje);
        
        JOptionPane.showMessageDialog(
            parent, 
            mensaje,
            titulo, 
            JOptionPane.WARNING_MESSAGE
        );
    }
}