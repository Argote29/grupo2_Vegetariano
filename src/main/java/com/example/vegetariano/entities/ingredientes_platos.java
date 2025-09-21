package com.example.vegetariano.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "ingredientes_plato")
public class ingredientes_platos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingredientes ingrediente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public ingredientes_platos(int id, Plato plato, Ingredientes ingrediente) {
        this.id = id;
        this.plato = plato;
        this.ingrediente = ingrediente;
    }

    public Ingredientes getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingredientes ingrediente) {
        this.ingrediente = ingrediente;
    }

    public ingredientes_platos() {
    }
}
