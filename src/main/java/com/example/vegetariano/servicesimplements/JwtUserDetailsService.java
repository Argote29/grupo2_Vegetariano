package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

<<<<<<< HEAD
    private final IUsuarioRepository usuarioRepository;

    public JwtUserDetailsService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));

        Set<GrantedAuthority> authorities = new HashSet<>();
        Rol rol = usuario.getRol();
        if (rol != null && rol.getNombre() != null && !rol.getNombre().isBlank()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre().trim().toUpperCase()));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        // Si manejas cuenta deshabilitada/bloqueada/expirada, pásalos aquí:
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),     // Debe estar BCRYPT en BD
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                authorities
        );
    }
}
=======
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);

        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + correo);
        }

        Usuario usuario = usuarioOpt.get();

        Set<GrantedAuthority> authorities = new HashSet<>();

        Rol rol = usuario.getRol();
        if (rol != null && rol.getNombre() != null && !rol.getNombre().isBlank()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre()));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // Por defecto
        }

        return new User(usuario.getCorreo(), usuario.getContrasena(), authorities);
    }
    
}
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
