package com.example.vegetariano.repositories;


import com.example.vegetariano.entities.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResenaRepository extends JpaRepository<Reseña,Integer> {
}
