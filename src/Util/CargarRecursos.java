package Util;

import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Utilidad para cargar recursos como imágenes
 */
public class CargarRecursos {
    
    /**
     * Obtiene un ícono desde un archivo de imagen en el paquete images
     * @param nombreImagen Nombre del archivo de imagen
     * @return ImageIcon con la imagen cargada o un ícono vacío si no se encuentra
     */
    public static ImageIcon getIcon(String nombreImagen) {
        try {
            // Intenta cargar desde recursos del classpath
            URL url = CargarRecursos.class.getResource("/images/" + nombreImagen);
            if (url != null) {
                return new ImageIcon(url);
            }
            
            // Si no encuentra en el classpath, intenta como ruta relativa
            String projectPath = System.getProperty("user.dir");
            String fullPath = projectPath + File.separator + "src" + File.separator
                    + "images" + File.separator + nombreImagen;
            File file = new File(fullPath);
            
            if (file.exists()) {
                return new ImageIcon(fullPath);
            }
            
            // Si no encuentra, devuelve un ícono vacío
            System.err.println("No se pudo cargar la imagen: " + nombreImagen);
            return new ImageIcon();
            
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen " + nombreImagen + ": " + e.getMessage());
            return new ImageIcon();
        }
    }
    
    /**
     * Obtiene la ruta absoluta a un archivo en el paquete images
     * @param nombreArchivo Nombre del archivo
     * @return Ruta absoluta al archivo o null si no se encuentra
     */
    public static String getRutaAbsoluta(String nombreArchivo) {
        try {
            String projectPath = System.getProperty("user.dir");
            String fullPath = projectPath + File.separator + "src" + File.separator
                    + "images" + File.separator + nombreArchivo;
            File file = new File(fullPath);
            
            if (file.exists()) {
                return fullPath;
            }
            
            return null;
        } catch (Exception e) {
            System.err.println("Error al obtener ruta a " + nombreArchivo + ": " + e.getMessage());
            return null;
        }
    }
}