package Controller;

import Model.Sala;
import Model.Asiento;
import View.SelecAsientos;
import javax.swing.JButton;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;
import Model.Cliente;
import Model.Funcion;
import Model.FuncionesRepositorio;
import Model.IFuncionesRepositorio;
import Model.Pelicula;
import Model.RepositorioClientes;
import Model.RepositorioPeliculas;
import Model.SalasRepositorio;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Controlador para la gestión de la selección de asientos
 */
public class AsientosController {
    private static final Logger LOGGER = Logger.getLogger(AsientosController.class.getName());
    
    // Referencias al modelo y vista
    private final Sala sala;
    private final SelecAsientos vista;
    private final boolean isVip;
    private final VentasController ventasController; 

    
    // Lista para mantener registro de asientos seleccionados
    private final ArrayList<Asiento> asientosSeleccionados = new ArrayList<>();
    
    // Mapa para relacionar botones con asientos (facilita acceso bidireccional)
    private final Map<JButton, Asiento> mapaBotonAsiento = new HashMap<>();

    /**
     * Constructor que inicializa el controlador
     */
    public AsientosController(Sala sala, SelecAsientos vista, boolean isVip, VentasController ventasController) {
        this.sala = sala;
        this.vista = vista;
        this.isVip = isVip;
        this.ventasController = ventasController; 
        configurarVista();
        generarAsientos();
        
        LOGGER.info("Controlador de asientos inicializado para sala: " + sala.getNombre());
    }

    /**
     * Configuración inicial de la vista
     */
    private void configurarVista() {
        vista.setTitle("Selección de Asientos - " + sala.getNombre());
    }

    /**
     * Genera los botones de asientos en la vista
     */
    private void generarAsientos() {
        vista.getPanelAsientos().removeAll();
        asientosSeleccionados.clear();
        mapaBotonAsiento.clear();
        
        // Configuración de layout
        //int columnas = 10;
        int capacidad = sala.getCapacidad();
        int columnas = calcularColumnas(capacidad);
        vista.getPanelAsientos().setLayout(new GridLayout(0, columnas, 5, 5));

        // Crear botones para cada asiento
        for (Asiento asiento : sala.getAsientos()) {
            // Filtrar según tipo VIP/Estándar
            if ((isVip && asiento.isVIP()) || (!isVip && !asiento.isVIP())) {
                JButton btn = crearBotonAsiento(asiento);
                vista.getPanelAsientos().add(btn);
                mapaBotonAsiento.put(btn, asiento);
            }
        }
        
        vista.getPanelAsientos().revalidate();
        vista.getPanelAsientos().repaint();
    }
    
    //Método para que aparezcan los asientos según la capacidad de la sala
    private int calcularColumnas(int capacidad) {
        
        if (capacidad <= 10) {
            return 5;       // 5 columnas para salas pequeñas
        }
        if (capacidad == 20) {
            return 5;       // 5x4 para 20 asientos
        }
        if (capacidad == 25) {
            return 5;       // 5x5 para 25 asientos
        }
        return 10;                           // Default: 10 columnas
    }

    /**
     * Crea un botón de asiento con su comportamiento
     */
    private JButton crearBotonAsiento(Asiento asiento) {
        JButton btn = new JButton(asiento.obtenerNumero());
        
        // Estilo visual inicial
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        
        // Configurar apariencia según estado
        if (asiento.obtenerEstado()) {
            // Asiento ya reservado
            btn.setBackground(Color.GRAY);
            btn.setEnabled(false);
            btn.setContentAreaFilled(true);
        } else {
            // Asiento libre
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(true);
            
            // Acción al hacer clic
            btn.addActionListener(e -> manejarSeleccionAsiento(btn, asiento));
        }
        
        return btn;
    }
    
    /**
     * Maneja la selección/deselección de un asiento
     */
    private void manejarSeleccionAsiento(JButton btn, Asiento asiento) {
        // Revisa si el asiento ya está en la lista de selección temporal
        if (asientosSeleccionados.contains(asiento)) {
            // Si está, lo quitamos (Deseleccionar)
            btn.setContentAreaFilled(false);
            asientosSeleccionados.remove(asiento);
            LOGGER.info("Asiento deseleccionado: " + asiento.obtenerNumero());
        } else {
            // Si no está, lo añadimos (Seleccionar)
            btn.setContentAreaFilled(true);
            btn.setBackground(Color.WHITE);
            asientosSeleccionados.add(asiento);
            LOGGER.info("Asiento seleccionado: " + asiento.obtenerNumero());
        }
    }
    
    /**
     * Obtiene la lista de asientos seleccionados
     */
    public ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }
    
    /**
     * Guarda los asientos seleccionados en un archivo
     */
    public boolean confirmarSeleccion() {
        if (asientosSeleccionados.isEmpty()) {
            return false;
        }
        
        // Marca todos los asientos seleccionados como reservados en el modelo
        for (Asiento asiento : asientosSeleccionados) {
            asiento.reservar();
        }
        
        return true;
    }
    public void finalizarYCrearOrden() {
        ArrayList<Asiento> asientosConfirmados = getAsientosSeleccionados();

        String cedulaStr = this.ventasController.getVista().getTextFieldClienteV().getText().trim();
        if (cedulaStr.isEmpty() || "Ingrese Cédula".equals(cedulaStr)) {
            JOptionPane.showMessageDialog(this.vista, "Error: no se pudo identificar al cliente.", "Error de Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cliente cliente = new RepositorioClientes().buscarClientePorCedula(Long.parseLong(cedulaStr));
        if (cliente == null) {
            JOptionPane.showMessageDialog(this.vista, "Error: cliente no encontrado.", "Error de Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        IFuncionesRepositorio repoFunciones = new FuncionesRepositorio(new RepositorioPeliculas(), new SalasRepositorio(new RepositorioPeliculas()));

        List<Funcion> todasLasFunciones = repoFunciones.obtenerFunciones();
        Funcion funcionEncontrada = null; // Variable para guardar el resultado

        for (Funcion funcion : todasLasFunciones) {
            // Comparamos el ID de la sala de la función actual 
            if (funcion.getSala().obtenerId().equals(this.sala.obtenerId())) {
                funcionEncontrada = funcion; 
                break; 
            }
        }

        if (funcionEncontrada == null) {
            Pelicula peliculaDeLaSala = this.sala.getPelicula();

            if (peliculaDeLaSala == null) {
                JOptionPane.showMessageDialog(this.vista, "Error: La sala seleccionada no tiene una película asignada.", "Error de Película", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LocalDateTime fechaHoraActual = LocalDateTime.now();
            repoFunciones.agregarFuncion(peliculaDeLaSala, this.sala, fechaHoraActual);

            // Volvemos a buscarla para asegurarnos de tener el objeto completo con su ID.
            todasLasFunciones = repoFunciones.obtenerFunciones();
            for (Funcion funcion : todasLasFunciones) {
                if (funcion.getSala().obtenerId().equals(this.sala.obtenerId()) && funcion.getPelicula().getId().equals(peliculaDeLaSala.getId())) {
                    funcionEncontrada = funcion;
                    break;
                }
            }

            if (funcionEncontrada == null) {
                JOptionPane.showMessageDialog(this.vista, "Error crítico: No se pudo crear ni encontrar la función para la sala.", "Error de Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // 4. Con la 'funcionEncontrada' garantizada, llamamos al VentasController.
        this.ventasController.crearNuevaOrden(cliente, funcionEncontrada, asientosConfirmados);
    }
}