/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author usuario
 */
public class CargarRecursos {
    public static ImageIcon getIcon(String nombreImagen) {
        String projectPath = System.getProperty("user.dir");
        String fullPath = projectPath + File.separator + "src" + File.separator
                + "images" + File.separator + nombreImagen;
        return new ImageIcon(fullPath);
    }
}
