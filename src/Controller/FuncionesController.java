package Controller;

import Model.*;
import View.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FuncionesController {
    
    private final IFuncionesRepositorio repoFunciones;
    private final IPeliculasRepositorio repoPeliculas;
    private final ISalasRepositorio repoSalas;
    private final Principal vistaPrincipal;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public FuncionesController(IFuncionesRepositorio repoFunciones, 
                             IPeliculasRepositorio repoPeliculas,
                             ISalasRepositorio repoSalas,
                             Principal vistaPrincipal) {
        this.repoFunciones = repoFunciones;
        this.repoPeliculas = repoPeliculas;
        this.repoSalas = repoSalas;
        this.vistaPrincipal = vistaPrincipal;
    }
    
    // carga al combox
    public void cargarFuncionesEnComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("Seleccione una función");
        
        List<Funcion> funciones = repoFunciones.obtenerFunciones();
        for (Funcion funcion : funciones) {
            String item = funcion.getId() + " - " + 
                          funcion.getPelicula().obtenerTitulo() + " - " +
                          funcion.getSala().getNombre() + " - " +
                          funcion.getFechaHora().format(FORMATTER);
            comboBox.addItem(item);
        }
    }
    
    // new funcion
    public void crearNuevaFuncion() {
        try {
            // Obtener película
            Pelicula peliculaSeleccionada = seleccionarPelicula();
            if (peliculaSeleccionada == null) return;
            
            // Obtener sala
            Sala salaSeleccionada = seleccionarSala();
            if (salaSeleccionada == null) return;
            
            // Obtener fecha y hora
            LocalDateTime fechaHora = obtenerFechaHora();
            if (fechaHora == null) return;
            
            // Crear la función
            crearFuncion(peliculaSeleccionada, salaSeleccionada, fechaHora);
            
        } catch (Exception e) {
            mostrarErrorCreacionFuncion(e);
        }
    }
    
    // solo es el mensaje
    private Pelicula seleccionarPelicula() {
        List<Pelicula> peliculas = repoPeliculas.obtenerCartelera();
        if (peliculas.isEmpty()) {
            JOptionPane.showMessageDialog(vistaPrincipal, 
                "No hay películas disponibles. Agregue películas primero.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return (Pelicula) JOptionPane.showInputDialog(
            vistaPrincipal,
            "Seleccione la película:",
            "Nueva Función",
            JOptionPane.QUESTION_MESSAGE,
            null,
            peliculas.toArray(),
            peliculas.get(0)
        );
    }
    
    // lo mismo de arriba pero para salas
    private Sala seleccionarSala() {
        List<Sala> salas = repoSalas.getSala();
        if (salas.isEmpty()) {
            JOptionPane.showMessageDialog(vistaPrincipal, 
                "No hay salas disponibles.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return (Sala) JOptionPane.showInputDialog(
            vistaPrincipal,
            "Seleccione la sala:",
            "Nueva Función",
            JOptionPane.QUESTION_MESSAGE,
            null,
            salas.toArray(),
            salas.get(0)
        );
    }
    
    // lo mismo para fecha hora
    private LocalDateTime obtenerFechaHora() {
        String fechaStr = JOptionPane.showInputDialog(
            vistaPrincipal,
            "Ingrese la fecha (formato: dd/MM/yyyy):",
            "Nueva Función",
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (fechaStr == null || fechaStr.trim().isEmpty()) return null;
        
        String horaStr = JOptionPane.showInputDialog(
            vistaPrincipal,
            "Ingrese la hora (formato: HH:mm):",
            "Nueva Función",
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (horaStr == null || horaStr.trim().isEmpty()) return null;
        
        // Combinar fecha y hora
        return LocalDateTime.parse(
            fechaStr + " " + horaStr, 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        );
    }
    
    // crea funciones
    private void crearFuncion(Pelicula pelicula, Sala sala, LocalDateTime fechaHora) {
        repoFunciones.agregarFuncion(pelicula, sala, fechaHora);
        
        JOptionPane.showMessageDialog(vistaPrincipal, 
            "Función creada exitosamente.", 
            "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Actualizar ComboBox de funciones
        cargarFuncionesEnComboBox(vistaPrincipal.getComboSalasV());
    }
    
    // manejo de errores
    private void mostrarErrorCreacionFuncion(Exception e) {
        JOptionPane.showMessageDialog(vistaPrincipal, 
            "Error al crear la función: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    
    // seleccion del combox con manejo de errores
    public Funcion obtenerFuncionSeleccionada(JComboBox<String> comboBox) {
        int selectedIndex = comboBox.getSelectedIndex();
        if (selectedIndex <= 0) {
            return null;
        }
        
        String seleccion = (String) comboBox.getSelectedItem();
        String idFuncion = seleccion.split(" - ")[0];
        
        return repoFunciones.obtenerFuncionPorId(idFuncion);
    }
}