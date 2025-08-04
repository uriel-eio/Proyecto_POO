package Model;

import java.util.ArrayList;

// Ahora sí es una interfaz como sugiere su nombre
public interface ISalasRepositorio {
    void crearSala();
    void saveSala(Sala sala);
    ArrayList<Sala> getSala();
    Sala buscarSalaPorId(String id);
    void actualizarSala(Sala salaModificada);
}