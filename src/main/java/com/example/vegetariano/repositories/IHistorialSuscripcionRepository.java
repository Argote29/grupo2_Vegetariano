package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.HistorialSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialSuscripcionRepository extends JpaRepository<HistorialSuscripcion,Integer> {
}
