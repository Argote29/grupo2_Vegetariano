package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Resena")
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resena;

    @Column(name = "comentario", nullable = false, length = 50)
    private String comentario;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;

    @Column(name = "fecha_resena", nullable = false)
    private LocalDate fecha_resena;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    public Resena() {}

    public Resena(int id_resena, String comentario, int calificacion, LocalDate fecha_resena, Usuario usuario, Restaurante restaurante) {
        this.id_resena = id_resena;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha_resena = fecha_resena;
        this.usuario = usuario;
        this.restaurante = restaurante;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}


