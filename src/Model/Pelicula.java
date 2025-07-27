package Model;

public class Pelicula implements IPelicula {
    // Hacemos los atributos 'final' para garantizar la inmutabilidad
    private final String id;
    private final String titulo;
    private final String genero;
    private final int duracion;
    private final RestriccionesEdad restriccionEdad; // <-- CAMBIO CLAVE

    public Pelicula(String id, String titulo, String genero, int duracion, RestriccionesEdad restriccionEdad) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.restriccionEdad = restriccionEdad;
    }

    // Sugerencia: Añadir un getter para el ID
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
}