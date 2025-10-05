package com.example.vegetariano.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingrediente_plato")
public class Ingrediente_Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente_plato")
    private int idIngredientePlato;

    @Column(name = "id_plato", nullable = false)
    private int idPlato;

    @Column(name = "id_ingrediente", nullable = false)
    private int idIngrediente;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipo_unidad", nullable = false, length = 30)
    private String tipoUnidad;

    // 🔹 Constructor vacío (requerido por JPA)
    public Ingrediente_Plato() {}

    // 🔹 Constructor con parámetros (útil para inicializar manualmente)
    public Ingrediente_Plato(int idPlato, int idIngrediente, int cantidad, String tipoUnidad) {
        this.idPlato = idPlato;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
        this.tipoUnidad = tipoUnidad;
    }

    // 🔹 Getters y Setters
    public int getIdIngredientePlato() {
        return idIngredientePlato;
    }

    public void setIdIngredientePlato(int idIngredientePlato) {
        this.idIngredientePlato = idIngredientePlato;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

}
