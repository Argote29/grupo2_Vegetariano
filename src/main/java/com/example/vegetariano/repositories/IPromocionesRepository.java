package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Promociones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromocionesRepository extends JpaRepository<Promociones, Integer> {
}
