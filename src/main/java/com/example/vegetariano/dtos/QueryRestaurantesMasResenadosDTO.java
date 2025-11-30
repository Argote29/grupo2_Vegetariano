package com.example.vegetariano.dtos;

public class QueryRestaurantesMasResenadosDTO {

    private String nombreRestaurante;
    private Long cantidadResenas;

    public QueryRestaurantesMasResenadosDTO(String nombreRestaurante, Long cantidadResenas) {
        this.nombreRestaurante = nombreRestaurante;
        this.cantidadResenas = cantidadResenas;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Long getCantidadResenas() {
        return cantidadResenas;
    }

    public void setCantidadResenas(Long cantidadResenas) {
        this.cantidadResenas = cantidadResenas;
    }
}
