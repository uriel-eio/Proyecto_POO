package Model;

public interface IPelicula {
    String obtenerTitulo();
    String obtenerGenero();
    int obtenerDuracion();
    RestriccionesEdad obtenerRestriccionEdad();
}