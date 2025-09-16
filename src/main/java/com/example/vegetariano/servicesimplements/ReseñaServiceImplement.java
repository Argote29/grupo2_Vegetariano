package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Reserva;
import com.example.vegetariano.entities.Reseña;
import com.example.vegetariano.repositories.IReseñaRepository;
import com.example.vegetariano.repositories.IRestauranteRepository;
import com.example.vegetariano.serviceinterfaces.IReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaServiceImplement implements IReseñaService {

    @Autowired
    private IReseñaRepository rSA;

    @Override
    public List<Reseña> list() { return rSA.findAll(); }


    @Override
    public void insert(Reseña reseña) {rSA.save(reseña);}

    @Override
    public void delete(int id) { rSA.deleteById(id);}

    @Override
    public Reseña listId(int id) { return rSA.findById(id).orElse(null); }

    @Override
    public void update(Reseña reseña) {rSA.save(reseña); }
}
