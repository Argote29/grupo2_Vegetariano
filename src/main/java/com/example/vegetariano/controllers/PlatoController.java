package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.PlatoDTO;
import com.example.vegetariano.entities.Plato;
import com.example.vegetariano.serviceinterfaces.IPlatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private IPlatoService pS;

    @GetMapping
    public List<PlatoDTO> listar() {
        return pS.list().stream().map(plato -> {
            ModelMapper m = new ModelMapper();
            return m.map(plato, PlatoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody PlatoDTO dto) {
        ModelMapper m = new ModelMapper();
        Plato e = m.map(dto, Plato.class);
        pS.insert(e);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Plato plato = pS.listId(id);
        if (plato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un plato con el ID: " + id);
        }
        pS.delete(id);
        return ResponseEntity.ok("Plato con ID " + id + " eliminado correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Plato plato = pS.listId(id);
        if (plato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un plato con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PlatoDTO dto = m.map(plato, PlatoDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PlatoDTO dto) {
        ModelMapper m = new ModelMapper();
        Plato plato = m.map(dto, Plato.class);

        Plato existente = pS.listId(plato.getId_plato()); // usa tu getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un plato con el ID: " + plato.getId_plato());
        }

        pS.update(plato);
        return ResponseEntity.ok("Plato con ID " + plato.getId_plato() + " modificado correctamente.");
    }

}
