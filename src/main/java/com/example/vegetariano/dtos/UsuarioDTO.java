package com.example.vegetariano.dtos;

import com.example.vegetariano.entities.Rol;
import com.example.vegetariano.entities.Usuario;

import javax.management.relation.Role;

public class UsuarioDTO
{
    private int id_usuario;

    private String nombre;

    private String apellido;

    private String correo;

    private String contrasena;

    private String direccion;

    private String preferencias_alimenticias;

    private String genero;

    private int id_rol;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPreferencias_alimenticias() {
        return preferencias_alimenticias;
    }

    public void setPreferencias_alimenticias(String preferencias_alimenticias) {
        this.preferencias_alimenticias = preferencias_alimenticias;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }
}




