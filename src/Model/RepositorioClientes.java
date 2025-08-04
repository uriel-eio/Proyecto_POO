package Model;

import Util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Implementación del repositorio de clientes que utiliza archivos
 */
public class RepositorioClientes implements IClienteRepositorio {
    
    @Override
    public void guardarCliente(Cliente cliente) {
        LeerEscribir.guardarLinea(Rutas.RUTA_CLIENTES, cliente.toCSV(), true);
    }
    
    public void crearCliente() {
        if (Rutas.existeArchivo(Rutas.RUTA_CLIENTES)) {
            return;
        }
        
        // Clientes predeterminados
        ArrayList<Cliente> clienteNuevo = new ArrayList<>();
        clienteNuevo.add(new Cliente(002, "Ana", "34"));
        clienteNuevo.add(new Cliente(003, "Carlos", "56"));
        
        // Guardar clientes en el archivo
        for (Cliente cliente : clienteNuevo) {
            guardarCliente(cliente);
        }
    }
 
    @Override
    public ArrayList<Cliente> obtenerCliente() {
        Function<String, Cliente> transformador = linea -> {
            String[] data = linea.split(",");
            if (data.length == 3) {
                try {
                    return new Cliente(
                        Long.parseLong(data[0]),
                        data[1],
                        data[2]
                    );
                } catch (NumberFormatException e) {
                    ManejoErrores.mostrarError("Error al convertir cédula: " + data[0], e);
                }
            }
            return null;
        };
        
        List<Cliente> clientes = LeerEscribir.cargarObjetos(
            Rutas.RUTA_CLIENTES, 
            transformador
        );
        
        return new ArrayList<>(clientes);
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
        ArrayList<Cliente> clientes = this.obtenerCliente();
        boolean encontrado = false;

        // Busca la cédula del cliente para poder modificar el teléfono
        for (Cliente c : clientes) {
            if (c.getCedula() == cedula) {
                c.setTelefono(nuevoTelefono);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            // Función para transformar Cliente a CSV
            Function<Cliente, String> transformador = Cliente::toCSV;
            
            // Guardar todos los clientes actualizados
            return LeerEscribir.guardarObjetos(
                Rutas.RUTA_CLIENTES,
                clientes,
                transformador,
                false // Sobrescribir el archivo
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
            // Función para transformar Cliente a CSV
            Function<Cliente, String> transformador = Cliente::toCSV;
            
            // Guardar los clientes restantes
            return LeerEscribir.guardarObjetos(
                Rutas.RUTA_CLIENTES,
                clientes,
                transformador,
                false // Sobrescribir el archivo
            );
        }
        
        return encontrado;
    }
}