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
        // Obtenemos la selección de la Vista
        int filaSeleccionada = vistaPrincipal.getTableSalas().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, seleccione una sala de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vistaPrincipal.getComboPeliculasSa1().getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Por favor, seleccione una película del menú.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // se extraen los identificadores de la Vista
        String nombreSala = (String) vistaPrincipal.getTableSalas().getValueAt(filaSeleccionada, 0);
        String tituloPelicula = (String) vistaPrincipal.getComboPeliculasSa1().getSelectedItem();

        // se buscan los objetos del Modelo usando los repositorios
        Sala salaSeleccionada = repoSalas.buscarSalaPorNombre(nombreSala); // Necesitarás crear este método
        Pelicula peliculaSeleccionada = repoPeliculas.buscarPeliculaPorTitulo(tituloPelicula); // Y este también
        
        //Si ambas existen usamos el metodo del modelo ...
        if (salaSeleccionada != null && peliculaSeleccionada != null) {
            salaSeleccionada.setPelicula(peliculaSeleccionada);
            
            cargarDatosDeSalas();
            
            JOptionPane.showMessageDialog(vistaPrincipal, "Película '" + tituloPelicula + "' asignada a la " + nombreSala + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vistaPrincipal, "Error: No se encontraron la sala o la película en los repositorios.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void iniciarDatosDeSalaEnVista() {
        cargarDatosDeSalas();
    }


}


