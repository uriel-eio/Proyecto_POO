package Controller;

import Model.Pelicula;
import Model.RepositorioPeliculas;
import Model.RestriccionesEdad;
import View.Principal;
import View.Principal;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PeliculasController {

    private final RepositorioPeliculas repoPeliculas;
    private final Principal vistaPrincipal;

    public PeliculasController(RepositorioPeliculas repoPeliculas, Principal vistaPrincipal) {
        this.repoPeliculas = repoPeliculas;
        this.vistaPrincipal = vistaPrincipal;
        // Solo crea películas predeterminadas si el archivo no existe
        this.repoPeliculas.creacionPeliculasPredeterminadas();
        // No se llama actualizarTablaPeliculas aquí, lo decides tú
    }

    /**
     * Devuelve la lista de películas en cartelera.
     */
    public ArrayList<Pelicula> obtenerCartelera() {
        return repoPeliculas.obtenerCartelera();
    }
    public void cargarPeliculasEnVista() {
        DefaultTableModel modelo = (DefaultTableModel) vistaPrincipal.getTablePeli().getModel();
        modelo.setRowCount(0); // Limpia la tabla para evitar duplicados

        ArrayList<Pelicula> peliculas = repoPeliculas.obtenerCartelera();
        for (Pelicula pelicula : peliculas) {
            ImageIcon portada = CargarRecursos.getIcon(pelicula.getRutaPortada());

            modelo.addRow(new Object[]{
                pelicula.obtenerTitulo(),
                pelicula.obtenerGenero(),
                pelicula.obtenerRestriccionEdad().name(), // .name() convierte el enum a texto (A, B, C)
                portada
            });
        }
    }
    private String seleccionarYCopiarPortada() {
        JFileChooser fileChooser = new JFileChooser();
        // Filtro para mostrar solo archivos de imagen
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes (jpg, png, gif, jpeg)", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);
        
        int resultado = fileChooser.showOpenDialog(vistaPrincipal);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            
            // Define la carpeta de destino dentro del proyecto
            String destPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "images";
            File carpetaDestino = new File(destPath);
            
            // Crea la carpeta si no existe
            if (!carpetaDestino.exists()) {
                carpetaDestino.mkdirs();
            }
            
            File archivoDestino = new File(carpetaDestino.getPath() + File.separator + archivoSeleccionado.getName());
            
            try {
                // Copia el archivo a la carpeta del proyecto
                Files.copy(archivoSeleccionado.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                // Devuelve solo el nombre del archivo, que es lo que guardaremos en el modelo
                return archivoSeleccionado.getName();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vistaPrincipal, "Error al copiar la imagen de portada.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return null;
            }
        }
        return null; // El usuario canceló la selección
    }
    
    public void agregarNuevaPelicula() {
        try {
            String titulo = JOptionPane.showInputDialog(vistaPrincipal, "Ingrese el título de la película:");
            if (titulo == null || titulo.trim().isEmpty()) return;

            String genero = JOptionPane.showInputDialog(vistaPrincipal, "Ingrese el género:");
            if (genero == null || genero.trim().isEmpty()) return;

            String duracionStr = JOptionPane.showInputDialog(vistaPrincipal, "Ingrese la duración en minutos:");
            if (duracionStr == null || duracionStr.trim().isEmpty()) return;
            int duracion = Integer.parseInt(duracionStr);

            RestriccionesEdad restriccion = (RestriccionesEdad) JOptionPane.showInputDialog(
                    vistaPrincipal,
                    "Seleccione la restricción de edad",
                    "Clasificación",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    RestriccionesEdad.values(),
                    RestriccionesEdad.A
            );
            if (restriccion == null) return;
            
            // TODO COMENTAR
            String nombreArchivoPortada = seleccionarYCopiarPortada();
            if (nombreArchivoPortada == null) {
                JOptionPane.showMessageDialog(vistaPrincipal, "No se seleccionó una portada. Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Genera el ID automáticamente
            int nuevoIdNumerico = repoPeliculas.obtenerCartelera().size() + 1;
            String id = String.format("p%03d", nuevoIdNumerico);

        Pelicula nuevaPelicula = new Pelicula(id, titulo, genero, duracion, restriccion, nombreArchivoPortada);
            repoPeliculas.guardarPelicula(nuevaPelicula);
            cargarPeliculasEnVista();
            JOptionPane.showMessageDialog(vistaPrincipal, "Se agregó la película", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vistaPrincipal, "La duración debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        

        
    }
}