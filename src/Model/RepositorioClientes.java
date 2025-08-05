package Model;

import Util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RepositorioClientes implements IClienteRepositorio {
    
    @Override //usa Rutas
    public void guardarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Rutas.RUTA_CLIENTES, true))){
            bw.write(cliente.toCSV());
            bw.newLine();
        } catch (IOException e){
            System.err.println("¡Error al guardar el cliente!: " + e.getMessage());
            e.printStackTrace();
        }
    }
        // la mayoria de cosas dic el nombre que hace
        public void crearCliente(){
        if (Rutas.existeArchivo(Rutas.RUTA_CLIENTES)){
            return;
        }
        
        ArrayList<Cliente> clienteNuevo = new ArrayList<>();
        Cliente Ana = new Cliente(002, "Ana", "34");
        Cliente Carlos = new Cliente(003, "Carlos", "56");
        clienteNuevo.add(Ana);
        clienteNuevo.add(Carlos);
        
        for(Cliente cliente : clienteNuevo){
            guardarCliente(cliente);
        }
    }
        
    @Override
    public ArrayList<Cliente> obtenerCliente(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(Rutas.RUTA_CLIENTES))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                
                if (data.length == 3) {
                    clientes.add(new Cliente(
                            Long.parseLong(String.valueOf(data[0])),
                            data[1],
                            data[2]
                            ));
                }
            }
        } catch (IOException | NumberFormatException e){
            System.out.println("ERROR EN EL ARCHIVO");
        }
        return clientes;
    }
    
    @Override //ez
    public Cliente buscarClientePorCedula(long cedula) {
        for (Cliente c : obtenerCliente()) {
            if (c.getCedula() == cedula) return c;
        }
        return null;
    }
    
    @Override
    public boolean actualizarCliente(long cedula, String nuevoTelefono) {
        ArrayList<Cliente> clientes = this.obtenerCliente();
        boolean encontrado = false;

        // filtro
        for (Cliente c : clientes) {
            if (c.getCedula() == cedula) {
                c.setTelefono(nuevoTelefono);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            // transforma Cliente a CSV
            Function<Cliente, String> transformador = Cliente::toCSV;
            
            // guarda
            return LeerEscribir.guardarObjetos(
                Rutas.RUTA_CLIENTES,
                clientes,
                transformador,
                false // sobrescribir el archivo
            );
        }
        
        return encontrado;
    }
    
    @Override
    public boolean eliminarCliente(long cedula) {
        ArrayList<Cliente> clientes = obtenerCliente();
        boolean encontrado = false;
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula() == cedula) {
                clientes.remove(i);
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            // misma logica 
            Function<Cliente, String> transformador = Cliente::toCSV;
            
            return LeerEscribir.guardarObjetos(
                Rutas.RUTA_CLIENTES,
                clientes,
                transformador,
                false 
            );
        }
        
        return encontrado;
    }
}