package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.dtos.QueryPlatoIngredientesDTO;
import com.example.vegetariano.entities.Ingrediente_Plato;

import java.util.List;

public interface IIngrediente_PlatoService {
    List<Ingrediente_Plato> list();                      // Listar todos
    void insert(Ingrediente_Plato ingredientePlato);     // Insertar
    void delete(int id);                                 // Eliminar
    Ingrediente_Plato listId(int id);                    // Buscar por ID
    void update(Ingrediente_Plato ingredientePlato);     // Actualizar
    List<Ingrediente_Plato> listByPlato(int id_plato);

    List<QueryPlatoIngredientesDTO> obtenerPlatosConIngredientes();
}
