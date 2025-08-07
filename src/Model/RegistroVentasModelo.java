/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
