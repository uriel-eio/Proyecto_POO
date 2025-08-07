package Model;
import java.util.ArrayList;

public interface IPeliculasRepositorio {
    void guardarPelicula(Pelicula pelicula);
    void creacionPeliculasPredeterminadas();
    ArrayList<Pelicula> obtenerCartelera();
    Pelicula buscarPeliculaPorTitulo(String titulo);
}