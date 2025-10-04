package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.HistorialSuscripcionDTO;
import com.example.vegetariano.entities.HistorialSuscripcion;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IHistorialSuscripcionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historialSuscripcion")
public class HistorialSuscripcionController {

    @Autowired
    private IHistorialSuscripcionService hSU;

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @GetMapping
    public List<HistorialSuscripcionDTO> listar() {
        return hSU.list().stream().map(historial -> {
            ModelMapper m = new ModelMapper();
            HistorialSuscripcionDTO dto = m.map(historial, HistorialSuscripcionDTO.class);
            dto.setId_usuario(historial.getUsuario().getId_usuario());
            return dto;
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody HistorialSuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        HistorialSuscripcion h = m.map(dto, HistorialSuscripcion.class);

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());
        h.setUsuario(usuario);

       
        if (h.getFecha_final_sub() != null && h.getFecha_final_sub().isBefore(h.getFecha_inico_sub())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La fecha final no puede ser anterior a la fecha de inicio.");
        }

        hSU.insert(h);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Historial de suscripción registrado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        HistorialSuscripcion historial = hSU.listId(id);
        if (historial == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un historial de suscripción con el ID: " + id);
        }
        hSU.delete(id);
        return ResponseEntity.ok("Historial de suscripción con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        HistorialSuscripcion historial = hSU.listId(id);
        if (historial == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un historial de suscripción con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        HistorialSuscripcionDTO dto = m.map(historial, HistorialSuscripcionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody HistorialSuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        HistorialSuscripcion historial = m.map(dto, HistorialSuscripcion.class);

        HistorialSuscripcion existente = hSU.listId(historial.getId_historial()); 
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un historial de suscripción con el ID: " + historial.getId_historial());
        }

        hSU.update(historial);
        return ResponseEntity.ok("Historial de suscripción con ID " + historial.getId_historial() + " modificado correctamente.");
    }
}

