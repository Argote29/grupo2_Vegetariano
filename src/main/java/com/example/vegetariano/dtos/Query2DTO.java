package com.example.vegetariano.dtos;

public class Query2DTO {

    private String nombre;
    private double promCalificacion;  // ✅ cambiado de int a double
    private int numeroResena;

    public Query2DTO() {
    }

    public Query2DTO(String nombre, double promCalificacion, int numeroResena) {
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

    public double getPromCalificacion() {
        return promCalificacion;
    }

    public void setPromCalificacion(double promCalificacion) {
        this.promCalificacion = promCalificacion;
    }

    public int getNumeroResena() {
        return numeroResena;
    }

    public void setNumeroResena(int numeroResena) {
        this.numeroResena = numeroResena;
    }
}
