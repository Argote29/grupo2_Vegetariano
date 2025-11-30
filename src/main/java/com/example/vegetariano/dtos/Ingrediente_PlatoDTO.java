package com.example.vegetariano.dtos;

import com.example.vegetariano.entities.Ingredientes;
import com.example.vegetariano.entities.Plato;


public class Ingrediente_PlatoDTO {
    private int idIngredientePlato;
    private int cantidad;
    private String tipo_unidad;
    private Plato plato;
    private Ingredientes ingredientes;

    public int getIdIngredientePlato() {
        return idIngredientePlato;
    }

    public void setIdIngredientePlato(int idIngredientePlato) {
        this.idIngredientePlato = idIngredientePlato;
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

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }
}
