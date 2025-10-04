package com.example.vegetariano.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HistorialSuscripcion") 
public class HistorialSuscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historial;

    
    @Column(name = "fecha_inicio_sub", nullable = false)
    private LocalDate fecha_inicio_sub;

    // Puede ser null mientras esté activa
    @Column(name = "fecha_final_sub")
    private LocalDate fecha_final_sub;

  
    @Column(name = "estado", nullable = false, length = 10)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public HistorialSuscripcion() {}

    public HistorialSuscripcion(int id_historial, LocalDate fecha_inicio_sub, LocalDate fecha_final_sub, String estado, Usuario usuario) {
        this.id_historial = id_historial;
        this.fecha_inicio_sub = fecha_inicio_sub;
        this.fecha_final_sub = fecha_final_sub;
        this.estado = estado;
        this.usuario = usuario;
    }

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

