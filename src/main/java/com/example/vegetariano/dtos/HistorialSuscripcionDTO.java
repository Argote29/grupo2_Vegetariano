package com.example.vegetariano.dtos;

import com.example.vegetariano.entities.Usuario;

import java.time.LocalDate;

public class HistorialSuscripcionDTO {
    private int id_historial;
    private LocalDate fecha_inicio_sub;
    private LocalDate fecha_final_sub;
    private String estado;
    private Usuario usuario;

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public LocalDate getFecha_inicio_sub() {
        return fecha_inicio_sub;
    }

    public void setFecha_inicio_sub(LocalDate fecha_inicio_sub) {
        this.fecha_inicio_sub = fecha_inicio_sub;
    }

    public LocalDate getFecha_final_sub() {
        return fecha_final_sub;
    }

    public void setFecha_final_sub(LocalDate fecha_final_sub) {
        this.fecha_final_sub = fecha_final_sub;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

