package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPeliculas {
    
    private static final String ARCHIVO_PELICULAS = "peliculas.txt";
    //PELICULAS EN CARTELERA:
    Pelicula matrix = new Pelicula("p001", "Matrix", "Ciencia Ficción", 148, RestriccionesEdad.B, "Matrix.jpg");
    Pelicula kimetsu = new Pelicula("p002", "Kimetsu no yaiba", "Animación", 169, RestriccionesEdad.B, "Kimetsu.jpeg");
    Pelicula superman = new Pelicula("p003", "Superman", "Superheroes", 175, RestriccionesEdad.A, "Superman.jpg");
    Pelicula deadpool = new Pelicula("p004", "Deadpool", "acción", 120, RestriccionesEdad.C, "Deadpool.png");

    // método tentativo a utilizar para agregar una nueva película 
    public void guardarPelicula(Pelicula pelicula){
        //Creo el archivo txt y le escribo todas las películas que le lleguen
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_PELICULAS, true))){
            bw.write(pelicula.toCSV());
            bw.newLine();
        } catch(IOException e){
            System.err.println("Error al guardar la película: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Método con películas predeterminadas 
    public void creacionPeliculasPredeterminadas(){
        File archivo = new File(ARCHIVO_PELICULAS);
            if(archivo.exists()){
                return;
            }
        System.out.println("Obteniendo cartelera...");
        // List.of simplifica el 
        ArrayList<Pelicula> peliculasPredeterminadas = new ArrayList<>();
        peliculasPredeterminadas.add(matrix);
        peliculasPredeterminadas.add(kimetsu);
        peliculasPredeterminadas.add(superman);
        peliculasPredeterminadas.add(deadpool);
        
        
        // Bucle para que la función guarde todas las películas 1 a 1
        for(Pelicula pelicula: peliculasPredeterminadas){
            this.guardarPelicula(pelicula);
        }
    }
    // Método para leer el archivo de las películas 
    // Es de tipo ArrayList, para que me devuelva una lista
    
    public ArrayList<Pelicula> obtenerCartelera(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        
        //br.ReadLine lee una linea completa del archivo, entonces
        // mientras no sea una linea en blanco procede
        try(BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PELICULAS))){
            String linea; 
            while((linea = br.readLine()) != null){
                // Creo un arreglo que contendrá cada linea del archivo películas 
                // separado por una coma
                String[] datos = linea.split(",");
                // Si llega al final de los datos (porque cada pelicula tiene 6 datos
                
                if(datos.length == 6){
                    // se le añade a nuestro ArrayList cada dato del archivo
                    peliculas.add(new Pelicula(datos[0],
                            datos[1], 
                            datos[2], 
                            Integer.parseInt(datos[3]), 
                            RestriccionesEdad.valueOf(datos[4]),
                            datos[5]));

                }
            }
            
        } catch(IOException | NumberFormatException e){
            System.out.println("Error procesando el archivo!");
        }
        return peliculas;
    }
       
        //es un buscasdor por titulo, lo voy a  usar en el Controlador de la Sala
    public Pelicula buscarPeliculaPorTitulo(String tituloPelicula) { //metodo a partir de pelicula
            //voy a buscar en el Array
        for (Pelicula c : obtenerCartelera()) { //metodo del array 
            if (c.obtenerTitulo() == tituloPelicula) return c; //validacion
        }
        return null;
    }

    
}
