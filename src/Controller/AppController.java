package Controller;

import Model.*;
import View.*;
import Util.*;

/**
 * Controlador principal de la aplicación
 * Responsable de iniciar la aplicación y coordinar entre controladores
 */
public class AppController {
    
    // Repositorios
    private final IClienteRepositorio repoClientes;
    private final IPeliculasRepositorio repoPeliculas;
    private final ISalasRepositorio repoSalas;
    
    // Controladores principales
    private AuthController authController;

    /**
     * Constructor principal que inicializa los repositorios básicos
     */
    public AppController() {
        // Inicializar repositorios
        this.repoPeliculas = new PeliculasRepositorio();
        this.repoSalas = new SalasRepositorio(repoPeliculas);
        this.repoClientes = new RepositorioClientes();
        
        // Inicializar datos
        inicializarDatos();
    }
    
    /**
     * Inicializa los datos predeterminados en los repositorios
     */
    private void inicializarDatos() {
        try {
            // Primero crear carpeta de datos si no existe
            Rutas.inicializarCarpetas();

            // Luego crear archivos si no existen
            repoPeliculas.creacionPeliculasPredeterminadas();
            repoSalas.crearSala();
            ((RepositorioClientes)repoClientes).crearCliente();

            // Ahora explícitamente cargar los datos existentes
            System.out.println("Cargando datos existentes...");
            repoPeliculas.obtenerCartelera();
            repoSalas.getSala();
            repoClientes.obtenerCliente();
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al inicializar datos", e);
        }
    }
    
    /**
     * Inicia la aplicación mostrando la pantalla de login
     */
    public void iniciarAplicacion() {
        try {
            // Crear y mostrar la vista de inicio de sesión
            Inicio vistaInicio = new Inicio(null);
            authController = new AuthController(this, vistaInicio);
            vistaInicio.setControlador(authController);
            vistaInicio.setVisible(true);
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al iniciar la aplicación", e);
        }
    }
    
    /**
     * Muestra la ventana principal de la aplicación
     * Llamado por AuthController después de login exitoso
     */
    public void mostrarVentanaPrincipal() {
        try {
            // Crear vista principal
            Principal principal = new Principal();
            
            // Crear controladores específicos
            ClienteController controladorCliente = crearClienteController(principal);
            PeliculasController controladorPeliculas = crearPeliculasController(principal);
            SalasController controladorSalas = crearSalasController(principal);
            VentasController controladorVentas = new VentasController(principal, (SalasRepositorio) repoSalas);
            
            // Configurar vista con controladores
            principal.setControllers(
                this, 
                controladorCliente, 
                controladorPeliculas, 
                controladorSalas, 
                controladorVentas
            );
            
            // Cargar datos iniciales en la vista
            inicializarVistaPrincipal(
                principal, 
                controladorCliente, 
                controladorPeliculas, 
                controladorSalas
            );
            
            principal.setVisible(true);
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al mostrar la ventana principal", e);
        }
    }
    
    /**
     * Crea el controlador de clientes
     */
    private ClienteController crearClienteController(Principal vista) {
        ClienteController controlador = new ClienteController(repoClientes);
        controlador.setVista(vista);
        return controlador;
    }
    
    /**
     * Crea el controlador de películas
     */
    private PeliculasController crearPeliculasController(Principal vista) {
        return new PeliculasController(repoPeliculas, vista);
    }
    
    /**
     * Crea el controlador de salas
     */
    private SalasController crearSalasController(Principal vista) {
        return new SalasController(repoSalas, repoPeliculas, vista);
    }
    
    /**
     * Inicializa los datos en la vista principal
     */
    private void inicializarVistaPrincipal(
            Principal vista, 
            ClienteController controladorCliente, 
            PeliculasController controladorPeliculas, 
            SalasController controladorSalas) {
        
        controladorCliente.iniciarTablaClientes(vista);
        controladorCliente.cargarClientesEnVista();
        controladorPeliculas.cargarPeliculasEnVista();
        controladorSalas.iniciarDatosDeSalaEnVista();
    }
}