package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.HistorialSuscripcionDTO;
import com.example.vegetariano.entities.HistorialSuscripcion;
import com.example.vegetariano.serviceinterfaces.IHistorialSuscripcionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historialSuscripcion")
public class HistorialSuscripcionController {

    @Autowired
    private IHistorialSuscripcionService hSU;


    @GetMapping
    public List<HistorialSuscripcionDTO> listar() {
        return hSU.list().stream().map(historialSuscripcion -> {
            ModelMapper m = new ModelMapper();
            return m.map(historialSuscripcion, HistorialSuscripcionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody HistorialSuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        HistorialSuscripcion e = m.map(dto, HistorialSuscripcion.class);
        hSU.insert(e);
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

        HistorialSuscripcion existente = hSU.listId(historial.getId_historial()); // usa tu getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un historial de suscripción con el ID: " + historial.getId_historial());
        }

        hSU.update(historial);
        return ResponseEntity.ok("Historial de suscripción con ID " + historial.getId_historial() + " modificado correctamente.");
    }
}
