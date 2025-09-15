package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fecha_reserva;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "numero_personas", nullable = false)
    private int numero_personas;

    @Column(name = "estado", nullable = false, length = 30)
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    public Reserva() {}

    public Reserva(int id_reserva, LocalDate fecha_reserva, LocalTime hora,
                   int numero_personas, String estado,Restaurante restaurante, Usuario usuario) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.hora = hora;
        this.numero_personas = numero_personas;
        this.estado = estado;
        this.usuario = usuario;
        this.restaurante = restaurante;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
