package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.Query2DTO;
import com.example.vegetariano.dtos.RestauranteDTO;
import com.example.vegetariano.dtos.UsuarioDTO;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IRestauranteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private IRestauranteService rService;

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping
    public List<RestauranteDTO> listar(){
        return rService.list()
                .stream()
                .map(restaurante -> {
                    ModelMapper m = new ModelMapper();
                    RestauranteDTO dto = m.map(restaurante, RestauranteDTO.class);
                    dto.setId_usuario(restaurante.getUsuario().getId_usuario()); //  aquí seteamos el id_usuario
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RestauranteDTO dto) {
        ModelMapper m = new ModelMapper();
        Restaurante r = m.map(dto, Restaurante.class);


        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());
        r.setUsuario(usuario);

        rService.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Restaurante registrado correctamente.");
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
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

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id_restaurante) {
        Restaurante restaurante = rService.listId(id_restaurante);

        if (restaurante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un restaurante con el ID: " + id_restaurante);
        }

        ModelMapper m = new ModelMapper();
        RestauranteDTO dto = m.map(restaurante, RestauranteDTO.class);


        dto.setId_usuario(restaurante.getUsuario().getId_usuario());

        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@PathVariable("id") Integer id_restaurante,
                                            @RequestBody RestauranteDTO dto) {
        Restaurante existente = rService.listId(id_restaurante);

        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un restaurante con el ID: " + id_restaurante);
        }

        ModelMapper m = new ModelMapper();
        Restaurante restaurante = m.map(dto, Restaurante.class);


        restaurante.setId_restaurante(id_restaurante);


        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());
        restaurante.setUsuario(usuario);

        rService.update(restaurante);

        return ResponseEntity.ok("Restaurante con ID " + id_restaurante + " modificado correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping("RestaurantePromedioResena")
    public ResponseEntity<?> Mostrar() {
        List<String[]> fila=rService.QueryRestaurantePromedioResena();
        List<Query2DTO> listaDTO = new ArrayList<>();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }
        return ResponseEntity.ok(listaDTO);
    }

}

