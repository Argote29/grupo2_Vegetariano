package com.example.vegetariano.dtos;

import java.math.BigDecimal;

public class PlatoRestauranteDTO {
    private int id_plato;
    private String nombre_restaurante;
    private String nombre_plato;
    private BigDecimal precio_plato;

    public PlatoRestauranteDTO(String nombre_restaurante, String nombre_plato, BigDecimal precio_plato) {
        this.nombre_restaurante = nombre_restaurante;
        this.nombre_plato = nombre_restaurante;
        this.precio_plato = precio_plato;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public BigDecimal getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(BigDecimal precio_plato) {
        this.precio_plato = precio_plato;
    }
}
