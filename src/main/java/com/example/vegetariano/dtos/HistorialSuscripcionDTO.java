package com.example.vegetariano.dtos;

import java.time.LocalDate;

public class HistorialSuscripcionDTO {
    private int id_historial;
    private LocalDate fecha_inico_sub;
    private LocalDate fecha_final_sub;
    private String estado;

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public LocalDate getFecha_inico_sub() {
        return fecha_inico_sub;
    }

    public void setFecha_inico_sub(LocalDate fecha_inico_sub) {
        this.fecha_inico_sub = fecha_inico_sub;
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
}
