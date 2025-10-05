package com.example.vegetariano.dtos;

public class Query2DTO {
    private String nombre;
    private int promCalificacion;
    private int numeroResena;

    public Query2DTO() {
    }

    public Query2DTO(String nombre, int promCalificacion, int numeroResena) {
        this.nombre = nombre;
        this.promCalificacion = promCalificacion;
        this.numeroResena = numeroResena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPromCalificacion() {
        return promCalificacion;
    }

    public void setPromCalificacion(int promCalificacion) {
        this.promCalificacion = promCalificacion;
    }

    public int getNumeroResena() {
        return numeroResena;
    }

    public void setNumeroResena(int numeroResena) {
        this.numeroResena = numeroResena;
    }
}
