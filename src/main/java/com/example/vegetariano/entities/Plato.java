package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "Plato")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_plato;
    @Column(name = "precio_plato", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio_plato;

    @Column(name = "nombre_plato", nullable = false, length = 30)
    private String nombre_plato;

    @Column(name = "info_nutricional", nullable = false, length = 70)
    private String info_nutricional;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "id_promociones", nullable = false)
    private Promociones  promociones;

    public Plato () {}

    public Plato(int id_plato, BigDecimal precio_plato, String nombre_plato, String info_nutricional, Restaurante restaurante, Promociones promociones) {
        this.id_plato = id_plato;
        this.precio_plato = precio_plato;
        this.nombre_plato = nombre_plato;
        this.info_nutricional = info_nutricional;
        this.restaurante = restaurante;
        this.promociones = promociones;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public BigDecimal getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(BigDecimal precio_plato) {
        this.precio_plato = precio_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getInfo_nutricional() {
        return info_nutricional;
    }

    public void setInfo_nutricional(String info_nutricional) {
        this.info_nutricional = info_nutricional;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Promociones getPromociones() {
        return promociones;
    }

    public void setPromociones(Promociones promociones) {
        this.promociones = promociones;
    }
}
