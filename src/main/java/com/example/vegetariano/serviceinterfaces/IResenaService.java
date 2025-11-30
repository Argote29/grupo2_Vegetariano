package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.dtos.QueryRestaurantesMasResenadosDTO;
import com.example.vegetariano.entities.Resena;

import java.util.List;

public interface IResenaService {

    public List<Resena> list();
    public void insert(Resena resena);
    public void delete(int id);
    public Resena listId(int id);
    void update(Resena resena);
    List<QueryRestaurantesMasResenadosDTO> obtenerRestaurantesMasResenados();
}
