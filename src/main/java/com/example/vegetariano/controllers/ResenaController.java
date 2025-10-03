package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.ResenaDTO;
<<<<<<< HEAD
import com.example.vegetariano.entities.Resena;
=======
import com.example.vegetariano.entities.Reseña;
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IResenaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resena")
public class ResenaController {

    @Autowired
    private IResenaService rSA;

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping
    public List<ResenaDTO> listar() {
        return rSA.list().stream().map(resena -> {
            ModelMapper m = new ModelMapper();
            ResenaDTO dto = m.map(resena, ResenaDTO.class);
            dto.setId_usuario(resena.getUsuario().getId_usuario());
            dto.setId_restaurante(resena.getRestaurante().getId_restaurante());
=======
    @GetMapping
    public List<ResenaDTO> listar() {
        return rSA.list().stream().map(reseña -> {
            ModelMapper m = new ModelMapper();
            ResenaDTO dto = m.map(reseña, ResenaDTO.class);
            dto.setId_usuario(reseña.getUsuario().getId_usuario());
            dto.setId_restaurante(reseña.getRestaurante().getId_restaurante());
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86

            return dto;
        }).collect(Collectors.toList());
    }
<<<<<<< HEAD

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena resena = m.map(dto, Resena.class);
=======
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reseña reseña = m.map(dto, Reseña.class);
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());

<<<<<<< HEAD
        resena.setUsuario(usuario);
        resena.setRestaurante(restaurante);

        rSA.insert(resena);
=======
        reseña.setUsuario(usuario);
        reseña.setRestaurante(restaurante);

        rSA.insert(reseña);
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reseña registrada correctamente.");
    }

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Resena resena = rSA.listId(id);
        if (resena == null) {
=======
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Reseña reseña = rSA.listId(id);
        if (reseña == null) {
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        rSA.delete(id);
        return ResponseEntity.ok("Reseña con ID " + id + " eliminada correctamente.");
    }

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Resena resena = rSA.listId(id);
        if (resena == null) {
=======
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Reseña reseña = rSA.listId(id);
        if (reseña == null) {
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una reseña con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
<<<<<<< HEAD
        ResenaDTO dto = m.map(resena, ResenaDTO.class);

        // asignar manualmente los IDs
        dto.setId_usuario(resena.getUsuario().getId_usuario());
        dto.setId_restaurante(resena.getRestaurante().getId_restaurante());
=======
        ResenaDTO dto = m.map(reseña, ResenaDTO.class);

        // asignar manualmente los IDs
        dto.setId_usuario(reseña.getUsuario().getId_usuario());
        dto.setId_restaurante(reseña.getRestaurante().getId_restaurante());
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86

        return ResponseEntity.ok(dto);
    }

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena resena = m.map(dto, Resena.class);
=======
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reseña reseña = m.map(dto, Reseña.class);
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86

        // Seteamos usuario y restaurante desde el DTO
        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());

        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());

<<<<<<< HEAD
        resena.setUsuario(usuario);
        resena.setRestaurante(restaurante);

        Resena existente = rSA.listId(resena.getId_reseña());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reseña con el ID: " + resena.getId_reseña());
        }

        rSA.update(resena);
        return ResponseEntity.ok("Reseña con ID " + resena.getId_reseña() + " modificada correctamente.");
=======
        reseña.setUsuario(usuario);
        reseña.setRestaurante(restaurante);

        Reseña existente = rSA.listId(reseña.getId_reseña());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reseña con el ID: " + reseña.getId_reseña());
        }

        rSA.update(reseña);
        return ResponseEntity.ok("Reseña con ID " + reseña.getId_reseña() + " modificada correctamente.");
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
    }

}
