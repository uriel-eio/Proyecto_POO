package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LeerEscribir {
    
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
    
    // lista de archivos
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
    
    // lee las lineas
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
    
    // manda al csv
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
    
    // guarda pero un objeto
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