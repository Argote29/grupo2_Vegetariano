package com.example.vegetariano.repositories;

import com.example.vegetariano.dtos.QuerySuscripcionActivaDTO;
import com.example.vegetariano.entities.HistorialSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialSuscripcionRepository extends JpaRepository<HistorialSuscripcion,Integer> {

    @Query(value = "SELECT u.nombre, h.fecha_final_sub " +
            "FROM historial_suscripcion h " +
            "JOIN usuario u ON h.id_usuario = u.id_usuario " +
            "WHERE h.fecha_final_sub >= CURRENT_DATE",
            nativeQuery = true)
    List<Object[]> findSuscripcionesActivas();
}
