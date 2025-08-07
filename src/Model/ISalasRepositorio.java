package Model;

import java.util.ArrayList;

public interface ISalasRepositorio {
    void crearSala();
    void saveSala(Sala sala);
    ArrayList<Sala> getSala();
    Sala buscarSalaPorId(String id);
    void actualizarSala(Sala salaModificada);
}