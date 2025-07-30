package Controller;

import Model.Pelicula;
import Model.RepositorioPeliculas;
import Model.RestriccionesEdad;
import View.Principal;
import Model.*;
import View.Principal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
            modelo.addRow(new Object[]{
                pelicula.obtenerTitulo(),
                pelicula.obtenerGenero(),
                pelicula.obtenerRestriccionEdad().name() // .name() convierte el enum a texto (A, B, C)

            });
        }
    }
    /**
     * Agrega una nueva película a la cartelera.
     */
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

            // Genera el ID automáticamente
            int nuevoIdNumerico = repoPeliculas.obtenerCartelera().size() + 1;
            String id = String.format("p%03d", nuevoIdNumerico);

            Pelicula nuevaPelicula = new Pelicula(id, titulo, genero, duracion, restriccion);
            repoPeliculas.guardarPelicula(nuevaPelicula);

            JOptionPane.showMessageDialog(vistaPrincipal, "¡Película agregada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vistaPrincipal, "La duración debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        

        
    }
}