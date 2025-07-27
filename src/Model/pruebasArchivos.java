/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;
import Model.Pelicula;
import Model.RepositorioPeliculas;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class pruebasArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// 1. Creamos una instancia de nuestro repositorio.
        RepositorioPeliculas miRepositorio = new RepositorioPeliculas();

        System.out.println("--- PRUEBA 1: INICIALIZACIÓN DE DATOS ---");
        // 2. Llamamos al método que crea el archivo con las películas predeterminadas.
        // Si el archivo ya existe, este método no hará nada.
        miRepositorio.creacionPeliculasPredeterminadas();

        System.out.println("\n--- PRUEBA 2: LECTURA DE DATOS INICIALES ---");
        // 3. Leemos la cartelera desde el archivo.
        ArrayList<Pelicula> cartelera = miRepositorio.obtenerCartelera();

        // 4. Imprimimos los resultados para verificar que la lectura fue exitosa.
        System.out.println("Se encontraron " + cartelera.size() + " películas en cartelera:");
        for (Pelicula p : cartelera) {
            System.out.println("  -> Título: " + p.obtenerTitulo());
        }

        System.out.println("\n--- PRUEBA 3: GUARDAR UNA NUEVA PELÍCULA ---");
        // 5. Creamos una nueva película y la guardamos.
        Pelicula nuevaPelicula = new Pelicula("p005", "Dune: Parte 2", "Ciencia Ficción", 166, RestriccionesEdad.B);
        System.out.println("Guardando nueva película: " + nuevaPelicula.obtenerTitulo());
        miRepositorio.guardarPelicula(nuevaPelicula);

        System.out.println("\n--- PRUEBA 4: LECTURA DE DATOS ACTUALIZADOS ---");
        // 6. Volvemos a leer la cartelera para ver si la nueva película fue añadida.
        ArrayList<Pelicula> carteleraActualizada = miRepositorio.obtenerCartelera();
        System.out.println("Ahora se encontraron " + carteleraActualizada.size() + " películas en cartelera:");
        for (Pelicula p : carteleraActualizada) {
            System.out.println("  -> Título: " + p.obtenerTitulo());
        }    
    }
    
}
