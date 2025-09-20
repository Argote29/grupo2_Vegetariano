package com.example.vegetariano.controllers;


import com.example.vegetariano.dtos.Query1DTO;
import com.example.vegetariano.dtos.UsuarioDTO;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import com.example.vegetariano.serviceinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uR;
    @GetMapping
    public List<UsuarioDTO> listar(){
        return uR.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uR.insert(u);
    }
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
}
