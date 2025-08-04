package Util;

import java.io.File;

/**
 * Clase de configuración central para la aplicación
 * Contiene constantes de configuración y rutas de archivos
 */
public class Rutas {
    
    // Carpeta de datos
    public static final String CARPETA_DATOS = "datos";
    
    // Rutas de archivos
    public static final String RUTA_CLIENTES = CARPETA_DATOS + File.separator + "clientes.txt";
    public static final String RUTA_PELICULAS = CARPETA_DATOS + File.separator + "peliculas.txt";
    public static final String RUTA_SALAS = CARPETA_DATOS + File.separator + "lista_salas.txt";
    public static final String RUTA_FUNCIONES = CARPETA_DATOS + File.separator + "funciones.txt";
    
    // Carpeta de imágenes
    public static final String CARPETA_IMAGENES = "src" + File.separator + "images";
    
    /**
     * Inicializa las carpetas necesarias para la aplicación
     */
    public static void inicializarCarpetas() {
        crearCarpetaSiNoExiste(CARPETA_DATOS);
        crearCarpetaSiNoExiste(CARPETA_IMAGENES);
    }
    
    /**
     * Crea una carpeta si no existe
     */
    private static void crearCarpetaSiNoExiste(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdirs();
            if (!creada) {
                System.err.println("No se pudo crear la carpeta: " + ruta);
            }
        }
    }
    
    /**
     * Verifica si un archivo existe
     */
    public static boolean existeArchivo(String ruta) {
        File archivo = new File(ruta);
        return archivo.exists() && archivo.isFile();
    }
    
    /**
     * Obtiene la ruta completa a un archivo de imagen
     */
    public static String getRutaImagen(String nombreImagen) {
        return CARPETA_IMAGENES + File.separator + nombreImagen;
    }
}