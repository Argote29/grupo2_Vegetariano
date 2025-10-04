package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Reserva;

import java.util.List;
public interface IReservaService {
    public List<Reserva> list();
    public void insert(Reserva reserva);
    public void delete(int id);
    public Reserva listId(int id);
    void update(Reserva reserva);
}
