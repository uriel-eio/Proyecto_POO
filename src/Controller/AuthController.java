/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Inicio;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class AuthController {
    
    //se crea una referencia al controlador principal
    private final AppController appController;
    //instancia de la vista de inicio
    private final Inicio vistaInicio;
    
    //creacion del constructor
    public AuthController(AppController appController, Inicio vistaInicio){
        this.appController = appController;
        this.vistaInicio = vistaInicio;
        
        //se asigna el evento del boton "acceder" de la vista a nuestro metodo
        this.vistaInicio.jButtonInicioSesion.addActionListener(e -> intentarLogin());
        
    }
    
    //metodo que se ejecuta cuando el usuario hace clic en el boton "acceder"
    public void intentarLogin(){
        //se obtienen los datos de los componentes de la vista
        String usuario = vistaInicio.jTextFieldUsuario.getText().trim();
        String password = new String(vistaInicio.jPasswordField.getPassword());
        
        //se realiza la validacion de las credenciales
        if ("admin".equals(usuario) && "admin".equals(password)){
            appController.mostrarVentanaPrincipal();
        }
    }
    
}
