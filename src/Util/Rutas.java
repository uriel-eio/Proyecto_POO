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
        
        // Imprimir rutas absolutas para diagnóstico
        System.out.println("Rutas inicializadas:");
        System.out.println("- Carpeta de datos: " + new File(CARPETA_DATOS).getAbsolutePath());
        System.out.println("- Carpeta de imágenes: " + new File(CARPETA_IMAGENES).getAbsolutePath());
        System.out.println("- Ruta de películas: " + new File(RUTA_PELICULAS).getAbsolutePath());
        System.out.println("- Ruta de salas: " + new File(RUTA_SALAS).getAbsolutePath());
        System.out.println("- Ruta de clientes: " + new File(RUTA_CLIENTES).getAbsolutePath());
        
        // Verificar existencia de archivos
        System.out.println("Verificando existencia de archivos:");
        System.out.println("- ¿Existe archivo de películas?: " + existeArchivo(RUTA_PELICULAS));
        System.out.println("- ¿Existe archivo de salas?: " + existeArchivo(RUTA_SALAS));
        System.out.println("- ¿Existe archivo de clientes?: " + existeArchivo(RUTA_CLIENTES));
    }
    
    /**
     * Crea una carpeta si no existe
     */
    private static void crearCarpetaSiNoExiste(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdirs();
            if (creada) {
                System.out.println("Carpeta creada: " + ruta);
            } else {
                System.err.println("No se pudo crear la carpeta: " + ruta);
            }
        } else {
            System.out.println("Carpeta ya existe: " + ruta);
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