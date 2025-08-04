package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Gestor central de operaciones de persistencia en archivos
 */
public class LeerEscribir {
    
    /**
     * Guarda una línea en un archivo
     * @param ruta Ruta del archivo
     * @param linea Línea a guardar
     * @param append Si es true, añade al final; si es false, sobrescribe
     * @return true si la operación fue exitosa
     */
    public static boolean guardarLinea(String ruta, String linea, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, append))) {
            bw.write(linea);
            bw.newLine();
            return true;
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al escribir en el archivo: " + ruta, e);
            return false;
        }
    }
    
    /**
     * Guarda una lista de líneas en un archivo
     * @param ruta Ruta del archivo
     * @param lineas Lista de líneas a guardar
     * @param append Si es true, añade al final; si es false, sobrescribe
     * @return true si la operación fue exitosa
     */
    public static boolean guardarLineas(String ruta, List<String> lineas, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, append))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al escribir múltiples líneas en: " + ruta, e);
            return false;
        }
    }
    
    /**
     * Lee todas las líneas de un archivo
     * @param ruta Ruta del archivo
     * @return Lista con las líneas leídas, o lista vacía si hay error
     */
    public static List<String> leerLineas(String ruta) {
        List<String> lineas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al leer el archivo: " + ruta, e);
        }
        
        return lineas;
    }
    
    /**
     * Carga objetos desde un archivo CSV
     * @param <T> Tipo de objeto a cargar
     * @param ruta Ruta del archivo
     * @param transformador Función que convierte una línea CSV en un objeto
     * @return Lista de objetos cargados
     */
    public static <T> List<T> cargarObjetos(String ruta, Function<String, T> transformador) {
        List<T> objetos = new ArrayList<>();
        
        if (!Rutas.existeArchivo(ruta)) {
            return objetos;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                T objeto = transformador.apply(linea);
                if (objeto != null) {
                    objetos.add(objeto);
                }
            }
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al cargar objetos desde: " + ruta, e);
        }
        
        return objetos;
    }
    
    /**
     * Guarda objetos en un archivo CSV
     * @param <T> Tipo de objeto a guardar
     * @param ruta Ruta del archivo
     * @param objetos Lista de objetos a guardar
     * @param transformador Función que convierte un objeto en una línea CSV
     * @param append Si es true, añade al final; si es false, sobrescribe
     * @return true si la operación fue exitosa
     */
    public static <T> boolean guardarObjetos(String ruta, List<T> objetos, 
                                          Function<T, String> transformador, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, append))) {
            for (T objeto : objetos) {
                bw.write(transformador.apply(objeto));
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            ManejoErrores.mostrarError("Error al guardar objetos en: " + ruta, e);
            return false;
        }
    }
}