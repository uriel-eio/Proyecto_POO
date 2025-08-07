package Model;
import java.util.*;

public class OrdenCompra {
    private final int numOrden;
    private final String nombreCliente;
    private Funcion funcion; // La función para la que se compran los asientos
    private ArrayList<Asiento> asientosReservados;
    private double precioTotal;
    private boolean pagada;


    public OrdenCompra(int numOrden, Funcion funcion, ArrayList<Asiento> asientos, String nombreCliente) {
        this.numOrden = numOrden;
        this.funcion = funcion;
        this.asientosReservados = asientos;
        this.nombreCliente = nombreCliente; 
        this.pagada = false; 
        this.calcularPrecioTotal(); 
    }

    // Creamos el método que calculará el precio
    private void calcularPrecioTotal() {
        this.precioTotal = 0;
        double precioBase = 10.0; 
        for (Asiento asiento : this.asientosReservados) {
            this.precioTotal += asiento.obtenerPrecio(precioBase);
        }
    }
    
    // --- MÉTODOS PÚBLICOS (Getters y Setters) ---

    public int getNumOrden() {
        return numOrden;
    }

    public Funcion getFuncion() {
        return funcion;
    }
    
    public int getCantidadAsientos() {
        return this.asientosReservados.size();
    }
    public String getNombreCliente() {
        return nombreCliente;
    }

    public ArrayList<Asiento> getAsientosReservados() {
        return asientosReservados;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
