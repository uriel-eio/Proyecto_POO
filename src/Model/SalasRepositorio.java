package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Util.*;

public class SalasRepositorio implements ISalasRepositorio {
    private final IPeliculasRepositorio repoPeliculas;
    
    public SalasRepositorio(IPeliculasRepositorio repoPeliculas) {
        this.repoPeliculas = repoPeliculas;
    }
    
    //Esta bastante interactivo, los nombres de por si dicen que hace cada cosa\
    
    @Override
    public void crearSala() {
        if (Rutas.existeArchivo(Rutas.RUTA_SALAS)) return;

        saveSala(new Sala("s01", "Sala Alpha", 60, false));
        saveSala(new Sala("s02", "Sala Beta", 45, false));
        saveSala(new Sala("s03", "Sala VIP", 25, true));
    }
    
    @Override
    public void saveSala(Sala sala){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Rutas.RUTA_SALAS, true))){
            bw.write(sala.toCSV());
            bw.newLine();
        } catch (IOException e){
            System.out.println("Error al guardar la sala en el archivo." + e.getMessage());
        }
    }
    
    @Override
    public ArrayList<Sala> getSala() {
        ArrayList<Sala> salas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Rutas.RUTA_SALAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombrePelicula = datos[4]; 
                // si completa los datos...
                if (datos.length == 6) { 
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

                    // se lee la cadena creada por el string builder
                    String estadosAsientosStr = datos[5];
                    ArrayList<Asiento> asientosDeLaSala = sala.getAsientos();
                    for (int i = 0; i < estadosAsientosStr.length(); i++) {
                        // Esto asegura que no tesalgas del rango de asientos
                        if (i < asientosDeLaSala.size()) {
                            char estadoChar = estadosAsientosStr.charAt(i);
                            if (estadoChar == '1') {
                                asientosDeLaSala.get(i).forzarReserva();
                            }
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
       
    @Override
    public Sala buscarSalaPorId(String id) {
        for (Sala sala : this.getSala()) { 
            if (sala.obtenerId().equals(id)) {
                return sala;
            }
        }
        return null; // por si no hay
    }

    @Override
    public void actualizarSala(Sala salaModificada) {
        //busca la sala por id 
        ArrayList<Sala> salas = this.getSala();
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).obtenerId().equals(salaModificada.obtenerId())) {
                // reemplaza el objeto que ya existia por uno nuevo con los nuevos parametros
                salas.set(i, salaModificada);
                break;
            }
        }

        // reescribe el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Rutas.RUTA_SALAS))) {
            for (Sala s : salas) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo de salas: " + e.getMessage());
        }
    }
}