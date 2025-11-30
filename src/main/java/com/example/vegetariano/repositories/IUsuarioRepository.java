package com.example.vegetariano.repositories;

import com.example.vegetariano.dtos.QueryPorcentajeUsuarioFiltradoDTO;
import com.example.vegetariano.dtos.QuerySuscripcionActivaDTO;
import com.example.vegetariano.entities.HistorialSuscripcion;
import com.example.vegetariano.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>
{
    @Query(value = "select u.nombre,count(id_reserva) as num_reserva\n" +
            "from Usuario as u\n" +
            "     inner join Reserva as r on u.id_usuario=r.id_usuario\n" +
            "group by nombre",nativeQuery = true)
    List<String[]> QueryReservaUsuario();
    Optional<Usuario> findByCorreo(String correo);

    @Query(value = "SELECT u.nombre, COUNT(re.id_resena) AS total_resenas " +
            "FROM Usuario u " +
            "INNER JOIN Resena re ON u.id_usuario = re.id_usuario " +
            "GROUP BY u.nombre " +
            "ORDER BY total_resenas DESC", nativeQuery = true)
    List<Object[]> usuariosMasResenas();

    @Query(value= """
            SELECT
                    COUNT(*) AS cantidad_usuarios,
                    COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Usuario) AS porcentaje
                    FROM Usuario
                    WHERE genero = :genero
            """, nativeQuery = true)
    QueryPorcentajeUsuarioFiltradoDTO findPromedioUsuariosPorGenero(@Param("genero") String genero);
    
    @Query("SELECT u.id_usuario FROM Usuario u WHERE u.correo = :email")
    Integer findIdUsuarioByCorreo(@Param("email") String email);
}
