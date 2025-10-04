package com.example.vegetariano.repositories;

import com.example.vegetariano.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva,Integer> {
}
