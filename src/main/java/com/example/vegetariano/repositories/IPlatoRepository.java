package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatoRepository extends JpaRepository<Plato,Integer> {
}
