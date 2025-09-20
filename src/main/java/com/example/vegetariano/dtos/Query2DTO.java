package com.example.vegetariano.dtos;

public class Query2DTO {
    private String nombre;
    private int calificacion;
    private int id_reseña;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_reseña() {
        return id_reseña;
    }

    public void setId_reseña(int id_reseña) {
        this.id_reseña = id_reseña;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
