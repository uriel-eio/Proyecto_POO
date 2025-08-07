package Model;

import Util.ManejoErrores;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncionesRepositorio implements IFuncionesRepositorio {
    
    private static final String ARCHIVO_FUNCIONES = "funciones.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final IPeliculasRepositorio repoPeliculas;
    private final ISalasRepositorio repoSalas;
    
    public FuncionesRepositorio(IPeliculasRepositorio repoPeliculas, ISalasRepositorio repoSalas) {
        this.repoPeliculas = repoPeliculas;
        this.repoSalas = repoSalas;
        crearFuncionesPredeterminadas();
    }
    
    private void crearFuncionesPredeterminadas() {
        File archivo = new File(ARCHIVO_FUNCIONES);
        if (archivo.exists()) {
            return; 
        }

        // Método encargado de crear funciones.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_FUNCIONES))) {
            List<Pelicula> peliculas = repoPeliculas.obtenerCartelera();
            List<Sala> salas = repoSalas.getSala();
            int contadorFunciones = 0;

            if (!peliculas.isEmpty() && !salas.isEmpty()) {
                contadorFunciones++;
                LocalDateTime fecha1 = LocalDateTime.now().plusDays(1).withHour(15).withMinute(0);
                Funcion funcion1 = new Funcion("f" + contadorFunciones, peliculas.get(0), salas.get(0), fecha1);
                bw.write(funcionToCSV(funcion1));
                bw.newLine();

                if (peliculas.size() > 1 && salas.size() > 1) {
                    contadorFunciones++;
                    LocalDateTime fecha2 = LocalDateTime.now().plusDays(1).withHour(18).withMinute(30);
                    Funcion funcion2 = new Funcion("f" + contadorFunciones, peliculas.get(1), salas.get(1), fecha2);
                    bw.write(funcionToCSV(funcion2));
                    bw.newLine();
                }

                if (peliculas.size() > 2) {
                    contadorFunciones++;
                    LocalDateTime fecha3 = LocalDateTime.now().plusDays(2).withHour(20).withMinute(15);
                    Funcion funcion3 = new Funcion("f" + contadorFunciones, peliculas.get(2), salas.get(0), fecha3);
                    bw.write(funcionToCSV(funcion3));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al crear el archivo de funciones predeterminadas", e);
        }
    }
    
    @Override
    public List<Funcion> obtenerFunciones() {
        List<Funcion> funciones = new ArrayList<>();
        File archivo = new File(ARCHIVO_FUNCIONES); 

       
        if (!archivo.exists()) {
            return funciones; // se devuelve una lista vacia en caso de no existir
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String id = datos[0];
                    String idPelicula = datos[1];
                    String idSala = datos[2];
                    LocalDateTime fechaHora = LocalDateTime.parse(datos[3], FORMATTER);

                    Pelicula pelicula = buscarPeliculaPorId(idPelicula);
                    Sala sala = repoSalas.buscarSalaPorId(idSala);

                    if (pelicula != null && sala != null) {
                        funciones.add(new Funcion(id, pelicula, sala, fechaHora));
                    }
                }
            }
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al leer el archivo de funciones", e);
        }

        return funciones;
    }
    
    private Pelicula buscarPeliculaPorId(String id) {
        for (Pelicula p : repoPeliculas.obtenerCartelera()) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public Funcion obtenerFuncionPorId(String id) {
        for (Funcion funcion : obtenerFunciones()) {
            if (funcion.getId().equals(id)) {
                return funcion;
            }
        }
        return null;
    }
    
    @Override
    public void agregarFuncion(Funcion funcion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_FUNCIONES, true))) {
            bw.write(funcionToCSV(funcion));
            bw.newLine();
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al guardar la función", e);
        }
    }
    
    @Override
    public void agregarFuncion(Pelicula pelicula, Sala sala, LocalDateTime fechaHora) {
        // Generar un ID único para la nueva función
        String id = "f" + (obtenerFunciones().size() + 1);
        Funcion nuevaFuncion = new Funcion(id, pelicula, sala, fechaHora);
        agregarFuncion(nuevaFuncion);
    }
    
    private String funcionToCSV(Funcion funcion) {
        return funcion.getId() + "," +
               funcion.getPelicula().getId() + "," +
               funcion.getSala().obtenerId() + "," +
               funcion.getFechaHora().format(FORMATTER);
    }
    
    @Override
    public boolean actualizarFuncion(Funcion funcionActualizada) {
        List<Funcion> funciones = obtenerFunciones();
        boolean encontrada = false;
        
        // Buscar la función por ID y actualizarla
        for (int i = 0; i < funciones.size(); i++) {
            if (funciones.get(i).getId().equals(funcionActualizada.getId())) {
                funciones.set(i, funcionActualizada);
                encontrada = true;
                break;
            }
        }
        
        if (encontrada) {
            // Reescribir todo el archivo con la función actualizada
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_FUNCIONES))) {
                for (Funcion f : funciones) {
                    bw.write(funcionToCSV(f));
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                ManejoErrores.mostrarError("Error al actualizar la función", e);
            }
        }
        
        return false;
    }
    
    @Override
    public boolean eliminarFuncion(String id) {
        List<Funcion> funciones = obtenerFunciones();
        boolean encontrada = false;
        
        // Buscar y eliminar la función por ID
        for (int i = 0; i < funciones.size(); i++) {
            if (funciones.get(i).getId().equals(id)) {
                funciones.remove(i);
                encontrada = true;
                break;
            }
        }
        
        if (encontrada) {
            // Reescribir todo el archivo sin la función eliminada
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_FUNCIONES))) {
                for (Funcion f : funciones) {
                    bw.write(funcionToCSV(f));
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                ManejoErrores.mostrarError("Error al eliminar la función", e);
            }
        }
        
        return false;
    }
}