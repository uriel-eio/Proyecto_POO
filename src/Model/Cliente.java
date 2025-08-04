package Model;

public class Cliente {
    
    private long cedula;
    private String nombre;
    private String telefono;
    private CarritoModelo carritoModel;
    
    // Constructor completo
    public Cliente(long cedula, String nombre, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        // No inicializamos carritoModel aquí para evitar acoplamiento
    }
    
    // --- Getters y Setters ---
    public long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CarritoModelo getCarritoModel() {
        return carritoModel;
    }
    
    public void setCarritoModel(CarritoModelo carritoModel) {
        this.carritoModel = carritoModel;
    }

    public String toCSV() {
        return this.cedula + "," + this.nombre + "," + this.telefono;
    }
}