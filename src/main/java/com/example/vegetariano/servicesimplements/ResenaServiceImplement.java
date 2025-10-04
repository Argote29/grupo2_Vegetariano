package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Resena;
import com.example.vegetariano.repositories.IResenaRepository;
import com.example.vegetariano.serviceinterfaces.IResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaServiceImplement implements IResenaService {

    @Autowired
    private IResenaRepository rSA;

    @Override
    public List<Resena> list() { return rSA.findAll(); }


    @Override
    public void insert(Resena resena) {rSA.save(resena);}

    @Override
    public void delete(int id) { rSA.deleteById(id);}

    @Override
    public Resena listId(int id) { return rSA.findById(id).orElse(null); }

    @Override
    public void update(Resena resena) {rSA.save(resena); }
}

