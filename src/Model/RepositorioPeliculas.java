package Model;

import Util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RepositorioPeliculas implements IPeliculasRepositorio {
    
    //cartelera 
    Pelicula matrix = new Pelicula("p001", "Matrix", "Ciencia Ficción", 148, RestriccionesEdad.B, "Matrix.jpg");
    Pelicula kimetsu = new Pelicula("p002", "Kimetsu no yaiba", "Animación", 169, RestriccionesEdad.B, "Kimetsu.jpeg");
    Pelicula superman = new Pelicula("p003", "Superman", "Superheroes", 175, RestriccionesEdad.A, "Superman.jpg");
    Pelicula deadpool = new Pelicula("p004", "Deadpool", "acción", 120, RestriccionesEdad.C, "Deadpool.png");

    @Override
    public void guardarPelicula(Pelicula pelicula){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Rutas.RUTA_PELICULAS, true))){
            bw.write(pelicula.toCSV());
            bw.newLine();
        } catch(IOException e){
            System.err.println("Error al guardar la película: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public void creacionPeliculasPredeterminadas(){
        if (Rutas.existeArchivo(Rutas.RUTA_PELICULAS)) {
            return;
        }
        
        System.out.println("Obteniendo cartelera...");
        ArrayList<Pelicula> peliculasPredeterminadas = new ArrayList<>();
        peliculasPredeterminadas.add(matrix);
        peliculasPredeterminadas.add(kimetsu);
        peliculasPredeterminadas.add(superman);
        peliculasPredeterminadas.add(deadpool);
        
        for(Pelicula pelicula: peliculasPredeterminadas){
            this.guardarPelicula(pelicula);
        }
    }

    @Override
    public ArrayList<Pelicula> obtenerCartelera(){
        Function<String, Pelicula> transformador = linea -> {
            String[] datos = linea.split(",");
            if (datos.length == 6) {
                try {
                    return new Pelicula(
                        datos[0],
                        datos[1],
                        datos[2],
                        Integer.parseInt(datos[3]),
                        RestriccionesEdad.valueOf(datos[4]),
                        datos[5]
                    );
                } catch (IllegalArgumentException e) {
                    ManejoErrores.mostrarError("Error al procesar película: " + linea, e);
                }
            }
            return null;
        };
        
        List<Pelicula> peliculas = LeerEscribir.cargarObjetos(
            Rutas.RUTA_PELICULAS,
            transformador
        );
        
        return new ArrayList<>(peliculas);
    }
       
    @Override
    public Pelicula buscarPeliculaPorTitulo(String titulo) {
        for (Pelicula p : obtenerCartelera()) {
            System.out.println("Comparando con: '" + p.obtenerTitulo()+ "'");
            //trim busca sin espacios
            if (p.obtenerTitulo().equalsIgnoreCase(titulo.trim())) {
                return p;
            }
        }
        return null;
    }
}