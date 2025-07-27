package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RepositorioClientes {
    
    
    private static final String ARCHIVO_CLIENTES = "clientes.txt";
    
    //metodo para agregar clientes
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
 
    //metodo para extraer la informacion de los clientes
    public ArrayList<Cliente> obtenerCliente(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                
                if (data.length == 5) {
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
    
}
