package Util;

import java.io.File;

public class Rutas {
    
    //en caso de errores por carpetas, se puede borrar si quieren simplifica
    private static final boolean USAR_CARPETA_DATOS = false;
    
    private static final String NOMBRE_ARCHIVO_CLIENTES = "clientes.txt";
    private static final String NOMBRE_ARCHIVO_PELICULAS = "peliculas.txt";
    private static final String NOMBRE_ARCHIVO_SALAS = "lista_salas.txt";
    private static final String NOMBRE_ARCHIVO_FUNCIONES = "funciones.txt";
    private static final String NOMBRE_ARCHIVO_ASIENTOS = "confirmarAsientos.csv";
    private static final String NOMBRE_CARPETA_DATOS = "datos";
    private static final String NOMBRE_CARPETA_IMAGENES = "src" + File.separator + "images";
    
    
    public static final String RUTA_CLIENTES = USAR_CARPETA_DATOS ? 
            NOMBRE_CARPETA_DATOS + File.separator + NOMBRE_ARCHIVO_CLIENTES : NOMBRE_ARCHIVO_CLIENTES;
    
    public static final String RUTA_PELICULAS = USAR_CARPETA_DATOS ? 
            NOMBRE_CARPETA_DATOS + File.separator + NOMBRE_ARCHIVO_PELICULAS : NOMBRE_ARCHIVO_PELICULAS;
    
    public static final String RUTA_SALAS = USAR_CARPETA_DATOS ? 
            NOMBRE_CARPETA_DATOS + File.separator + NOMBRE_ARCHIVO_SALAS : NOMBRE_ARCHIVO_SALAS;
    
    public static final String RUTA_FUNCIONES = USAR_CARPETA_DATOS ? 
            NOMBRE_CARPETA_DATOS + File.separator + NOMBRE_ARCHIVO_FUNCIONES : NOMBRE_ARCHIVO_FUNCIONES;
    
    public static final String RUTA_ASIENTOS_CONFIRMADOS = USAR_CARPETA_DATOS ? 
            NOMBRE_CARPETA_DATOS + File.separator + NOMBRE_ARCHIVO_ASIENTOS : NOMBRE_ARCHIVO_ASIENTOS;
    
    // carpeta de imágenes
    public static final String CARPETA_IMAGENES = NOMBRE_CARPETA_IMAGENES;
    
    //crea las carpetas
    public static void inicializarCarpetas() {
        // Si usamos la carpeta de datos, asegurarnos de que exista
        if (USAR_CARPETA_DATOS) {
            crearCarpetaSiNoExiste(NOMBRE_CARPETA_DATOS);
        }
        
        // Siempre asegurarse de que la carpeta de imágenes exista
        crearCarpetaSiNoExiste(CARPETA_IMAGENES);
        
        // Imprimir información de diagnóstico
        imprimirInformacionDiagnostico();
    }
    
    //diagnostico, que feo es hacer esto
    private static void imprimirInformacionDiagnostico() {
        System.out.println("\n===== CONFIGURACIÓN DE RUTAS =====");
        System.out.println("Modo de almacenamiento: " + 
                          (USAR_CARPETA_DATOS ? "Carpeta separada (" + NOMBRE_CARPETA_DATOS + ")" 
                                              : "Raíz del proyecto"));
        
        System.out.println("\nRutas de archivos:");
        System.out.println("- Clientes: " + new File(RUTA_CLIENTES).getAbsolutePath());
        System.out.println("- Películas: " + new File(RUTA_PELICULAS).getAbsolutePath());
        System.out.println("- Salas: " + new File(RUTA_SALAS).getAbsolutePath());
        System.out.println("- Funciones: " + new File(RUTA_FUNCIONES).getAbsolutePath());
        System.out.println("- Asientos confirmados: " + new File(RUTA_ASIENTOS_CONFIRMADOS).getAbsolutePath());
        System.out.println("- Carpeta de imágenes: " + new File(CARPETA_IMAGENES).getAbsolutePath());
        
        System.out.println("\nVerificación de existencia:");
        System.out.println("- ¿Existe archivo de clientes?: " + existeArchivo(RUTA_CLIENTES));
        System.out.println("- ¿Existe archivo de películas?: " + existeArchivo(RUTA_PELICULAS));
        System.out.println("- ¿Existe archivo de salas?: " + existeArchivo(RUTA_SALAS));
        System.out.println("- ¿Existe carpeta de imágenes?: " + new File(CARPETA_IMAGENES).exists());
        System.out.println("====================================\n");
    }
    
    //por si no existe y es True
    private static void crearCarpetaSiNoExiste(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdirs();
            if (creada) {
                System.out.println("Carpeta creada: " + ruta);
            } else {
                System.err.println("No se pudo crear la carpeta: " + ruta);
            }
        }
    }
    
    //verificacion de existencia
    public static boolean existeArchivo(String ruta) {
        File archivo = new File(ruta);
        return archivo.exists() && archivo.isFile();
    }
    
    // una navaja que no quiero usar
    public static String getRutaImagen(String nombreImagen) {
        return CARPETA_IMAGENES + File.separator + nombreImagen;
    }
}