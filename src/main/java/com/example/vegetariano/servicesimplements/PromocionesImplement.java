<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
package com.example.vegetariano.servicesimplements;


import com.example.vegetariano.entities.Promociones;
import com.example.vegetariano.repositories.IPromocionesRepository;
import com.example.vegetariano.serviceinterfaces.IPromocionesService;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionesImplement implements IPromocionesService {
    @Autowired
=======
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PromocionesImplement implements IPromocionesService {

>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    private IPromocionesRepository repo;
    @Override
    public List<Promociones> list() { return repo.findAll(); }

    @Override
    public void insert(Promociones promociones) { repo.save(promociones); }

    @Override
<<<<<<< HEAD
    public void delete(int id) {
        repo.deleteById(id);}
=======
    public void delete(int id) {repo.deleteById(id);}
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

    @Override
    public Promociones listId(int id) { return repo.findById(id).orElse(null); }

    @Override
    public void update(Promociones promociones) { repo.save(promociones); }

}
<<<<<<< HEAD
=======
=======
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
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
