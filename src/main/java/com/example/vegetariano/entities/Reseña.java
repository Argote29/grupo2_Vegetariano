package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Reseña")
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reseña;

    @Column(name = "comentario", nullable = false, length = 50)
    private String comentario;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;

    @Column(name = "fecha_reseña", nullable = false)
    private LocalDate fecha_reseña;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    public Reseña () {}

    public Reseña(int id_reseña, String comentario, int calificacion, LocalDate fecha_reseña, Usuario usuario, Restaurante restaurante) {
        this.id_reseña = id_reseña;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha_reseña = fecha_reseña;
        this.usuario = usuario;
        this.restaurante = restaurante;
    }

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


