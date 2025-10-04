package com.example.vegetariano.securities;

<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<<<<<<< HEAD
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.vegetariano.servicesimplements.JwtUserDetailsService; //

import java.io.IOException;
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

<<<<<<< HEAD
    private final JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
=======
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
<<<<<<< HEAD
        String username = null;
        String jwtToken = null;

=======

        String username = null;
        String jwtToken = null;


>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                logger.error("No se puede obtener el token JWT", e);
            } catch (ExpiredJwtException e) {
                logger.warn("Token JWT ha expirado");
            }
        } else {
<<<<<<< HEAD
            logger.debug("JWT Token no inicia con Bearer");
        }

        // Si obtuvimos username y todavía no hay autenticación en el contexto
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Claims claims = jwtTokenUtil.getAllClaimsFromToken(jwtToken);

            // Recuperamos los roles desde el claim "roles"
            List<String> roles = claims.get("roles", List.class);

            Collection<? extends GrantedAuthority> authorities = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

=======
            logger.warn("JWT Token no inicia con Bearer");
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
        chain.doFilter(request, response);
    }
}
