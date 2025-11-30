package com.example.vegetariano.dtos;

import com.example.vegetariano.entities.Promociones;
import com.example.vegetariano.entities.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public class PlatoDTO {
    private int id_plato;
    private BigDecimal precio_plato;
    private String nombre_plato;
    private String info_nutricional;
    private List<Integer> ingredientesIds;
    private Restaurante restaurante;
    private Promociones promociones;

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public BigDecimal getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(BigDecimal precio_plato) {
        this.precio_plato = precio_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getInfo_nutricional() {
        return info_nutricional;
    }

    public void setInfo_nutricional(String info_nutricional) {
        this.info_nutricional = info_nutricional;
    }

    public List<Integer> getIngredientesIds() {
        return ingredientesIds;
    }

    public void setIngredientesIds(List<Integer> ingredientesIds) {
        this.ingredientesIds = ingredientesIds;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Promociones getPromociones() {
        return promociones;
    }

    public void setPromociones(Promociones promociones) {
        this.promociones = promociones;
    }
}
