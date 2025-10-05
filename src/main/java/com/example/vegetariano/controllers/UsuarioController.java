package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.Query1DTO;
import com.example.vegetariano.dtos.QueryUsuarioMasResenaDTO;
import com.example.vegetariano.dtos.UsuarioDTO;
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
    public List<UsuarioDTO> listar(){
        return uR.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setCorreo(dto.getCorreo());
        u.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        u.setDireccion(dto.getDireccion());
        u.setGenero(dto.getGenero());
        u.setTelefono(dto.getTelefono());

        Rol rol = new Rol();
        rol.setId_rol(dto.getId_rol());
        u.setRol(rol);

        uR.insert(u);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/agruparReservaUsuario")
    public ResponseEntity<?> contar() {
        List<String[]> fila=uR.QueryReservaUsuario();
        List<Query1DTO> listaDTO = new ArrayList<>();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }
        return ResponseEntity.ok(listaDTO);
    }
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping("/mas-resenas")
    public List<QueryUsuarioMasResenaDTO> obtenerUsuariosMasResenas() {
        return uR.obtenerUsuariosMasResenas();
    }
}
