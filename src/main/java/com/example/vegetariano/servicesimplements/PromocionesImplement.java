package com.example.vegetariano.servicesimplements;


import com.example.vegetariano.entities.Promociones;
import com.example.vegetariano.repositories.IPromocionesRepository;
import com.example.vegetariano.serviceinterfaces.IPromocionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionesImplement implements IPromocionesService {

    @Autowired
    private IPromocionesRepository repo;

    @Override
    public List<Promociones> list() {
        return repo.findAll();
    }

    @Override
    public void insert(Promociones promociones) {
        repo.save(promociones);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public Promociones listId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void update(Promociones promociones) {
        repo.save(promociones);
    }

}
