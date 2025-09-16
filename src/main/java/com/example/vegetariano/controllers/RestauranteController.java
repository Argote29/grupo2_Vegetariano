package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.RestauranteDTO;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IRestauranteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private IRestauranteService rService;

    @GetMapping
    public List<RestauranteDTO> listar() {
        return rService.list().stream().map(restaurante -> {
            ModelMapper m = new ModelMapper();
            RestauranteDTO dto = m.map(restaurante, RestauranteDTO.class);
            dto.setId_usuario(restaurante.getUsuario().getId_usuario());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RestauranteDTO dto) {
        ModelMapper m = new ModelMapper();
        Restaurante restaurante = m.map(dto, Restaurante.class);

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());
        restaurante.setUsuario(usuario);

        rService.insert(restaurante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Restaurante restaurante = rService.listId(id);
        if (restaurante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Restaurante restaurante = rService.listId(id);
        if (restaurante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RestauranteDTO dto = m.map(restaurante, RestauranteDTO.class);
        dto.setId_usuario(restaurante.getUsuario().getId_usuario());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RestauranteDTO dto) {
        ModelMapper m = new ModelMapper();
        Restaurante restaurante = m.map(dto, Restaurante.class);


        Restaurante existente = rService.listId(restaurante.getId_restaurante());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + restaurante.getId_restaurante());
        }

        rService.update(restaurante);
        return ResponseEntity.ok("Restaurante con ID " + restaurante.getId_restaurante() + " modificado correctamente.");
    }
}
