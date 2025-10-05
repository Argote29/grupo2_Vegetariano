package com.example.vegetariano.dtos;

public class QueryIngredientespororigenDTO {
    private int id_ingredientes;
    private String nombre_ingrediente;
    private String origen;

    public QueryIngredientespororigenDTO(int id_ingredientes, String nombre_ingrediente, String origen) {
        this.id_ingredientes = id_ingredientes;
        this.nombre_ingrediente = nombre_ingrediente;
        this.origen = origen;
    }

    public int getId_ingredientes() {
        return id_ingredientes;
    }

    public void setId_ingredientes(int id_ingredientes) {
        this.id_ingredientes = id_ingredientes;
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
