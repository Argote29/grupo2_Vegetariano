package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.ResenaDTO;
import com.example.vegetariano.entities.Reseña;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IResenaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resena")
public class ResenaController {

    @Autowired
    private IResenaService rSA;

    @GetMapping
    public List<ResenaDTO> listar() {
        return rSA.list().stream().map(reseña -> {
            ModelMapper m = new ModelMapper();
            ResenaDTO dto = m.map(reseña, ResenaDTO.class);
            dto.setId_usuario(reseña.getUsuario().getId_usuario());
            dto.setId_restaurante(reseña.getRestaurante().getId_restaurante());

            return dto;
        }).collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reseña reseña = m.map(dto, Reseña.class);

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());

        reseña.setUsuario(usuario);
        reseña.setRestaurante(restaurante);

        rSA.insert(reseña);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reseña registrada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Reseña reseña = rSA.listId(id);
        if (reseña == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        rSA.delete(id);
        return ResponseEntity.ok("Reseña con ID " + id + " eliminada correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Reseña reseña = rSA.listId(id);
        if (reseña == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ResenaDTO dto = m.map(reseña, ResenaDTO.class);

        // asignar manualmente los IDs
        dto.setId_usuario(reseña.getUsuario().getId_usuario());
        dto.setId_restaurante(reseña.getRestaurante().getId_restaurante());

        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reseña reseña = m.map(dto, Reseña.class);

        // Seteamos usuario y restaurante desde el DTO
        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());

        reseña.setUsuario(usuario);
        reseña.setRestaurante(restaurante);

        Reseña existente = rSA.listId(reseña.getId_reseña());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reseña con el ID: " + reseña.getId_reseña());
        }

        rSA.update(reseña);
        return ResponseEntity.ok("Reseña con ID " + reseña.getId_reseña() + " modificada correctamente.");
    }

}
