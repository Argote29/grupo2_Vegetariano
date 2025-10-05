package com.example.vegetariano.dtos;

import java.time.LocalDate;

public class QuerySuscripcionActivaDTO {

    private String nombreUsuario;
    private LocalDate fechaFinalSub;

    public QuerySuscripcionActivaDTO(String nombreUsuario, LocalDate fechaFinalSub) {
        this.nombreUsuario = nombreUsuario;
        this.fechaFinalSub = fechaFinalSub;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFechaFinalSub() {
        return fechaFinalSub;
    }

    public void setFechaFinalSub(LocalDate fechaFinalSub) {
        this.fechaFinalSub = fechaFinalSub;
    }
}

