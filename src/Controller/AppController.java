/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;

/**
 *
 * @author USER
 */
public class AppController {
    
    //instancia de todos los repositorios
    private final RepositorioPeliculas repPeliculas;
    private final RepositorioSalas repSalas;
    private final RepositorioClientes repClientes;
    
    //instancia de todos los controladores especialistas
    private AuthController authController;
    private ClientesController clientesController;
    private PeliculasController peliculasController;
    private SalasController salasController;
    private VentasController ventasController;
    
    //instancia de las vistas principales
    private Inicio vistaInicio;
    private Principal vistaPrincipal;
    
    //creacion del constructor
    public AppController(){
        //se instancia cada repositorio
        this.repPeliculas = new RepositorioPeliculas();
        this.repSalas = new RepositorioSalas();
        this.repClientes = new RepositorioClientes();
        
        //se llama a los metodos de inicializacion de cada uno
        repPeliculas.creacionPeliculasPredeterminadas();
        repSalas.crearSala();
        repClientes.obtenerCliente();
        
    }
    
    //crea el flujo de autenticacion mostrando la ventana del login
    public void iniciarAplicacion(){
        this.vistaInicio = new Inicio(null);
        
        //se crea el AuthController
        this.authController = new AuthController(this, vistaInicio);
        
        //se pasa el controlador creado a la vista de inicio
        this.vistaInicio.setControlador(this.authController);
        this.vistaInicio.setVisible(true);
    }
    
    //se oculta el login y construye la ventana principal con los controladores
    public void mostrarVentanaPrincipal(){
        this.vistaInicio.dispose(); //se oculta la ventana del login
        
        //se crea la vista principal
        this.vistaPrincipal = new Principal(null);
        
        //se crean los controladores especialistas
        this.clientesController = new ClientesController(repClientes, vistaPrincipal);
        this.peliculasController = new PeliculasController(repPeliculas, vistaPrincipal);
        this.salasController = new SalasController(repoSalas, repPeliculas, vistaPrincipal);
        this.ventasController = new VentasController(repClientes, vistaPrincipal);
        
        //instancias de los controladores a la vista previa
        //para que los botones funcionen
        vistaPrincipal.setControllers(clientesController,
                                    peliculasController,
                                    salasController,
                                    ventasController);
        
        //carga los datos en las tablas de la vista
        this.clientesController.cargarClientesEnVista();
        this.peliculasController.cargarPeliculasEnVista();
        this.salasController.cargarDatosDeSalas();
        
        //se muestra la ventana principal
        vistaPrincipal.setVisible(true);
    }
    
}
