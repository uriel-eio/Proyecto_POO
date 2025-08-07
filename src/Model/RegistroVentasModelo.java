
package Model;

import java.util.ArrayList;

public class RegistroVentasModelo {
    private static final ArrayList<OrdenCompra> todasLasVentas = new ArrayList<>();

    public static void agregarVenta(OrdenCompra orden) {
        todasLasVentas.add(orden);
    }

    public static ArrayList<OrdenCompra> obtenerTodasLasVentas() {
        return todasLasVentas;
    }
}
