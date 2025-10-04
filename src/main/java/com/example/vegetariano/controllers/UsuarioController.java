package com.example.vegetariano.controllers;


<<<<<<< HEAD
import com.example.vegetariano.dtos.Query1DTO;
import com.example.vegetariano.dtos.UsuarioDTO;
import com.example.vegetariano.entities.Rol;
=======
<<<<<<< HEAD
import com.example.vegetariano.dtos.Query1DTO;
import com.example.vegetariano.dtos.UsuarioDTO;
=======
import com.example.vegetariano.dtos.UsuarioDTO;
import com.example.vegetariano.entities.Rol;
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import com.example.vegetariano.serviceinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
=======
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
=======
import org.springframework.web.bind.annotation.*;

>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
import java.util.List;
import java.util.stream.Collectors;

@RestController
<<<<<<< HEAD
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uR;
    @Autowired
    private PasswordEncoder passwordEncoder;
=======
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uR;
<<<<<<< HEAD
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT','RESTAURANT')")
    @GetMapping
    public List<UsuarioDTO> listar(){
        return uR.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
<<<<<<< HEAD
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

=======
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
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
<<<<<<< HEAD
=======
=======
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

>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
}
