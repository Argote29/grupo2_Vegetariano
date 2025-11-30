package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.*;
import com.example.vegetariano.entities.HistorialSuscripcion;
import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import com.example.vegetariano.serviceinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uR;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);

        String contrasenaEncriptada = passwordEncoder.encode(dto.getContrasena());
        u.setContrasena(contrasenaEncriptada);

        uR.insert(u);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado correctamente.");
    }
    @PreAuthorize("hasAnyRole('ADMIN')")

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);

        if (dto.getContrasena() != null && !dto.getContrasena().isEmpty()) {
            // Encriptar nueva contraseña
            String contrasenaEncriptada = passwordEncoder.encode(dto.getContrasena());
            u.setContrasena(contrasenaEncriptada);
        }

        uR.update(u);
        return ResponseEntity.ok("Registro con ID " + u.getId_usuario() + " modificado correctamente.");
    }


    @PreAuthorize("hasRole('ADMIN')")

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario usuario = uR.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un Usuario con el ID: " + id);
        }
        uR.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/agruparReservaUsuario")
    public ResponseEntity<?> contar() {
        List<String[]> fila = uR.QueryReservaUsuario();
        List<Query1DTO> listaDTO = new ArrayList<>();
        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }
        for (String[] columna : fila) {
            Query1DTO dto = new Query1DTO();
            dto.setNombre(columna[0]);
            dto.setNum_reserva(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);}
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario u = uR.listId(id);
        if (u == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(u, UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")

    @GetMapping("/porcentaje-genero")
    public ResponseEntity<?> obtenerPorcentajePorGenero(@RequestParam String genero) {
        QueryPorcentajeUsuarioFiltradoDTO resultadoDTO =
                uR.getPorcentajeUsuariosPorGenero(genero);

        if (resultadoDTO == null || resultadoDTO.getCantidadUsuarios() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con el género: " + genero);
        }
        return ResponseEntity.ok(resultadoDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/mas-resenas")
    public ResponseEntity<List<QueryUsuarioMasResenaDTO>> obtenerUsuariosConMasResenas() {
        List<QueryUsuarioMasResenaDTO> usuarios = uR.obtenerUsuariosMasResenas();

        return ResponseEntity.ok(usuarios);
    }
}
