package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.HistorialSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHistorialSuscripcionRepository extends JpaRepository<HistorialSuscripcion, Integer> {

    @Query(value =
            "SELECT " +
                    "SUM(CASE WHEN h.fecha_final_sub >= CURRENT_DATE THEN 1 ELSE 0 END) AS activos, " +
                    "SUM(CASE WHEN h.fecha_final_sub < CURRENT_DATE THEN 1 ELSE 0 END) AS inactivos " +
                    "FROM historial_suscripcion h",
            nativeQuery = true)
    Object obtenerComparacionActivasInactivas();
}
