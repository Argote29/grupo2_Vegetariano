package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.QueryRestaurantesMasResenadosDTO;
import com.example.vegetariano.dtos.ResenaDTO;
import com.example.vegetariano.dtos.ReservaDTO;
import com.example.vegetariano.entities.Resena;
import com.example.vegetariano.entities.Reserva;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IResenaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resena")
public class ResenaController {

    @Autowired
    private IResenaService rSA;
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping
    public List<ResenaDTO> listar() {
        return rSA.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ResenaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('CLIENT','ADMIN')")

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        rSA.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reseña registrada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Resena resena = rSA.listId(id);
        if (resena == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        rSA.delete(id);
        return ResponseEntity.ok("Reseña con ID " + id + " eliminada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Resena resena = rSA.listId(id);
        if (resena == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ResenaDTO dto = m.map(resena, ResenaDTO.class);

        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena resena = m.map(dto, Resena.class);

        Resena existente = rSA.listId(resena.getId_resena());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reseña con el ID: " + resena.getId_resena());
        }

        rSA.update(resena);
        return ResponseEntity.ok("Reseña con ID " + resena.getId_resena() + " modificada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/mas-resenados")
    public ResponseEntity<List<QueryRestaurantesMasResenadosDTO>> obtenerMasResenados() {
        List<QueryRestaurantesMasResenadosDTO> lista = rSA.obtenerRestaurantesMasResenados();

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(lista);
    }

}
