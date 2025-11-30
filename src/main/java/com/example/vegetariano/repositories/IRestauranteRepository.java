package com.example.vegetariano.repositories;

import com.example.vegetariano.dtos.QueryRestauranteSinPromoDTO;
import com.example.vegetariano.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer> {

    @Query(value = "SELECT nombre_restaurante, avg(calificacion) AS promCalificacion, " +
        "count(id_resena) AS numeroResena " +
        "FROM Restaurante AS r " +
        "INNER JOIN Resena AS re ON r.id_restaurante = re.id_restaurante " +
        "INNER JOIN Usuario AS u ON u.id_usuario = re.id_usuario " +
        "GROUP BY nombre_restaurante " +
        "ORDER BY promCalificacion DESC",
        nativeQuery = true)
List<Object[]> QueryRestaurantePromedioResena();

    @Query(value = """
    SELECT r.id_restaurante, r.nombre_restaurante
    FROM Restaurante r
    LEFT JOIN Promociones p ON p.id_restaurante = r.id_restaurante
    WHERE p.id_promociones IS NULL
    ORDER BY r.nombre_restaurante
    """, nativeQuery = true)
    List<Object[]> queryRestaurantesinpromos();

    @Query(value = "SELECT r.nombre_restaurante, COUNT(p.id_plato) AS total_platos " +
                  "FROM restaurante r " +
                  "INNER JOIN plato p ON r.id_restaurante = p.id_restaurante " +
                  "GROUP BY r.nombre_restaurante " +
                  "ORDER BY total_platos DESC",
          nativeQuery = true)
    List<String[]> QueryRestaurantesMasVariedadPlatos();

    @Query(value = "SELECT r.tipo_cocina, ROUND(AVG(re.calificacion),2) AS promedio_calificacion " +
               "FROM restaurante r " +
               "INNER JOIN reseña re ON r.id_restaurante = re.id_restaurante " +
               "GROUP BY r.tipo_cocina " +
               "ORDER BY promedio_calificacion DESC",
       nativeQuery = true)
    List<String[]> QueryPromedioPorTipoCocina();
}



