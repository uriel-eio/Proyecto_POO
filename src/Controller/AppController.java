package Controller;
import Model.*;
import View.*;
import javax.swing.JOptionPane;

public class AppController {
    
    //instancia de todos los repositorios
    private final RepositorioPeliculas repPeliculas;
    private final RepositorioSalas repSalas;
    private final RepositorioClientes repClientes;
    
    //instancia de todos los controladores especialistas
    private AuthController authController;
    private ClienteController controladorCliente;
    private PeliculasController controladorPeliculas;
    private SalasController controladorSalas;
    private VentasController controladorVentas;
    
    //instancia de las vistas principales
    private Inicio vistaInicio;
    private Principal principal;
    
    /*public void iniciarPrograma(){
        Inicio vistaInicio = new Inicio(this);
        vistaInicio.setVisible(true);
    }*/
    //creacion del constructor
    public AppController(){
        //se instancia cada repositorio
        this.repPeliculas = new RepositorioPeliculas();
        this.repSalas = new RepositorioSalas(this.repPeliculas); 
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
        
        //se pasa el controlador creado a la vista de vistaInicio
        this.vistaInicio.setControlador(this.authController); 
        this.vistaInicio.setVisible(true);
    }//Añadir al constructor peliculas
    public void setControllers(ClienteController cliente, 
            SalasController salas, PeliculasController peliculas, VentasController ventas) {
        this.controladorCliente = cliente;
        this.controladorPeliculas = peliculas;
        this.controladorSalas = salas;
        this.controladorVentas = ventas;
    }
    
    //se oculta el login y construye la ventana principal con los controladores
    public void mostrarVentanaPrincipal(){
        this.vistaInicio.dispose(); //se oculta la ventana del login

        //se crea la vista principal
        this.principal = new Principal();

        //se crean los controladores especialistas
        this.controladorCliente = new ClienteController(repClientes, principal);
        this.controladorPeliculas = new PeliculasController(repPeliculas, principal);
        this.controladorSalas = new SalasController(repSalas, repPeliculas, principal);
        this.controladorVentas = new VentasController(repClientes, repSalas, principal);  // <-- Aquí la corrección

        //instancias de los controladores a la vista previa
        //para que los botones funcionen
        principal.setControllers(controladorCliente, controladorPeliculas, controladorSalas, controladorVentas);

        // INICIALIZA TABLA DE CLIENTES Y LA CARGA
        this.controladorCliente.iniciarTablaClientes(principal);
        this.controladorCliente.cargarClientesEnVista();

        //carga los datos en las tablas de la vista
        this.controladorPeliculas.obtenerCartelera();
        this.controladorSalas.iniciarDatosDeSalaEnVista();
        this.controladorPeliculas.cargarPeliculasEnVista();

        //se muestra la ventana principal
        principal.setVisible(true);
    }
    
}
