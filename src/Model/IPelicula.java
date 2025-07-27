package com.mycompany.proyectoprograii.Model;

public interface IPelicula {
    String obtenerTitulo();
    String obtenerGenero();
    int obtenerDuracion();
    RestriccionesEdad obtenerRestriccionEdad();
}