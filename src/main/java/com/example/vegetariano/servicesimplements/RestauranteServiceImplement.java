package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.repositories.IRestauranteRepository;
import com.example.vegetariano.serviceinterfaces.IRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestauranteServiceImplement implements IRestauranteService {
    @Autowired
    private IRestauranteRepository rre;

    @Override
    public List<Restaurante> list() { return rre.findAll(); }

    @Override
    public void insert(Restaurante restaurante) { rre.save(restaurante); }

    @Override
    public void delete(int id) { rre.deleteById(id); }

    @Override
    public Restaurante listId(int id) { return rre.findById(id).orElse(null); }

    @Override
    public void update(Restaurante restaurante) { rre.save(restaurante); }
}
