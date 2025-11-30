package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.*;
import com.example.vegetariano.entities.Reserva;
import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.serviceinterfaces.IRestauranteService;
import com.example.vegetariano.servicesimplements.RestauranteServiceImplement;
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
        return rService.list().stream().map(rol -> {
            ModelMapper m = new ModelMapper();
            return m.map(rol, RestauranteDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RestauranteDTO dto) {
        ModelMapper m = new ModelMapper();
        Restaurante r = m.map(dto, Restaurante.class);
        rService.insert(r);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Restaurante registrado correctamente.");
    }
    @PreAuthorize("hasRole('ADMIN')")

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

        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasRole('ADMIN')")

    @PutMapping()
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
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")

    @GetMapping("/restaurantePromedioResena")
    public ResponseEntity<?> mostrarPromedioResenas() {
    List<Object[]> resultados = rService.QueryRestaurantePromedioResena();
    List<Query2DTO> listaDTO = new ArrayList<>();
    if (resultados.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontraron registros");
    }
    for (Object[] fila : resultados) {
        Query2DTO dto = new Query2DTO(
                (String) fila[0],                 // nombre_restaurante
                ((Number) fila[1]).doubleValue(), // ✅ promedio (double)
                ((Number) fila[2]).intValue()     // número de reseñas
        );
        listaDTO.add(dto);
    }
    return ResponseEntity.ok(listaDTO);
}

    @GetMapping("/sin-promos")
    public ResponseEntity<?> getSinPromos() {
        List<QueryRestauranteSinPromoDTO> resultados = rService.queryRestaurantesinpromos();
        if (resultados == null || resultados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay restaurantes con 0 promociones");
        }
        return ResponseEntity.ok(resultados);
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/mas-variedad-platos")
    public List<QueryRestaurantesMasVariedadPlatosDTO> obtenerRestaurantesMasVariedadDePlatos() {
        return rService.Queryvariedad();
    }
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/promedio-por-tipo-cocina")
    public List<String[]> obtenerPromedioPorTipoCocina() {
    return rService.QueryPromedioPorTipoCocina();
    }

}

