package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.PromocionesDTO;
import com.example.vegetariano.entities.Promociones;
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
        return repo.list().stream().map(promociones -> {
            ModelMapper m = new ModelMapper();
            return m.map(promociones, PromocionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody PromocionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Promociones e = m.map(dto, Promociones.class);
        repo.insert(e);
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
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PromocionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Promociones promo = m.map(dto, Promociones.class);

        Promociones existente = repo.listId(promo.getId_Promociones()); // usa tu getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una promoción con el ID: " + promo.getId_Promociones());
        }

        repo.update(promo);
        return ResponseEntity.ok("Promoción con ID " + promo.getId_Promociones() + " modificada correctamente.");
    }
}
