<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
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
<<<<<<< HEAD
=======
=======
package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
