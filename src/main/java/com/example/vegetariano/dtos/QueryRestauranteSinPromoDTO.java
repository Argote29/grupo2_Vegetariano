package com.example.vegetariano.dtos;

public class QueryRestauranteSinPromoDTO {
    private int id_restaurante;
    private String nombre_restaurante;
    private long totalPromociones;


    public QueryRestauranteSinPromoDTO(int id_restaurante, String nombre_restaurante, long totalPromociones) {
        this.id_restaurante = id_restaurante;
        this.nombre_restaurante = nombre_restaurante;
        this.totalPromociones = totalPromociones;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    public long getTotalPromociones() {
        return totalPromociones;
    }

    public void setTotalPromociones(long totalPromociones) {
        this.totalPromociones = totalPromociones;
    }
}

