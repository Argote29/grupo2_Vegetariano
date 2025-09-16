package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.HistorialSuscripcion;
import com.example.vegetariano.repositories.IHistorialSuscripcionRepository;
import com.example.vegetariano.serviceinterfaces.IHistorialSuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHistorialSuscripcionServiceImplement implements IHistorialSuscripcionService {

    @Autowired
    private IHistorialSuscripcionRepository hSU;

    @Override
    public List<HistorialSuscripcion> list() { return hSU.findAll(); }

    @Override
    public void insert(HistorialSuscripcion historialSuscripcion) { hSU.save(historialSuscripcion); }

    @Override
    public void delete(int id) {  hSU.deleteById(id); }

    @Override
    public HistorialSuscripcion listId(int id) { return hSU.findById(id).orElse(null); }

    @Override
    public void update(HistorialSuscripcion historialSuscripcion) { hSU.save(historialSuscripcion); }
}
