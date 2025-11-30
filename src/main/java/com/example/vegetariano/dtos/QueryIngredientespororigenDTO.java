package com.example.vegetariano.dtos;

public class QueryIngredientespororigenDTO {
    private String nombre_ingrediente;
    private String origen;

    public QueryIngredientespororigenDTO( String nombre_ingrediente, String origen) {
 
        this.nombre_ingrediente = nombre_ingrediente;
        this.origen = origen;
    }

  
    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
