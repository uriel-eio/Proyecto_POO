/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
/**
 *
 * @author usuario
 */
public class OrdenCompra {
    private final int numOrden;
    private Funcion funcion; // La función para la que se compran los asientos
    private ArrayList<Asiento> asientosReservados;
    private double precioTotal;
    private boolean pagada;


    public OrdenCompra(int numOrden, Funcion funcion, ArrayList<Asiento> asientos) {
        this.numOrden = numOrden;
        this.funcion = funcion;
        this.asientosReservados = asientos;
        this.pagada = false; // El estado predeterminado de la orden será no pagada
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
