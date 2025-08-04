package Model;

import java.util.ArrayList;

/**
 * Interfaz para el repositorio de clientes (Principio de Segregación de Interfaces)
 */
public interface IClienteRepositorio {
    void guardarCliente(Cliente cliente);
    ArrayList<Cliente> obtenerCliente();
    Cliente buscarClientePorCedula(long cedula);
    boolean actualizarCliente(long cedula, String nuevoTelefono);
    boolean eliminarCliente(long cedula);
}