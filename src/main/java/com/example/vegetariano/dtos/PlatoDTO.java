package com.example.vegetariano.dtos;

import java.math.BigDecimal;

public class PlatoDTO {
    private int id_plato;
    private BigDecimal precio_plato;
    private String nombre_plato;
    private String info_nutricional;

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
}
