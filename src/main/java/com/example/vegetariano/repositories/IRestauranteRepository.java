package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
