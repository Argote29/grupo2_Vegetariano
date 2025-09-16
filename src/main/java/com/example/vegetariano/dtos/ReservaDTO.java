package com.example.vegetariano.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private int id_reserva;
    private LocalDate fecha_reserva;
    private LocalTime hora;
    private int numero_personas;
    private String estado;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
