package com.example.vegetariano.repositories;


import com.example.vegetariano.entities.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena,Integer> {
    @Query(value = "SELECT res.nombre_restaurante, COUNT(r.id_reseña) AS cantidad_reseñas " +
            "FROM Restaurante res " +
            "JOIN Reseña r ON res.id_restaurante = r.id_restaurante " +
            "GROUP BY res.nombre_restaurante " +
            "ORDER BY cantidad_reseñas DESC",
            nativeQuery = true)
    List<Object[]> findRestaurantesMasResenados();
}
