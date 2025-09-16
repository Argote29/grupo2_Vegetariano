package com.example.vegetariano.dtos;



import java.time.LocalDate;

public class ReseñaDTO {
    private int id_reseña;
    private String comentario;
    private int calificacion;
    private LocalDate fecha_reseña;

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
}
