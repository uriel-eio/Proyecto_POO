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

    public void asignarPeliculaASala(int salaID, Pelicula pelicula) {
        int filaSeleccionada = vistaPrincipal.getTableSalas().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, seleccione una sala de la tabla.");
            return;
        }

        if (vistaPrincipal.getComboPeliculasSa1().getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, seleccione una película del menú.");
            return;
        }

        String nombreSala = (String) vistaPrincipal.getTableSalas().getValueAt(filaSeleccionada, 0);
        String tituloPelicula = (String) vistaPrincipal.getComboPeliculasSa1().getSelectedItem();

        // Buscar los objetos correspondientes en el Modelo
        Sala salaSeleccionada = repoSalas.buscarSalaPorNombre(nombreSala);
        Pelicula peliculaSeleccionada = repoPeliculas.buscarPeliculaPorTitulo(tituloPelicula);

        if (salaSeleccionada != null && peliculaSeleccionada != null) {
            salaSeleccionada.setPelicula(peliculaSeleccionada);

            // Refrescar la vista para mostrar el cambio inmediatamente
            cargarDatosDeSalas();

            JOptionPane.showMessageDialog(vistaPrincipal, "Película '" + tituloPelicula + "' asignada a la sala '" + nombreSala + "'.");
        } else {
            JOptionPane.showMessageDialog(vistaPrincipal, "Error al asignar la película. Verifique los datos.");
        }
    }


}


