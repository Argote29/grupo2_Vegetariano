package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.PromocionesDTO;
import com.example.vegetariano.dtos.ResenaDTO;
import com.example.vegetariano.dtos.ReservaDTO;
import com.example.vegetariano.entities.Promociones;
import com.example.vegetariano.entities.Resena;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.serviceinterfaces.IPromocionesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/promociones")
public class PromocionesController {

    @Autowired
    private IPromocionesService repo;


    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping
    public List<PromocionesDTO> listar() {
        return repo.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PromocionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody PromocionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Promociones r = m.map(dto, Promociones.class);
        repo.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Promocion registrada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Promociones promo = repo.listId(id);
        if (promo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una promoción con el ID: " + id);
        }
        repo.delete(id);
        return ResponseEntity.ok("Promoción con ID " + id + " eliminada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Promociones promo = repo.listId(id);
        if (promo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PromocionesDTO dto = m.map(promo, PromocionesDTO.class);

        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PromocionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Promociones promo = m.map(dto, Promociones.class);

        Promociones existente = repo.listId(promo.getId_Promociones());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una promoción con el ID: " + promo.getId_Promociones());
        }

        repo.update(promo);
        return ResponseEntity.ok("Promoción con ID " + promo.getId_Promociones() + " modificada correctamente.");
    }
}
