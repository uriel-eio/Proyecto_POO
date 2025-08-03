package Controller;

import Model.*;
import View.Principal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalasController {
    private final RepositorioSalas repoSalas;
    private final RepositorioPeliculas repoPeliculas;
    private final Principal vistaPrincipal;

    /*private VentasController ventasController;
    
    public void setVentasController(VentasController ventasController) {
        this.ventasController = ventasController;
    }*/
    
    public SalasController(RepositorioSalas repoSalas, RepositorioPeliculas repoPeliculas, Principal vista) {
        this.repoSalas = repoSalas;
        this.repoPeliculas = repoPeliculas;
        this.vistaPrincipal = vista;
        cargarDatosDeSalas();
    }

    private void cargarDatosDeSalas() {
        //Cargar la tabla de salas desde su repositorio
        ArrayList<Sala> salas = repoSalas.getSala();
        vistaPrincipal.actualizarTablaSalas(salas);
        //Cargar el ComboBox con las películas disponibles desde su repositorio
        ArrayList<Pelicula> peliculas = repoPeliculas.obtenerCartelera();
        vistaPrincipal.actualizarComboPeliculas(peliculas);
    }

     public void asignarPeliculaASala() {
        int filaSeleccionada = vistaPrincipal.getTableSalas().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, seleccione una sala de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String tituloPelicula = (String) vistaPrincipal.getComboPeliculasSa1().getSelectedItem();
        if (tituloPelicula == null || tituloPelicula.equals("Seleccione una película")) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, seleccione una película válida del menú.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idSala = (String) vistaPrincipal.getTableSalas().getValueAt(filaSeleccionada, 0);
        
        //Busca los objetos
        Sala salaSeleccionada = repoSalas.buscarSalaPorId(idSala); 
        Pelicula peliculaSeleccionada = repoPeliculas.buscarPeliculaPorTitulo(tituloPelicula);

        if (salaSeleccionada != null && peliculaSeleccionada != null) {
            // Actualizamos el repositorio
            salaSeleccionada.setPelicula(peliculaSeleccionada);
            repoSalas.actualizarSala(salaSeleccionada);
            cargarDatosDeSalas();

            JOptionPane.showMessageDialog(vistaPrincipal, "Película asignada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Este es el error que estás viendo. Ocurre si la sala o la película no se encuentran.
            JOptionPane.showMessageDialog(vistaPrincipal, "Error: No se encontró la sala o la película en los repositorios.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

     public void iniciarDatosDeSalaEnVista() {
        cargarDatosDeSalas();
    }


}


