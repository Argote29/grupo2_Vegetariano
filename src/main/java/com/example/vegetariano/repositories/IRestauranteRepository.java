package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer> {
    @Query(value = "select nombre_restaurante, avg(calificacion) as prom_calificacion, \n" +
            "       count(id_reseña) as numero_reseña\n" +
            "from Restaurante as r \n" +
            "     inner join Reseña as re on r.id_restaurante=re.id_restaurante\n" +
            "     inner join Usuario as u on u.id_usuario=re.id_usuario\n" +
            "group by nombre_restaurante\n" +
            "order by prom_calificacion desc",nativeQuery = true)
    List<String[]> QueryRestaurantePromedioResena();
}
