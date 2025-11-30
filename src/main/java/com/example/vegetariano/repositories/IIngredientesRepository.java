package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Ingredientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredientesRepository extends JpaRepository<Ingredientes,Integer> {

    @Query(value = """
        SELECT 
          i.nombre_ingrediente  AS nombreIngrediente,
          i.origen              AS origen
        FROM ingredientes i
        WHERE i.origen = :origen
        ORDER BY i.nombre_ingrediente
        """, nativeQuery = true)
    List<Object[]> buscarPorOrigen(@Param("origen") String origen);

}
