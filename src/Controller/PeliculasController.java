package Controller;

import Model.Pelicula;
import Model.IPeliculasRepositorio;
import Model.RestriccionesEdad;
import View.Principal;
import Util.ManejoErrores;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class PeliculasController {

    private final IPeliculasRepositorio repoPeliculas;
    private Principal vista;

    public PeliculasController(IPeliculasRepositorio repoPeliculas, Principal vista) {
        this.repoPeliculas = repoPeliculas;
        this.vista = vista;
    }

    public ArrayList<Pelicula> obtenerCartelera() {
        return repoPeliculas.obtenerCartelera();
    }
    
    public void cargarPeliculasEnVista() {
        if (vista == null) return;
        
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablePeli().getModel();
        modelo.setRowCount(0); // Limpia la tabla

        ArrayList<Pelicula> peliculas = repoPeliculas.obtenerCartelera();
        for (Pelicula pelicula : peliculas) {
            ImageIcon portada = null;
            try {
                String rutaImagen = "/images/" + pelicula.getRutaPortada();
                portada = Util.CargarRecursos.getIcon(pelicula.getRutaPortada());
            } catch (Exception e) {
                // Si no se encuentra la imagen, usamos un icono vacío sin mostrar error
                portada = new ImageIcon();
            }

            modelo.addRow(new Object[]{
                pelicula.obtenerTitulo(),
                pelicula.obtenerGenero(),
                pelicula.obtenerRestriccionEdad().name(),
                portada
            });
        }
    }
    
    // seleccion de imagenes
    public String seleccionarYCopiarPortada() {
        if (vista == null) return null;
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes (jpg, png, gif, jpeg)", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);
        
        int resultado = fileChooser.showOpenDialog(vista);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            
            String destPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "images";
            File carpetaDestino = new File(destPath);
            
            if (!carpetaDestino.exists()) {
                carpetaDestino.mkdirs();
            }
            
            File archivoDestino = new File(carpetaDestino.getPath() + File.separator + archivoSeleccionado.getName());
            
            try {
                Files.copy(archivoSeleccionado.toPath(), 
                        archivoDestino.toPath(), 
                        StandardCopyOption.REPLACE_EXISTING);
                return archivoSeleccionado.getName();
            } catch (IOException e) {
                ManejoErrores.mostrarError("Error al copiar la imagen de portada", e, vista);
                return null;
            }
        }
        return null;
    }
    
    // aniadir imagen, profe deme ese punto
    public void agregarNuevaPelicula() {
        if (vista == null) return;
        
        try {
            String titulo = JOptionPane.showInputDialog(vista, "Ingrese el título de la película:");
            if (titulo == null || titulo.trim().isEmpty()) return;

            String genero = JOptionPane.showInputDialog(vista, "Ingrese el género:");
            if (genero == null || genero.trim().isEmpty()) return;

            String duracionStr = JOptionPane.showInputDialog(vista, "Ingrese la duración en minutos:");
            if (duracionStr == null || duracionStr.trim().isEmpty()) return;
            int duracion = Integer.parseInt(duracionStr);

            RestriccionesEdad restriccion = (RestriccionesEdad) JOptionPane.showInputDialog(
                    vista,
                    "Seleccione la restricción de edad",
                    "Clasificación",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    RestriccionesEdad.values(),
                    RestriccionesEdad.A
            );
            if (restriccion == null) return;
            
            String nombreArchivoPortada = seleccionarYCopiarPortada();
            if (nombreArchivoPortada == null) {
                ManejoErrores.mostrarAdvertencia(
                    "No se seleccionó una portada. Operación cancelada.", 
                    "Aviso", 
                    vista
                );
                return;
            }
            
            // Genera el ID automáticamente
            int nuevoIdNumerico = repoPeliculas.obtenerCartelera().size() + 1;
            String id = String.format("p%03d", nuevoIdNumerico);

            Pelicula nuevaPelicula = new Pelicula(id, titulo, genero, duracion, restriccion, nombreArchivoPortada);
            repoPeliculas.guardarPelicula(nuevaPelicula);
            cargarPeliculasEnVista();
            
            ManejoErrores.mostrarInfo("Se agregó la película correctamente", "Éxito", vista);
                
        } catch (NumberFormatException e) {
            ManejoErrores.mostrarError("La duración debe ser un número válido", e, vista);
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al agregar película", e, vista);
        }
    }
}