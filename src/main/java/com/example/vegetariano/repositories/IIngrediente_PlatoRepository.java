package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Ingrediente_Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IIngrediente_PlatoRepository extends JpaRepository<Ingrediente_Plato,Integer> {
    @Query("SELECT ip FROM Ingrediente_Plato ip WHERE ip.plato.id_plato = :idPlato")
    List<Ingrediente_Plato> findByIdPlato(int idPlato);
    @Query(value = """
    SELECT 
    p.id_plato,p.nombre_plato,p.precio_plato, p.info_nutricional, i.nombre_ingrediente, ip.cantidad,
    ip.tipo_unidad FROM ingrediente_plato ip
      INNER JOIN plato p ON ip.id_plato = p.id_plato
      INNER JOIN ingredientes i ON ip.id_ingrediente = i.id_ingredientes
    ORDER BY p.id_plato""", nativeQuery = true)
    List<Object[]> obtenerPlatosConIngredientes();
}
