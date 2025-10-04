<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.PlatoDTO;
import com.example.vegetariano.dtos.QueryCantidadIngredientesDTO;
<<<<<<< HEAD
=======
import com.example.vegetariano.dtos.ReservaDTO;
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
import com.example.vegetariano.entities.*;
import com.example.vegetariano.serviceinterfaces.IPlatoService;
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
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private IPlatoService pS;
    @Autowired
    private IPlatoService iPlatoService;


    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping
    public List<PlatoDTO> listar() {
        return pS.list().stream().map(plato -> {
            ModelMapper m = new ModelMapper();
            return m.map(plato, PlatoDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody PlatoDTO dto) {
        ModelMapper m = new ModelMapper();
        Plato plato = m.map(dto, Plato.class);

        // Relación con Restaurante
        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());
        plato.setRestaurante(restaurante);

        // Relación con Promoción
        Promociones promociones = new Promociones();
        promociones.setId_Promociones(dto.getId_Promociones());
        plato.setPromociones(promociones);

        pS.insert(plato);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Plato registrada correctamente.");
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Plato plato = pS.listId(id);
        if (plato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un plato con el ID: " + id);
        }
        pS.delete(id);
        return ResponseEntity.ok("Plato con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Plato plato = pS.listId(id);
        if (plato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un plato con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PlatoDTO dto = m.map(plato, PlatoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PlatoDTO dto) {
        ModelMapper m = new ModelMapper();
        Plato plato = m.map(dto, Plato.class);

        Plato existente = pS.listId(plato.getId_plato()); // usa tu getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un plato con el ID: " + plato.getId_plato());
        }

        pS.update(plato);
        return ResponseEntity.ok("Plato con ID " + plato.getId_plato() + " modificado correctamente.");
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping("/cantidad_ingredientes_platos")
    public ResponseEntity<?> contarIngredientesPorPlato() {
        List<QueryCantidadIngredientesDTO> listaDto = new ArrayList<>();
        List<String[]> filas = iPlatoService.cantidadIngredientesPorPlato();

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] x : filas) {
            QueryCantidadIngredientesDTO dto = new QueryCantidadIngredientesDTO(
                    x[0],
                    Long.parseLong(x[1])
            );
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    //Platos y precios por restaurante//
    @GetMapping("/restaurante/{nombre}")
    public ResponseEntity<?> listarPorRestaurante(@PathVariable("nombre") String nombreRestaurante) {
        List<Object[]> platos = iPlatoService.listarPlatosPorRestaurante(nombreRestaurante);

        if (platos.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay restaurante registrado con ese nombre: " + nombreRestaurante);
        }

        return ResponseEntity.ok(platos);
    }


}
<<<<<<< HEAD
=======
=======
package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.PlatoDTO;
import com.example.vegetariano.dtos.QueryCantidadIngredientesDTO;
import com.example.vegetariano.dtos.ReservaDTO;
import com.example.vegetariano.entities.*;
import com.example.vegetariano.serviceinterfaces.IPlatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private IPlatoService pS;
    @Autowired
    private IPlatoService iPlatoService;

    @GetMapping
    public List<PlatoDTO> listar() {
        return pS.list().stream().map(plato -> {
            ModelMapper m = new ModelMapper();
            return m.map(plato, PlatoDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody PlatoDTO dto) {
        ModelMapper m = new ModelMapper();
        Plato plato = m.map(dto, Plato.class);

        // Relación con Restaurante
        Restaurante restaurante = new Restaurante();
        restaurante.setId_restaurante(dto.getId_restaurante());
        plato.setRestaurante(restaurante);

        // Relación con Promoción
        Promociones promociones = new Promociones();
        promociones.setId_Promociones(dto.getId_Promociones());
        plato.setPromociones(promociones);

        pS.insert(plato);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Plato registrada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Plato plato = pS.listId(id);
        if (plato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un plato con el ID: " + id);
        }
        pS.delete(id);
        return ResponseEntity.ok("Plato con ID " + id + " eliminado correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Plato plato = pS.listId(id);
        if (plato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un plato con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PlatoDTO dto = m.map(plato, PlatoDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PlatoDTO dto) {
        ModelMapper m = new ModelMapper();
        Plato plato = m.map(dto, Plato.class);

        Plato existente = pS.listId(plato.getId_plato()); // usa tu getter real
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un plato con el ID: " + plato.getId_plato());
        }

        pS.update(plato);
        return ResponseEntity.ok("Plato con ID " + plato.getId_plato() + " modificado correctamente.");
    }

    @GetMapping("/cantidad_ingredientes_platos")
    public ResponseEntity<?> contarIngredientesPorPlato() {
        List<QueryCantidadIngredientesDTO> listaDto = new ArrayList<>();
        List<String[]> filas = iPlatoService.cantidadIngredientesPorPlato();

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] x : filas) {
            QueryCantidadIngredientesDTO dto = new QueryCantidadIngredientesDTO(
                    x[0],
                    Long.parseLong(x[1])
            );
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }

}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
