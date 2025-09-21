package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.UsuarioDTO;
import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import com.example.vegetariano.serviceinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uR;
    @GetMapping
    public List<UsuarioDTO> listar(){
        return uR.list()
                .stream()
                .map(usuario -> {
                    ModelMapper m = new ModelMapper();
                    UsuarioDTO dto = m.map(usuario, UsuarioDTO.class);
                    dto.setId_rol(usuario.getRol().getId_rol()); // extrae el id del rol
                    return dto;
                })
                .collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);


        Rol rol = new Rol();
        rol.setId_rol(dto.getId_rol());
        u.setRol(rol);

        uR.insert(u);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado correctamente.");
    }

}
