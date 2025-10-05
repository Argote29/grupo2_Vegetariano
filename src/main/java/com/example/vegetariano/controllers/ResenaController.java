package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.QueryRestaurantesMasResenadosDTO;
import com.example.vegetariano.dtos.ResenaDTO;
import com.example.vegetariano.entities.Resena;
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
        return rSA.list().stream().map(resena -> {
            ModelMapper m = new ModelMapper();
            ResenaDTO dto = m.map(resena, ResenaDTO.class);
            dto.setId_usuario(resena.getUsuario().getId_usuario());
            dto.setId_restaurante(resena.getRestaurante().getId_restaurante());

            return dto;
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena resena = m.map(dto, Resena.class);

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());

        resena.setUsuario(usuario);
        resena.setRestaurante(restaurante);

        rSA.insert(resena);
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

        // asignar manualmente los IDs
        dto.setId_usuario(resena.getUsuario().getId_usuario());
        dto.setId_restaurante(resena.getRestaurante().getId_restaurante());

        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena resena = m.map(dto, Resena.class);

        // Seteamos usuario y restaurante desde el DTO
        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());

        resena.setUsuario(usuario);
        resena.setRestaurante(restaurante);

        Resena existente = rSA.listId(resena.getId_reseña());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reseña con el ID: " + resena.getId_reseña());
        }

        rSA.update(resena);
        return ResponseEntity.ok("Reseña con ID " + resena.getId_reseña() + " modificada correctamente.");
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
