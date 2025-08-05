package Util;

import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;

public class CargarRecursos {
    
    public static ImageIcon getIcon(String nombreImagen) {
        try {
            URL url = CargarRecursos.class.getResource("/images/" + nombreImagen);
            if (url != null) {
                return new ImageIcon(url);
            }
            
            // si no encuentra usa la navaja
            String fullPath = Rutas.getRutaImagen(nombreImagen);
            File file = new File(fullPath);
            
            if (file.exists()) {
                return new ImageIcon(fullPath);
            }
            
            // si no hay devuelve un icono vacio
            System.err.println("No se pudo cargar la imagen: " + nombreImagen);
            return new ImageIcon();
            
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen " + nombreImagen + ": " + e.getMessage());
            return new ImageIcon();
        }
    }
}
