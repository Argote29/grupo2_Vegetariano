package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Promociones")
public class Promociones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id_Promociones;

    @Column(name = "descripcion", nullable = false, length = 70)
    private String  descripcion;

    @Column(name = "fecha_inico_promo", nullable = false)
    private LocalDate fecha_inico_promo;

    @Column(name = "fecha_final_promo", nullable = false)
    private LocalDate fecha_final_promo;

    @Column(name = "descuento", nullable = false, length = 70)
    private String  descuento;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    public Promociones () {}

    public Promociones(int id_Promociones, String descripcion, LocalDate fecha_inico_promo, LocalDate fecha_final_promo, String descuento, Restaurante restaurante) {
        this.id_Promociones = id_Promociones;
        this.descripcion = descripcion;
        this.fecha_inico_promo = fecha_inico_promo;
        this.fecha_final_promo = fecha_final_promo;
        this.descuento = descuento;
        this.restaurante = restaurante;
    }

    public int getId_Promociones() {
        return id_Promociones;
    }

    public void setId_Promociones(int id_Promociones) {
        this.id_Promociones = id_Promociones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inico_promo() {
        return fecha_inico_promo;
    }

    public void setFecha_inico_promo(LocalDate fecha_inico_promo) {
        this.fecha_inico_promo = fecha_inico_promo;
    }

    public LocalDate getFecha_final_promo() {
        return fecha_final_promo;
    }

    public void setFecha_final_promo(LocalDate fecha_final_promo) {
        this.fecha_final_promo = fecha_final_promo;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
