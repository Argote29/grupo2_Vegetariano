package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.HistorialSuscripcion;

import java.util.List;

public interface IHistorialSuscripcionService {
    public List<HistorialSuscripcion> list();
    public void insert(HistorialSuscripcion historialSuscripcion);
    public void delete(int id);
    public HistorialSuscripcion listId(int id);
    void update(HistorialSuscripcion historialSuscripcion);
}
