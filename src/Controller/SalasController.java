package Controller;

import Model.*;
import View.Principal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SalasController {
    private final ISalasRepositorio repoSalas;
    private final IPeliculasRepositorio repoPeliculas;
    private Principal vista;
    
    public SalasController(ISalasRepositorio repoSalas, IPeliculasRepositorio repoPeliculas, Principal vista) {
        this.repoSalas = repoSalas;
        this.repoPeliculas = repoPeliculas;
        this.vista = vista;
    }

    public void iniciarDatosDeSalaEnVista() {
        if (vista == null) return;
        
        // Cargar la tabla de salas desde su repositorio
        ArrayList<Sala> salas = repoSalas.getSala();
        vista.actualizarTablaSalas(salas);
        
        // Cargar el ComboBox con las películas disponibles desde su repositorio
        ArrayList<Pelicula> peliculas = repoPeliculas.obtenerCartelera();
        vista.actualizarComboPeliculas(peliculas);
    }

    public void asignarPeliculaASala() {
        if (vista == null) return;
        
        int filaSeleccionada = vista.getTableSalas().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una sala de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String tituloPelicula = (String) vista.getComboPeliculasSa1().getSelectedItem();
        if (tituloPelicula == null || tituloPelicula.equals("Seleccione una película")) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una película válida del menú.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idSala = (String) vista.getTableSalas().getValueAt(filaSeleccionada, 0);
        
        // Busca los objetos
        Sala salaSeleccionada = repoSalas.buscarSalaPorId(idSala); 
        Pelicula peliculaSeleccionada = repoPeliculas.buscarPeliculaPorTitulo(tituloPelicula);

        if (salaSeleccionada != null && peliculaSeleccionada != null) {
            // Actualizamos el repositorio
            salaSeleccionada.setPelicula(peliculaSeleccionada);
            repoSalas.actualizarSala(salaSeleccionada);
            iniciarDatosDeSalaEnVista();

            JOptionPane.showMessageDialog(vista, "Película asignada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vista, "Error: No se encontró la sala o la película en los repositorios.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Sala buscarSalaPorId(String idSala) {
    return repoSalas.buscarSalaPorId(idSala);
}
}