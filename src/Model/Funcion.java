package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Funcion {
    private final String id;
    private final Pelicula pelicula; 
    private final Sala sala;         
    private final LocalDateTime fechaHora;
    private ArrayList<Asiento> asientosDisponibles;

    public Funcion(String id, Pelicula pelicula, Sala sala, LocalDateTime fechaHora) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fechaHora = fechaHora;
        this.asientosDisponibles = new ArrayList<>(sala.getAsientos());
    }

    public String getId() {
        return id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public ArrayList<Asiento> getAsientosDisponibles() {
        ArrayList<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientosDisponibles) {
            if (!asiento.obtenerEstado()) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }
    
    public boolean tieneAsientosDisponibles() {
        return !getAsientosDisponibles().isEmpty();
    }
    
    public void reservarAsiento(Asiento asiento) {
        for (Asiento a : asientosDisponibles) {
            if (a.obtenerNumero().equals(asiento.obtenerNumero())) {
                a.reservar();
                break;
            }
        }
    }
}