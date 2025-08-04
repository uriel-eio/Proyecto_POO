package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Implementación del repositorio de clientes que utiliza archivos
 * Principio de Responsabilidad Única: Solo maneja la persistencia de clientes
 */
public class RepositorioClientes implements IClienteRepositorio {
    
    private static final String ARCHIVO_CLIENTES = "clientes.txt";
    
    @Override
    public void guardarCliente(Cliente cliente) {
        //se crea el archivo clientes.txt y se escriben todos los clientes agregados
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true))) {
            bw.write(cliente.toCSV());
            bw.newLine();
        } catch (Exception e){
            System.err.println("¡Error al guardar el cliente!: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void crearCliente(){
        File archivo = new File(ARCHIVO_CLIENTES);
        //Verificar la existencia del archivo.
        if(archivo.exists()){
            return;
        }
        
        //Uso de ArrayList para añadir salas predeterminadas.
        ArrayList<Cliente> clienteNuevo = new ArrayList<>();
        Cliente Ana = new Cliente(002, "Ana", "34");
        Cliente Carlos = new Cliente(003, "Carlos", "56");
        clienteNuevo.add(Ana);
        clienteNuevo.add(Carlos);
        //Guarda salas en el archivo.
        for(Cliente cliente : clienteNuevo){
            guardarCliente(cliente);
        }
    }
 
    @Override
    public ArrayList<Cliente> obtenerCliente(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))){
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
            System.out.println("¡Error procesando el archivo!");
        }
        return clientes;
    }
    
    @Override
    public Cliente buscarClientePorCedula(long cedula) {
        for (Cliente c : obtenerCliente()) {
            if (c.getCedula() == cedula) return c;
        }
        return null;
    }
    
    @Override
    public boolean actualizarCliente(long cedula, String nuevoTelefono) {
        // Guardamos los clientes del archivo en nuevo arreglo
        ArrayList<Cliente> clientes = this.obtenerCliente(); 
        boolean encontrado = false;

        // busca la cedula del cliente para poder modificar el telefono que es lo unico que cambiaria
        for (Cliente c : clientes) {
            if (c.getCedula() == cedula) {
                // Sobre escribimos solo el telefono
                c.setTelefono(nuevoTelefono);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            // abrimos el archivo en modo sobre escritura
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
                for (Cliente c : clientes) {
                    // re escribimos toda la linea del cliente, pero como solo hubo
                    //cambios en el telefono solo se sobre escribirá ese dato
                    bw.write(c.toCSV());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error, no se pudo sobre escribir el número del cliente " + e.getMessage());
                return false; 
            }
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
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
                for (Cliente c : clientes) {
                    bw.write(c.toCSV());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error, no se pudo eliminar el cliente: " + e.getMessage());
                return false;
            }
        }
        
        return encontrado;
    }
}