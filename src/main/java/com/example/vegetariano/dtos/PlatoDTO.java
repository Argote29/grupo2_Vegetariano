package com.example.vegetariano.dtos;

import java.math.BigDecimal;
import java.util.List;

public class PlatoDTO {
    private int id_plato;
    private BigDecimal precio_plato;
    private String nombre_plato;
    private String info_nutricional;
    private List<Integer> ingredientesIds;
    private int id_restaurante;
    private int id_Promociones;

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

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getId_Promociones() {
        return id_Promociones;
    }

    public void setId_Promociones(int id_Promociones) {
        this.id_Promociones = id_Promociones;
    }
}
