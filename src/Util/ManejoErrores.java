package Util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Clase centralizada para manejo de errores y mensajes de la aplicación
 */
public class ManejoErrores {
    
    private static final Logger LOGGER = Logger.getLogger(ManejoErrores.class.getName());
    
    /**
     * Muestra un diálogo de error con el mensaje y la excepción
     * @param mensaje Mensaje de error para el usuario
     * @param excepcion Excepción que causó el error
     * @param parent Ventana padre (puede ser null)
     */
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
    
    /**
     * Muestra un diálogo de error con el mensaje y la excepción (sin ventana padre)
     * @param mensaje Mensaje de error para el usuario
     * @param excepcion Excepción que causó el error
     */
    public static void mostrarError(String mensaje, Exception excepcion) {
        mostrarError(mensaje, excepcion, null);
    }
    
    /**
     * Muestra un diálogo de error simple
     * @param mensaje Mensaje de error para el usuario
     * @param parent Ventana padre (puede ser null)
     */
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
    
    /**
     * Muestra un diálogo de error simple sin ventana padre
     * @param mensaje Mensaje de error para el usuario
     */
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
    
    /**
     * Muestra un diálogo de información
     * @param mensaje Mensaje informativo
     * @param titulo Título del diálogo
     * @param parent Ventana padre (puede ser null)
     */
    public static void mostrarInfo(String mensaje, String titulo, JFrame parent) {
        JOptionPane.showMessageDialog(
            parent, 
            mensaje,
            titulo, 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Muestra un diálogo de advertencia
     * @param mensaje Mensaje de advertencia
     * @param titulo Título del diálogo
     * @param parent Ventana padre (puede ser null)
     */
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