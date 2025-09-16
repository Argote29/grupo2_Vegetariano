package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.IngredientesDTO;
import com.example.vegetariano.entities.Ingredientes;
import com.example.vegetariano.serviceinterfaces.IIngredientesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredientes")
public class IngredientesController {

    @Autowired
    private IIngredientesService iIG;

    @GetMapping
    public List<IngredientesDTO> listar() {
        return iIG.list().stream().map(ingredientes -> {
            ModelMapper m = new ModelMapper();
            return m.map(ingredientes, IngredientesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody IngredientesDTO dto) {
        ModelMapper m = new ModelMapper();
        Ingredientes e = m.map(dto, Ingredientes.class);
        iIG.insert(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Ingredientes ingrediente = iIG.listId(id);
        if (ingrediente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un ingrediente con el ID: " + id);
        }
        iIG.delete(id);
        return ResponseEntity.ok("Ingrediente con ID " + id + " eliminado correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Ingredientes ingrediente = iIG.listId(id);
        if (ingrediente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un ingrediente con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        IngredientesDTO dto = m.map(ingrediente, IngredientesDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody IngredientesDTO dto) {
        ModelMapper m = new ModelMapper();
        Ingredientes ingrediente = m.map(dto, Ingredientes.class);

        Ingredientes existente = iIG.listId(ingrediente.getId_ingredientes()); // usa tu getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un ingrediente con el ID: " + ingrediente.getId_ingredientes());
        }

        iIG.update(ingrediente);
        return ResponseEntity.ok("Ingrediente con ID " + ingrediente.getId_ingredientes() + " modificado correctamente.");
    }

}
