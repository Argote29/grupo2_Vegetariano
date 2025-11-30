package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva,Integer> {
    @Query("SELECT r.restaurante.nombre_restaurante, COUNT(r) " +
            "FROM Reserva r " +
            "WHERE r.restaurante.id_restaurante = :idRestaurante " +
            "GROUP BY r.restaurante.nombre_restaurante")
    List<Object[]> obtenerNombreYCantidadPorRestaurante(@Param("idRestaurante") int idRestaurante);

}
