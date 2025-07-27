package com.mycompany.proyectoprograii.Model;

public enum RestriccionesEdad {
    A("Apto para todo público."),
    B("Apto para mayores de 15 años."),
    C("Apto para mayores de 18 años.");
    
    private final String descripcion;
    
    RestriccionesEdad(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
