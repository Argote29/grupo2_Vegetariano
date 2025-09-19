package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

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

    // 🔹 Relación muchos a muchos con Ingredientes
    @ManyToMany
    @JoinTable(
            name = "ingrediente_plato",
            joinColumns = @JoinColumn(name = "id_plato"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredientes")
    )
    private List<Ingredientes> ingredientes;

    public Plato () {}

    public Plato(int id_plato, BigDecimal precio_plato, String nombre_plato, String info_nutricional, Restaurante restaurante, Promociones promociones,
    List<Ingredientes> ingredientes) {
        this.id_plato = id_plato;
        this.precio_plato = precio_plato;
        this.nombre_plato = nombre_plato;
        this.info_nutricional = info_nutricional;
        this.restaurante = restaurante;
        this.promociones = promociones;
        this.ingredientes = ingredientes;
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

    public List<Ingredientes> getIngredientes() { return ingredientes; }

    public void setIngredientes(List<Ingredientes> ingredientes) { this.ingredientes = ingredientes; }
}
