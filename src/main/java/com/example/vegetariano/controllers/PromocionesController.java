package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.PromocionesDTO;
import com.example.vegetariano.entities.Promociones;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.serviceinterfaces.IPromocionesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/promociones")
public class PromocionesController {

    @Autowired
    private IPromocionesService repo;

    @GetMapping
    public List<PromocionesDTO> listar() {
        return repo.list().stream().map(promocion -> {
            ModelMapper m = new ModelMapper();
            PromocionesDTO dto = m.map(promocion, PromocionesDTO.class);

            if (promocion.getRestaurante() != null) {
                dto.setId_restaurante(promocion.getRestaurante().getId_restaurante());
            }

            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody PromocionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Promociones p = m.map(dto, Promociones.class);

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());
        p.setRestaurante(restaurante);
        repo.insert(p);
    }

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

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Promociones promo = repo.listId(id);
        if (promo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una promoción con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PromocionesDTO dto = m.map(promo, PromocionesDTO.class);


        if (promo.getRestaurante() != null) {
            dto.setId_restaurante(promo.getRestaurante().getId_restaurante());
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PromocionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Promociones promo = m.map(dto, Promociones.class);


        if (dto.getId_restaurante() > 0) {
            Restaurante restaurante = new Restaurante();
            restaurante.setId_restaurante(dto.getId_restaurante());
            promo.setRestaurante(restaurante);
        }

        Promociones existente = repo.listId(promo.getId_Promociones()); // usa el getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una promoción con el ID: " + promo.getId_Promociones());
        }

        repo.update(promo);
        return ResponseEntity.ok("Promoción con ID " + promo.getId_Promociones() + " modificada correctamente.");
    }
}
