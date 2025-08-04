package View;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase utilitaria para renderizar imágenes en componentes de UI
 */
public class RenderizadorImagenes extends DefaultTableCellRenderer {
    
    /**
     * Renderiza imágenes en celdas de tablas
     */
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
    
    /**
     * Ajusta una imagen al tamaño de un JLabel
     * @param label El JLabel donde se mostrará la imagen
     * @param icon La imagen a ajustar
     */
    public static void ajustarImagenEnLabel(JLabel label, ImageIcon icon) {
        if (icon == null || label == null) return;

        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();

        if (labelWidth <= 0 || labelHeight <= 0) {
            return; // Evitar errores si el label no tiene tamaño aún
        }

        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();

        // Calcular escala para mantener el aspecto
        double scaleWidth = (double) labelWidth / iconWidth;
        double scaleHeight = (double) labelHeight / iconHeight;
        double scale = Math.min(scaleWidth, scaleHeight); // Escalar sin deformar

        int newWidth = (int) (iconWidth * scale);
        int newHeight = (int) (iconHeight * scale);

        Image scaledImage = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));
    }
}