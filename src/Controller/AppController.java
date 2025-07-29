package Controller;
import Model.*;
import View.*;

public class AppController {
    
    //instancia de todos los repositorios
    private final RepositorioPeliculas repPeliculas;
    private final RepositorioSalas repSalas;
    private final RepositorioClientes repClientes;
    
    //instancia de todos los controladores especialistas
    private AuthController authController;
    private ClienteController controladorCliente;
    //private PeliculasController peliculasController;
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
        
        
        iniciarDatos();       
    }
    
    public void iniciarDatos(){
        repPeliculas.creacionPeliculasPredeterminadas();
        repSalas.crearSala();
        repClientes.crearCliente();
    }
    //crea el flujo de autenticacion mostrando la ventana del login
    public void iniciarAplicacion(){
        this.vistaInicio = new Inicio(null);
        
        //se crea el AuthController
        this.authController = new AuthController(this, vistaInicio);
        
        //se pasa el controlador creado a la vista de inicio
        this.vistaInicio.setControlador(this.authController); 
        this.vistaInicio.setVisible(true);
    }//Añadir al constructor peliculas
    public void setControllers(ClienteController cliente, 
            SalasController salas, VentasController ventas) {
        this.controladorCliente = cliente;
        //this.peliculasController = peliculas;
        this.salasController = salas;
        this.ventasController = ventas;
    }
    
    //se oculta el login y construye la ventana principal con los controladores
    public void mostrarVentanaPrincipal(){
        this.vistaInicio.dispose(); //se oculta la ventana del login
        
        //se crea la vista principal
        this.vistaPrincipal = new Principal();
        
        //se crean los controladores especialistas
        /*this.controladorCliente = new ClienteController(repClientes, vistaPrincipal);
        this.peliculasController = new PeliculasController(repPeliculas, vistaPrincipal);
        this.salasController = new SalasController(repSalas, repPeliculas, vistaPrincipal);
        this.ventasController = new VentasController(repClientes, vistaPrincipal);*/
        
        //instancias de los controladores a la vista previa
        //para que los botones funcionen
        vistaPrincipal.setControllers(controladorCliente, peliculasController, salasController, ventasController);
        
        //carga los datos en las tablas de la vista
        this.controladorCliente.cargarClientesEnVista();
        //this.peliculasController.cargarPeliculasEnVista();
        this.salasController.cargarDatosDeSalas();
        
        //se muestra la ventana principal
        vistaPrincipal.setVisible(true);
    }
    
}
