/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author usuario
 */
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderizadorImagenes extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Llama al método del padre para la configuración básica (colores de fondo, etc.)
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Limpiamos el texto, solo queremos mostrar un icono.
        setText("");

        if (value instanceof ImageIcon) {
            ImageIcon originalIcon = (ImageIcon) value;
            Image originalImage = originalIcon.getImage();

            // Obtenemos el alto de la fila como nuestro tamaño objetivo
            // Restamos un pequeño margen para que no se pegue a los bordes
            int targetHeight = table.getRowHeight(row) - 5;
            
            // Si la imagen original es válida
            if (originalIcon.getIconHeight() > 0) {
                // Calculamos el nuevo ancho manteniendo la proporción (aspect ratio)
                int targetWidth = (originalIcon.getIconWidth() * targetHeight) / originalIcon.getIconHeight();

                // SCALE_SMOOTH crea una versión escalada de la imagen con 
                Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
                
                setIcon(new ImageIcon(scaledImage));
            }
        }
        
        return this; 
    }
}
