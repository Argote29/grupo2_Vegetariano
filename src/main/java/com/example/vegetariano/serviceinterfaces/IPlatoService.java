package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Plato;


import java.util.List;

public interface IPlatoService {
    public List<Plato> list();
    public void insert(Plato plato);
    public void delete(int id);
    public Plato listId(int id);
    void update(Plato plato);

}
