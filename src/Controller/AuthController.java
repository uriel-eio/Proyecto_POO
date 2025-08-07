package Controller;

import View.Inicio;
import Util.ManejoErrores;

public class AuthController {
    
    private final AppController appController;
    private final Inicio vistaInicio;
    
    public AuthController(AppController appController, Inicio vistaInicio) {
        this.appController = appController;
        this.vistaInicio = vistaInicio;
    }
    
    // login
    public void intentarLogin() {
        try {
            // Obtener datos de los componentes de la vista
            String usuario = vistaInicio.jTextFieldUsuario.getText().trim();
            String password = new String(vistaInicio.jPasswordField.getPassword());
            
            // Validar credenciales
            if (validarCredenciales(usuario, password)) {

                cerrarVentanaLogin();
                
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
    
    //validacion
    private boolean validarCredenciales(String usuario, String password) {
        return "admin".equals(usuario) && "admin".equals(password);
    }
    
    private void cerrarVentanaLogin() {
        vistaInicio.setVisible(false);
        vistaInicio.dispose();
    }
}