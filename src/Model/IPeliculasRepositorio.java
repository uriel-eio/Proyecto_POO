package Model;
import java.util.ArrayList;

// Ahora sí es una interfaz como sugiere su nombre
public interface IPeliculasRepositorio {
    void guardarPelicula(Pelicula pelicula);
    void creacionPeliculasPredeterminadas();
    ArrayList<Pelicula> obtenerCartelera();
    Pelicula buscarPeliculaPorTitulo(String titulo);
}