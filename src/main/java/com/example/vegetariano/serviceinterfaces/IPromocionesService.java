package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Promociones;

import java.util.List;

public interface IPromocionesService {
    public List<Promociones> list();
    public void insert(Promociones promociones);
    public void delete(int id);
    public Promociones listId(int id);
    void update(Promociones promociones);
}
