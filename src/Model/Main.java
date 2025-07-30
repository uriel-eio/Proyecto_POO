package Model;

import Controller.AppController;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Asegurarnos de arrancar la interfaz en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            AppController app = new AppController();
            app.iniciarAplicacion();
        });
    }
}
