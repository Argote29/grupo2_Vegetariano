package com.example.vegetariano.dtos;

import java.io.Serializable;

public class JwtRequestDTO implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String correo;
    private String contrasena;

    public JwtRequestDTO() {
        super();
    }

    public JwtRequestDTO(String correo, String contrasena) {
        super();
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}