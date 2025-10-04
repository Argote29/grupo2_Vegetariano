<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Restaurante;

import java.util.List;

public interface    IRestauranteService {
    public List<Restaurante> list();
    public void insert(Restaurante restaurante);
    public void delete(int id);
    public Restaurante listId(int id);
    void update(Restaurante restaurante);

    List<String[]> QueryRestaurantePromedioResena();

}
<<<<<<< HEAD
=======
=======
package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Restaurante;

import java.util.List;

public interface IRestauranteService {
    public List<Restaurante> list();
    public void insert(Restaurante restaurante);
    public void delete(int id);
    public Restaurante listId(int id);
    void update(Restaurante restaurante);
}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
