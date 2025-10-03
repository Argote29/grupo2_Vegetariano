<<<<<<< HEAD
package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Plato;


import java.util.List;

public interface IPlatoService {
    public List<Plato> list();
    public void insert(Plato plato);
    public void delete(int id);
    public Plato listId(int id);
    void update(Plato plato);
    List<String[]> cantidadIngredientesPorPlato();
    List<Object[]> listarPlatosPorRestaurante(String nombreRestaurante);


}
=======
package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Plato;


import java.util.List;

public interface IPlatoService {
    public List<Plato> list();
    public void insert(Plato plato);
    public void delete(int id);
    public Plato listId(int id);
    void update(Plato plato);
    List<String[]> cantidadIngredientesPorPlato();

}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
