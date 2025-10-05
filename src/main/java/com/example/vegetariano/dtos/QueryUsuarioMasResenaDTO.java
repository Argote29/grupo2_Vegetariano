package com.example.vegetariano.dtos;

public class QueryUsuarioMasResenaDTO {
    private String nombre;
    private long totalResenas;

    public QueryUsuarioMasResenaDTO(String nombre, long totalResenas) {
        this.nombre = nombre;
        this.totalResenas = totalResenas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTotalResenas() {
        return totalResenas;
    }

    public void setTotalResenas(long totalResenas) {
        this.totalResenas = totalResenas;
    }
}
