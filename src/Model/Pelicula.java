package Model;

public class Pelicula implements IPelicula {
    // Hacemos los atributos 'final' para garantizar la inmutabilidad
    private final String id;
    private final String titulo;
    private final String genero;
    private final int duracion;
    private final RestriccionesEdad restriccionEdad; 

    public Pelicula(String id, String titulo, String genero, int duracion, RestriccionesEdad restriccionEdad) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.restriccionEdad = restriccionEdad;
    }

    
    public String getId() {
        return id;
    }

    @Override
    public String obtenerTitulo() {
        return titulo;
    }

    @Override
    public String obtenerGenero() {
        return genero;
    }

    @Override
    public int obtenerDuracion() {
        return duracion;
    }

    @Override
    public RestriccionesEdad obtenerRestriccionEdad() { // <-- CAMBIO CLAVE
        return restriccionEdad;
    }
    
    
    // Creado para el manejo de archivos, se separa en comas para simular un archivo csv
    public String toCSV() {
    return this.id + "," +
           this.titulo + "," +
           this.genero + "," +
           this.duracion + "," +
           this.restriccionEdad.name(); // .name() convierte el enum a String
    }
}

