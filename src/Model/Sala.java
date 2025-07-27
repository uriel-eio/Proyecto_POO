package Model;

public class Sala implements ISala {
    private final String id;
    private final String nombre;
    private final int capacidad;
    private Pelicula pelicula; 

    public Sala(String id, String nombre, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pelicula = null;
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
        // Devuelve id, nombre y capacidad, que son los datos que el repositorio lee y escribe.
        return this.id + "," + this.nombre + "," + this.capacidad;
    }
}
