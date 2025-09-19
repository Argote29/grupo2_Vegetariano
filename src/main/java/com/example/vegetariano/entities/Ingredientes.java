package com.example.vegetariano.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Ingredientes")
public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id_ingredientes;

    @Column(name = "nombre_ingrediente", nullable = false, length = 30)
    private String nombre_ingrediente;

    @Column(nullable = false)
    private Boolean tipo_natural;

    @Column(name = "nivel_insecticida", nullable = false, length = 30)
    private String nivel_insecticida;

    @Column(name = "formas_preparar", nullable = false, length = 30)
    private String formas_preparar;

    @Column(name = "origen", nullable = false, length = 30)
    private String origen;

    @Column(nullable = false)
    private Boolean contiene_gluten;



    @ManyToMany(mappedBy = "ingredientes")
    private List<Plato> plato;

    public Ingredientes () {}

    public Ingredientes(int id_ingredientes, String nombre_ingrediente, String formas_preparar, Boolean tipo_natural, String nivel_insecticida, String origen, Boolean contiene_gluten, List<Plato> plato) {
        this.id_ingredientes = id_ingredientes;
        this.nombre_ingrediente = nombre_ingrediente;
        this.formas_preparar = formas_preparar;
        this.tipo_natural = tipo_natural;
        this.nivel_insecticida = nivel_insecticida;
        this.origen = origen;
        this.contiene_gluten = contiene_gluten;
        this.plato = plato;
    }

    public int getId_ingredientes() {
        return id_ingredientes;
    }

    public void setId_ingredientes(int id_ingredientes) {
        this.id_ingredientes = id_ingredientes;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public Boolean getTipo_natural() {
        return tipo_natural;
    }

    public void setTipo_natural(Boolean tipo_natural) {
        this.tipo_natural = tipo_natural;
    }

    public String getNivel_insecticida() {
        return nivel_insecticida;
    }

    public void setNivel_insecticida(String nivel_insecticida) {
        this.nivel_insecticida = nivel_insecticida;
    }

    public String getFormas_preparar() {
        return formas_preparar;
    }

    public void setFormas_preparar(String formas_preparar) {
        this.formas_preparar = formas_preparar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Boolean getContiene_gluten() {
        return contiene_gluten;
    }

    public void setContiene_gluten(Boolean contiene_gluten) {
        this.contiene_gluten = contiene_gluten;
    }

    public List<Plato> getPlato() {
        return plato;
    }

    public void setPlato(List<Plato> plato) {
        this.plato = plato;
    }
}
