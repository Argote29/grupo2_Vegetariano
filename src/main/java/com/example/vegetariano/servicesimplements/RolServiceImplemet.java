<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.repositories.IRolRepository;
import com.example.vegetariano.serviceinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplemet implements IRolService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }
}
<<<<<<< HEAD
=======
=======
package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.repositories.IRolRepository;
import com.example.vegetariano.serviceinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplemet implements IRolService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }
}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
