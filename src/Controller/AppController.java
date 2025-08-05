package Controller;

import Model.*;
import View.*;
import Util.*;

//responsable del inicio de la aplicacion
public class AppController {
    
    private final IClienteRepositorio repoClientes;
    private final IPeliculasRepositorio repoPeliculas;
    private final ISalasRepositorio repoSalas;
    
    private AuthController authController;

    public AppController() {
        this.repoPeliculas = new RepositorioPeliculas();
        this.repoSalas = new SalasRepositorio(repoPeliculas);
        this.repoClientes = new RepositorioClientes();
        
        inicializarDatos();
    }
    
    // datos predeterminados
    private void inicializarDatos() {
        try {

            Rutas.inicializarCarpetas();

            repoPeliculas.creacionPeliculasPredeterminadas();
            repoSalas.crearSala();
            ((RepositorioClientes)repoClientes).crearCliente();

            System.out.println("Cargando, por facor espere");
            repoPeliculas.obtenerCartelera();
            repoSalas.getSala();
            repoClientes.obtenerCliente();
        } catch (Exception e) {
            ManejoErrores.mostrarError("ERROR", e);
        }
    }
    
    //el login
    public void iniciarAplicacion() {
        try {
            // vista de inicio de sesión
            Inicio vistaInicio = new Inicio(null);
            authController = new AuthController(this, vistaInicio);
            vistaInicio.setControlador(authController);
            vistaInicio.setVisible(true);
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al iniciar la aplicación", e);
        }
    }
    
    // proceso despues de logearse
    public void mostrarVentanaPrincipal() {
        try {
            // crea vista principal
            Principal principal = new Principal();
            
            // controladores
            ClienteController controladorCliente = crearClienteController(principal);
            PeliculasController controladorPeliculas = crearPeliculasController(principal);
            SalasController controladorSalas = crearSalasController(principal);
            VentasController controladorVentas = new VentasController(principal, (SalasRepositorio) repoSalas);
            
            // configuracion de la vista, se le pueden hacer mejoras
            principal.setControllers(
                this, 
                controladorCliente, 
                controladorPeliculas, 
                controladorSalas, 
                controladorVentas
            );
            
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
    
    //controldor clientes
    private ClienteController crearClienteController(Principal vista) {
        ClienteController controlador = new ClienteController(repoClientes);
        controlador.setVista(vista);
        return controlador;
    }
    
    //controlador peliculas
    private PeliculasController crearPeliculasController(Principal vista) {
        return new PeliculasController(repoPeliculas, vista);
    }
    
    // controlador de salas
    private SalasController crearSalasController(Principal vista) {
        return new SalasController(repoSalas, repoPeliculas, vista);
    }
    
    // son los datos
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