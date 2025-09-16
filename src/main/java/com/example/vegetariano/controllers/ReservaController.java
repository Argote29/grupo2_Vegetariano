package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.ReservaDTO;
import com.example.vegetariano.entities.Reserva;
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
            ModelMapper m = new ModelMapper();
            return m.map(reserva, ReservaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva r = m.map(dto, Reserva.class);
        eRe.insert(r);
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
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva reserva= m.map(dto, Reserva.class);

        Reserva existente = eRe.listId(reserva.getId_reserva());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + reserva.getId_reserva());
        }

        eRe.update(reserva);
        return ResponseEntity.ok("Reserva con ID " + reserva.getId_reserva() + " modificado correctamente.");
    }
}
