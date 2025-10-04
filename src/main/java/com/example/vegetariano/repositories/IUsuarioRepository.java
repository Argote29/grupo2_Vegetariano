package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
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

<<<<<<< HEAD
=======
=======
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>
{
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
}
