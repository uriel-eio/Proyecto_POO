package Controller;

import View.Inicio;
import Util.ManejoErrores;

/**
 * Controlador para la autenticación de usuarios
 */
public class AuthController {
    
    // Referencia al controlador principal
    private final AppController appController;
    // Vista de inicio de sesión
    private final Inicio vistaInicio;
    
    /**
     * Constructor
     */
    public AuthController(AppController appController, Inicio vistaInicio) {
        this.appController = appController;
        this.vistaInicio = vistaInicio;
    }
    
    /**
     * Intenta realizar el login con las credenciales ingresadas
     */
    public void intentarLogin() {
        try {
            // Obtener datos de los componentes de la vista
            String usuario = vistaInicio.jTextFieldUsuario.getText().trim();
            String password = new String(vistaInicio.jPasswordField.getPassword());
            
            // Validar credenciales
            if (validarCredenciales(usuario, password)) {
                // Cerrar ventana de login
                cerrarVentanaLogin();
                
                // Mostrar ventana principal
                appController.mostrarVentanaPrincipal();
            } else {
                ManejoErrores.mostrarAdvertencia(
                    "Usuario o contraseña incorrectos", 
                    "Error de autenticación", 
                    vistaInicio
                );
            }
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error durante el inicio de sesión", e, vistaInicio);
        }
    }
    
    /**
     * Valida las credenciales del usuario
     */
    private boolean validarCredenciales(String usuario, String password) {
        // En una aplicación real, esto consultaría una base de datos
        return "admin".equals(usuario) && "admin".equals(password);
    }
    
    /**
     * Cierra la ventana de login
     */
    private void cerrarVentanaLogin() {
        vistaInicio.setVisible(false);
        vistaInicio.dispose();
    }
}