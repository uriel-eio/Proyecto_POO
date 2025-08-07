package Model;

import java.util.ArrayList;

public class Sala implements ISala {
    private final String id;
    private final String nombre;
    private final int capacidad;
    private boolean isVIP;
    private String marcaVIP;
    private Pelicula pelicula;
    private ArrayList<Asiento> asientos;
    
    String nombrePeli;
    public Sala(String id, String nombre, int capacidad, boolean isVIP) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pelicula = null;
        this.asientos = new ArrayList<>();
        this.nombrePeli = nombrePeli;
        this.marcaVIP = marcaVIP;
        this.isVIP = isVIP;
        generarAsientos();
    }
    
    private void generarAsientos() {
        /*
        for (int i = 1; i <= capacidad; i++) {
            String numero = String.format("%03d", i);
            if (i % 10 == 0) {
                asientos.add(new AsientoVIP("VIP-" + numero, true, true));
            } else {
                asientos.add(new AsientoEstandar("E-" + numero));
            }
        }
        */
        asientos.clear(); // Limpiar lista existente
    
        for (int i = 1; i <= capacidad; i++) {
            String numero = String.format("%03d", i);

            // Si la sala es VIP, todos los asientos son VIP
            if (this.isVIP || i % 10 == 0) {
                asientos.add(new AsientoVIP("VIP-" + numero, true, true));
            } else {
                asientos.add(new AsientoEstandar("E-" + numero));
            }
        }  
    }
    
    public String getMarcaVIP() {
        if (this.isVip()) { 
            return "X";
        } else {
            return "";
        }
    }



    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isVip() {
        return isVIP;
    }

    public void setIsVIP(boolean isVIP) {
        this.isVIP = isVIP;
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
        StringBuilder estadosAsientos = new StringBuilder();
        for (Asiento asiento : this.asientos) {
            //String builder me sirve para ir concatenando strings y esto sirve 
            //es como un "if" resumido, si esta reservado es 1, si no 0
            estadosAsientos.append(asiento.obtenerEstado() ? '1' : '0');
        }

        String tituloPelicula = "Sin Asignar";
        if (this.pelicula != null) {
            tituloPelicula = this.pelicula.obtenerTitulo();
        }
        
        return this.id + "," + 
               this.nombre + "," + 
               this.capacidad + "," + 
               this.isVIP + "," + 
               tituloPelicula + "," +
               estadosAsientos.toString();
    }
}
