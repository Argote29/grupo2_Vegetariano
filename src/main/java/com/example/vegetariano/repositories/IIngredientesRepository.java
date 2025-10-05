package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Ingredientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientesRepository extends JpaRepository<Ingredientes,Integer> {
}
