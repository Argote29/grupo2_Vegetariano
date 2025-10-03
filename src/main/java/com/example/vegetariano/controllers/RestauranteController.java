package com.example.vegetariano.controllers;

<<<<<<< HEAD
import com.example.vegetariano.dtos.Query2DTO;
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
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
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
=======
import org.springframework.web.bind.annotation.*;

>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private IRestauranteService rService;

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
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

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
=======

>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
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

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
=======




>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
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

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
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

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
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
<<<<<<< HEAD
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

=======
}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
