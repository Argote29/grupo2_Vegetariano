package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT p.id_plato, p.nombre_plato, p.precio_plato " +
            "FROM Restaurante r " +
            "INNER JOIN Plato p ON r.id_restaurante = p.id_restaurante " +
            "WHERE r.nombre_restaurante = :nombreRestaurante " +
            "ORDER BY p.precio_plato DESC",
            nativeQuery = true)
    List<Object[]> listarPlatosPorRestaurante(@Param("nombreRestaurante") String nombreRestaurante);
}
