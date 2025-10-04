package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "HistorialSuscripcion")
public class HistorialSuscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historial;

    @Column(name = "fecha_inico_sub", nullable = false)
    private LocalDate fecha_inico_sub;

    @Column(name = "fecha_final_sub", nullable = false)
    private LocalDate fecha_final_sub;

    @Column(name = "estado", nullable = false, length = 70)
<<<<<<< HEAD
    private boolean estado;
=======
<<<<<<< HEAD
    private boolean estado;
=======
    private String estado;
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public HistorialSuscripcion () {}

<<<<<<< HEAD
    public HistorialSuscripcion(int id_historial, LocalDate fecha_inico_sub, boolean estado, LocalDate fecha_final_sub, Usuario usuario) {
=======
<<<<<<< HEAD
    public HistorialSuscripcion(int id_historial, LocalDate fecha_inico_sub, boolean estado, LocalDate fecha_final_sub, Usuario usuario) {
=======
    public HistorialSuscripcion(int id_historial, LocalDate fecha_inico_sub, String estado, LocalDate fecha_final_sub, Usuario usuario) {
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
        this.id_historial = id_historial;
        this.fecha_inico_sub = fecha_inico_sub;
        this.estado = estado;
        this.fecha_final_sub = fecha_final_sub;
        this.usuario = usuario;
    }

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

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
<<<<<<< HEAD
=======
=======
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
