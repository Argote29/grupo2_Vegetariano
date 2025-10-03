package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.RolDTO;
import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.serviceinterfaces.IRolService;
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
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(rol -> {
            ModelMapper m = new ModelMapper();
            return m.map(rol, RolDTO.class);
        }).collect(Collectors.toList());
    }
<<<<<<< HEAD

    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rolService.insert(r);
    }
<<<<<<< HEAD

    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Rol rol = rolService.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rolService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
<<<<<<< HEAD

    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Rol rol = rolService.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
        return ResponseEntity.ok(dto);
    }
<<<<<<< HEAD

    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);

        Rol existente = rolService.listId(rol.getId_rol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + rol.getId_rol());
        }

        rolService.update(rol);
        return ResponseEntity.ok("Rol con ID " + rol.getId_rol() + " modificado correctamente.");
    }


}
