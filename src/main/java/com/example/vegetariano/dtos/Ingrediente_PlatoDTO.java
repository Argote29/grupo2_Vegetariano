package com.example.vegetariano.dtos;

public class Ingrediente_PlatoDTO {
    private String nombre_ingrediente;
    private int cantidad;
    private String tipo_unidad;

    public Ingrediente_PlatoDTO(String nombre_ingrediente, int cantidad, String tipo_unidad) {
        this.nombre_ingrediente = nombre_ingrediente;
        this.cantidad = cantidad;
        this.tipo_unidad = tipo_unidad;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo_unidad() {
        return tipo_unidad;
    }

    public void setTipo_unidad(String tipo_unidad) {
        this.tipo_unidad = tipo_unidad;
    }
}
