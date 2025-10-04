package com.example.vegetariano.securities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
<<<<<<< HEAD
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
=======
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

<<<<<<< HEAD
    // 5 horas en milisegundos
=======

>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

<<<<<<< HEAD
    // =========================================================
    // MÉTODOS DE OBTENCIÓN DE CLAIMS
    // =========================================================
=======
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

<<<<<<< HEAD
=======

>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

<<<<<<< HEAD
=======
    // Método genérico para obtener cualquier claim
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

<<<<<<< HEAD
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
=======

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

<<<<<<< HEAD
=======

>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

<<<<<<< HEAD
    // =========================================================
    // GENERACIÓN DE TOKEN
    // =========================================================

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        // Guardamos roles como lista en el claim "roles"
        claims.put("roles", userDetails.getAuthorities().stream()
                .map(r -> r.getAuthority())
                .collect(Collectors.toList()));

        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject) // correo del usuario
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    // =========================================================
    // VALIDACIÓN
    // =========================================================
=======

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities().stream()
                .map(r -> r.getAuthority())
                .collect(Collectors.joining()));
        return doGenerateToken(claims, userDetails.getUsername());
    }


    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS512.getJcaName()))
                .compact();
    }

>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
<<<<<<< HEAD

    // =========================================================
    // CLAVE SECRETA
    // =========================================================

    private Key getSigningKey() {
        // usamos la clave como texto plano en UTF-8
        return new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
                SignatureAlgorithm.HS512.getJcaName());
    }
}
=======
}
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
