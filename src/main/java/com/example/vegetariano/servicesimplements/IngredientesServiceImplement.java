<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Ingredientes;
import com.example.vegetariano.repositories.IIngredientesRepository;
import com.example.vegetariano.serviceinterfaces.IIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientesServiceImplement  implements IIngredientesService {


    @Autowired
    private IIngredientesRepository iIG;

    @Override
    public List<Ingredientes> list() { return iIG.findAll(); }

    @Override
    public void insert(Ingredientes ingredientes) {iIG.save(ingredientes);}

    @Override
    public void delete(int id) {iIG.deleteById(id);}

    @Override
    public Ingredientes listId(int id) { return iIG.findById(id).orElse(null); }

    @Override
    public void update(Ingredientes ingredientes) { iIG.save(ingredientes); }

}
<<<<<<< HEAD
=======
=======
package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Ingredientes;
import com.example.vegetariano.repositories.IIngredientesRepository;
import com.example.vegetariano.serviceinterfaces.IIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientesServiceImplement  implements IIngredientesService {


    @Autowired
    private IIngredientesRepository iIG;

    @Override
    public List<Ingredientes> list() { return iIG.findAll(); }

    @Override
    public void insert(Ingredientes ingredientes) {iIG.save(ingredientes);}

    @Override
    public void delete(int id) {iIG.deleteById(id);}

    @Override
    public Ingredientes listId(int id) { return iIG.findById(id).orElse(null); }

    @Override
    public void update(Ingredientes ingredientes) { iIG.save(ingredientes); }

}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
