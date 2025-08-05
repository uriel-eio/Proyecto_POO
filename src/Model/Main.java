package Model;

import Controller.AppController;
import javax.swing.SwingUtilities;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {

        // Iniciar aplicación
        SwingUtilities.invokeLater(() -> {
            AppController app = new AppController();
            app.iniciarAplicacion();
        });
    }
}