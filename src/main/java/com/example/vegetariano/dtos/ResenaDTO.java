package com.example.vegetariano.dtos;



import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;

import java.time.LocalDate;

public class ResenaDTO {
    private int id_resena;
    private String comentario;
    private int calificacion;
    private LocalDate fecha_resena;
    private Restaurante restaurante;
    private Usuario usuario;

    public int getId_resena() {
        return id_resena;
    }

    public void setId_resena(int id_resena) {
        this.id_resena = id_resena;
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

    public LocalDate getFecha_resena() {
        return fecha_resena;
    }

    public void setFecha_resena(LocalDate fecha_resena) {
        this.fecha_resena = fecha_resena;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
