// Archivo: Funcion.java
package com.mycompany.proyectoprograii.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Funcion {
    // LA creación de IPelicula (objeto), quiere decir que el objeto debe cumplir
    // el contrato que establece la interfaz 
    private final String id;
    private final IPelicula pelicula; 
    private final ISala sala;         
    private final LocalDateTime fechaHora;
    private final List<IAsiento> asientos; 

    public Funcion(String id, IPelicula pelicula, ISala sala, LocalDateTime fechaHora) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fechaHora = fechaHora;
        this.asientos = new ArrayList<>();
        
        // Marcamos que el 20% de la sala corresponde a asientos VIP
        int capacidadTotal = sala.contarAsientosDisponibles();
        int cantidadVip = (int) (capacidadTotal * 0.20);
        //Dentro de este bucle asignamos V para VIP y E para estandar
        for (int i = 1; i <= capacidadTotal; i++) {
            if (i <= cantidadVip) {
                this.asientos.add(new AsientoVIP("V" + i, true, true));
            } else {
                this.asientos.add(new AsientoEstandar("E" + i));
            }
        }
    }
    
    public List<IAsiento> obtenerAsientosDisponibles() {
        // Creamos un array list vacio en donde guardaremos los asientos disponibles
        List<IAsiento> asientosLibres = new ArrayList<>();

        // Interamos sobre la lista actual de asientos
        // para cada asiento en asientos aplica esta condicion ...
        for (IAsiento asiento : this.asientos) {
            // Obtenemos el estado de los asientos para saber si estan reservados
            if (!asiento.obtenerEstado()) {
                asientosLibres.add(asiento);
            }
        }
        return asientosLibres;
    }


    public boolean estaDisponible() {
        // para cada asiento en asientos aplica esta condicion ...
        for (IAsiento asiento : this.asientos) {
     
            if (!asiento.obtenerEstado()) {

                return true;
            }
        }
        //Este caso es cuando todos los asientos estan llenos y no hay ninguno disponible
        System.out.println("No hay asientos disponibles!");
        return false;
    }
    

    public String getId() {
        return id;
    }

    public IPelicula getPelicula() {
        return pelicula;
    }

    public ISala getSala() {
        return sala;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public List<IAsiento> getAsientos() {
        return asientos;
    }
}