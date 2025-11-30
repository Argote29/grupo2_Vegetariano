package com.example.vegetariano.dtos;

public class QueryRestaurantesMasVariedadPlatosDTO
{
    private String nombreRestaurante;
    private Long totalPlatos;

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Long getTotalPlatos() {
        return totalPlatos;
    }

    public void setTotalPlatos(Long totalPlatos) {
        this.totalPlatos = totalPlatos;
    }
}
