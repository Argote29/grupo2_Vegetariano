package com.example.vegetariano.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingrediente_plato")
public class Ingrediente_Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente_plato")
    private int idIngredientePlato;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipo_unidad", nullable = false, length = 30)
    private String tipo_unidad;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes", nullable = false)
    private Ingredientes ingredientes;

    public Ingrediente_Plato() {}

    public Ingrediente_Plato(int idIngredientePlato, int cantidad, String tipo_unidad, Plato plato, Ingredientes ingredientes) {
        this.idIngredientePlato = idIngredientePlato;
        this.cantidad = cantidad;
        this.tipo_unidad = tipo_unidad;
        this.plato = plato;
        this.ingredientes = ingredientes;
    }

    public int getIdIngredientePlato() {
        return idIngredientePlato;
    }

    public void setIdIngredientePlato(int idIngredientePlato) {
        this.idIngredientePlato = idIngredientePlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo_unidad() {
        return tipo_unidad;
    }

    public void setTipo_unidad(String tipo_unidad) {
        this.tipo_unidad = tipo_unidad;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }
}

