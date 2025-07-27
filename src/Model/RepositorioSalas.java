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
    public static final String ARCHIVO_SALAS = "lista_salas.txt";
    //Salas con identificador, nombre y capacidad respectivamente.
    Sala alpha = new Sala("sAlpha", "Sala Alpha", 60);
    Sala beta = new Sala("sBeta", "Sala Beta", 45);
    Sala gamma = new Sala("sGamma", "Sala Gamma", 25);
    
    //Método para guardar una sala en el archivo "lista_salas.txt"
    public void saveSala(Sala sala){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_SALAS, true))){
            //Escribe en formato CSV
            bw.write(salaToCSV(sala));
            bw.newLine();
        } catch (IOException e){
            System.out.println("Error al guardar la sala en el archivo." + e.getMessage());
        }
    }
    
    public void crearSala(){
        File archivo = new File(ARCHIVO_SALAS);
        //Verificar la existencia del archivo.
        if(archivo.exists()){
            return;
        }
        
        //Uso de ArrayList para añadir salas predeterminadas.
        ArrayList<Sala> salaNueva = new ArrayList<>();
        salaNueva.add(alpha);
        salaNueva.add(beta);
        salaNueva.add(gamma);
        
        //Guarda salas en el archivo.
        for(Sala sala : salaNueva){
            saveSala(sala);
        }
    }
    
    //ArrayList para obtener las salas
    public ArrayList<Sala> getSala(){
        ArrayList<Sala> salas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_SALAS))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                //Si tiene los 3 datos de identificacion, nombre y capacidad, creaa una sala y la agrega.
                if(datos.length == 3) {
                    salas.add(new Sala(
                            datos[0],
                            datos[1],
                            Integer.parseInt(datos[2])
                    ));
                }
            }
        } catch (IOException | NumberFormatException e){
            System.out.println("Error al leer el archivo.");
        }
        return salas;
    }

    private String salaToCSV(Sala sala){
        return sala.obtenerId() + "," + sala.getNombre() + "," + sala.contarAsientosDisponibles();
    }
    

    
}
