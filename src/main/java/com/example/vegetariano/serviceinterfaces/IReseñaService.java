package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Reseña;

import java.util.List;

public interface IReseñaService {

    public List<Reseña> list();
    public void insert(Reseña reseña);
    public void delete(int id);
    public Reseña listId(int id);
    void update(Reseña reseña);
}
