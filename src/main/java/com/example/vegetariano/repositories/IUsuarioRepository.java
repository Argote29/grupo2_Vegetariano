package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

}
