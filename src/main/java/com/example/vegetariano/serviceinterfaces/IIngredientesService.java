package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Ingredientes;
import com.example.vegetariano.entities.Plato;

import java.util.List;

public interface IIngredientesService {
    public List<Ingredientes> list();
    public void insert(Ingredientes ingredientes);
    public void delete(int id);
    public Ingredientes listId(int id);
    void update(Ingredientes ingredientes);
}
