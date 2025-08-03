/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class RepositorioSalas {
    private final RepositorioPeliculas repoPeliculas;
    public static final String ARCHIVO_SALAS = "lista_salas.txt";
    //Salas con identificador, nombre y capacidad respectivamente.
    public RepositorioSalas(RepositorioPeliculas repoPeliculas) {
        this.repoPeliculas = repoPeliculas;
    }
    public void crearSala() {
        File archivo = new File(ARCHIVO_SALAS);
        if (archivo.exists()) return;

        saveSala(new Sala("s01", "Sala Alpha", 60, false));
        saveSala(new Sala("s02", "Sala Beta", 45, false));
        saveSala(new Sala("s03", "Sala VIP", 25, true));
    }
    
    //Método para guardar una sala en el archivo "lista_salas.txt"
    public void saveSala(Sala sala){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_SALAS, true))){
            //Escribe en formato CSV
            bw.write(sala.toCSV());
            bw.newLine();
        } catch (IOException e){
            System.out.println("Error al guardar la sala en el archivo." + e.getMessage());
        }
    }
    
    
    //ArrayList para obtener las salas
    public ArrayList<Sala> getSala() {
        ArrayList<Sala> salas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_SALAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombrePelicula = datos[4]; 

                if (datos.length == 5) {
                    boolean esVip = Boolean.parseBoolean(datos[3]); 
                    Sala sala = new Sala(datos[0], 
                            datos[1], 
                            Integer.parseInt(datos[2]), 
                            esVip);
                    if (!nombrePelicula.equals("Sin Asignar")) {
                        Pelicula peliculaAsignada = repoPeliculas.buscarPeliculaPorTitulo(nombrePelicula);
                        if (peliculaAsignada != null) {
                            sala.setPelicula(peliculaAsignada);
                        }
                    }
                    salas.add(sala);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo de salas: " + e.getMessage());
        }
        return salas;
    }
       
    //Metodo para buscar salas 
    public Sala buscarSalaPorId(String id) {
        for (Sala sala : this.getSala()) { 
            if (sala.obtenerId().equals(id)) {
                return sala;
            }
        }
        return null; // No se encontró la sala
    }

    private String salaToCSV(Sala sala){
        return sala.obtenerId() + "," + sala.getNombre() + "," + sala.contarAsientosDisponibles();
    }
    

    public void actualizarSala(Sala salaModificada) {
        //busca la sala por id y le asigna la modificacion que le vamos a dar
        ArrayList<Sala> salas = this.getSala();
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).obtenerId().equals(salaModificada.obtenerId())) {
                // reemplaza el objeto que ya existia por uno nuevo con los nuevos parametros
                // TODO: podemos optimizar esto haciendo que solo modifique un campo
                salas.set(i, salaModificada);
                break;
            }
        }
        // re escribe el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_SALAS))) { // Modo sobre-escritura
            for (Sala s : salas) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo de salas: " + e.getMessage());
        }
    }
}
