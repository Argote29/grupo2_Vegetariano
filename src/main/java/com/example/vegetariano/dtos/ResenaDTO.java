package com.example.vegetariano.dtos;



import java.time.LocalDate;

public class ResenaDTO {
    private int id_reseña;
    private String comentario;
    private int calificacion;
    private LocalDate fecha_reseña;
    private int id_restaurante;
    private int id_usuario;

    public int getId_reseña() {
        return id_reseña;
    }

    public void setId_reseña(int id_reseña) {
        this.id_reseña = id_reseña;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFecha_reseña() {
        return fecha_reseña;
    }

    public void setFecha_reseña(LocalDate fecha_reseña) {
        this.fecha_reseña = fecha_reseña;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
