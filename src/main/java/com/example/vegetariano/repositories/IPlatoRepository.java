package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlatoRepository extends JpaRepository<Plato,Integer> {


    @Query(value = "SELECT p.nombre_plato, COUNT(ip.id_ingredientes) AS total_ingredientes " +
            "FROM plato p " +
            "INNER JOIN ingrediente_plato ip ON p.id_plato = ip.id_plato " +
            "GROUP BY p.nombre_plato",
            nativeQuery = true)
    List<String[]> cantidadIngredientesPorPlato();
}
