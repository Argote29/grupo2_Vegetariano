package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.ReservaDTO;
import com.example.vegetariano.dtos.RestauranteDTO;
import com.example.vegetariano.entities.Reserva;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private IReservaService eRe;

    @GetMapping
    public List<ReservaDTO> listar() {
        return eRe.list().stream().map(reserva -> {
            ReservaDTO dto = new ReservaDTO();
            dto.setId_reserva(reserva.getId_reserva());
            dto.setFecha_reserva(reserva.getFecha_reserva());
            dto.setHora(reserva.getHora());

            if (reserva.getUsuario() != null) {
                dto.setId_usuario(reserva.getUsuario().getId_usuario());
            }
            if (reserva.getRestaurante() != null) {
                dto.setId_restaurante(reserva.getRestaurante().getId_restaurante());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva reserva = m.map(dto, Reserva.class);

        // Relación con Usuario
        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());
        reserva.setUsuario(usuario);

        // Relación con Restaurante
        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());
        reserva.setRestaurante(restaurante);

        eRe.insert(reserva); // tu servicio de Reserva
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reserva registrada correctamente.");
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Reserva reserva = eRe.listId(id);
        if (reserva == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        eRe.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Reserva reserva = eRe.listId(id);
        if (reserva == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        ModelMapper m = new ModelMapper();
        ReservaDTO dto = m.map(reserva, ReservaDTO.class);

        // Asignar manualmente los IDs relacionados
        if (reserva.getUsuario() != null) {
            dto.setId_usuario(reserva.getUsuario().getId_usuario());
        }
        if (reserva.getRestaurante() != null) {
            dto.setId_restaurante(reserva.getRestaurante().getId_restaurante());
        }

        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva reserva = m.map(dto, Reserva.class);

        Reserva existente = eRe.listId(reserva.getId_reserva());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + reserva.getId_reserva());
        }

        // Asignar usuario si viene en el DTO
        if (dto.getId_usuario() > 0) {
            Usuario usuario = new Usuario();
            usuario.setId_usuario(dto.getId_usuario());
            reserva.setUsuario(usuario);
        }

        // Asignar restaurante si viene en el DTO
        if (dto.getId_restaurante() > 0) {
            Restaurante restaurante = new Restaurante();
            restaurante.setId_restaurante(dto.getId_restaurante());
            reserva.setRestaurante(restaurante);
        }

        eRe.update(reserva);
        return ResponseEntity.ok("Reserva con ID " + reserva.getId_reserva() + " modificada correctamente.");
    }
}
