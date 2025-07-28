package Model;

import java.util.ArrayList;

public class Sala implements ISala {
    private final String id;
    private final String nombre;
    private final int capacidad;
    private Pelicula pelicula; 
    
    private ArrayList<Asiento> asientos;

    public Sala(String id, String nombre, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pelicula = null;
        this.asientos = new ArrayList<>();
    }
    
    private void generarAsientos(){
        for (int i = 1; i <= capacidad; i++) {
            String numero = String.format("%03d", i);
            if (i % 10 == 0) { // cada 10 asientos es VIP
                asientos.add(new AsientoVIP("VIP-" + numero, true, true));
            } else {
                asientos.add(new AsientoEstandar("E-" + numero));
            }
        }
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public int getCapacidad() {
        return capacidad;
    }
    

    public Pelicula getPelicula() {
        return pelicula;
    }

    @Override
    public String obtenerId() {
        return this.id;
    }
    
    @Override
    public int contarAsientosDisponibles() {
        return this.capacidad;
    }
    @Override 
    public String getNombre() {
        return this.nombre;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    public String toCSV() {
        return this.id + "," + this.nombre + "," + this.capacidad;
    }
}
