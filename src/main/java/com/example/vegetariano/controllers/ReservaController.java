package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.HistorialSuscripcionDTO;
import com.example.vegetariano.dtos.QueryCantidadDeReservasPorRestauranteDTO;
import com.example.vegetariano.dtos.ReservaDTO;
import com.example.vegetariano.entities.Reserva;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private IReservaService eRe;

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping
    public List<ReservaDTO> listar() {
        return eRe.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReservaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva r = m.map(dto, Reserva.class);
        eRe.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reserva registrada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")

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
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Reserva r = eRe.listId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ReservaDTO dto = m.map(r, ReservaDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva reserva = m.map(dto, Reserva.class);

        Reserva existente = eRe.listId(reserva.getId_reserva());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + reserva.getId_reserva());
        }

        eRe.update(reserva);
        return ResponseEntity.ok("Reserva con ID " + reserva.getId_reserva() + " modificada correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")

    @GetMapping("/resumen/{idRestaurante}")
    public ResponseEntity<?> obtenerResumenPorRestaurante(@PathVariable int idRestaurante) {
        List<QueryCantidadDeReservasPorRestauranteDTO> resultado = eRe.obtenerNombreYCantidadPorRestaurante(idRestaurante);

        if (resultado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron reservas para el restaurante con ID " + idRestaurante);
        }
        return ResponseEntity.ok(resultado.get(0));
    }
}
