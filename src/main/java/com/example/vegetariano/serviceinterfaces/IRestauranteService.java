package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Restaurante;

import java.util.List;

public interface IRestauranteService {
    public List<Restaurante> list();
    public void insert(Restaurante restaurante);
    public void delete(int id);
    public Restaurante listId(int id);
    void update(Restaurante restaurante);
}
