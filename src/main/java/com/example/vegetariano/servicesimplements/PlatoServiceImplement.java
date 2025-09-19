package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Plato;
import com.example.vegetariano.repositories.IPlatoRepository;
import com.example.vegetariano.serviceinterfaces.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImplement implements IPlatoService {
    @Autowired
    private IPlatoRepository pS;

    @Override
    public List<Plato> list() { return pS.findAll(); }

    @Override
    public void insert(Plato plato) {pS.save(plato); }

    @Override
    public void delete(int id) { pS.deleteById(id);}

    @Override
    public Plato listId(int id) { return pS.findById(id).orElse(null); }

    @Override
    public void update(Plato plato) {  pS.save(plato); }

    @Override
    public List<String[]> cantidadIngredientesPorPlato() {
        return pS.cantidadIngredientesPorPlato();
    }
}
