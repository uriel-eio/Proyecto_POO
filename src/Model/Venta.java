package Model;

import java.util.Date;

/**
 * Clase modelo que representa una venta
 * Principio de Responsabilidad Única: Contiene solo datos básicos de ventas
 */
public class Venta {
    private int id;
    private Date fecha;
    private int clienteId;
    private double total;
    
    public Venta(int id, Date fecha, int clienteId, double total) {
        this.id = id;
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.total = total;
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public int getClienteId() {
        return clienteId;
    }
    
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
}