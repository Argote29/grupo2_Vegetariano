package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name = "nombre",nullable = false,length = 30)
    private String nombre;
    @Column(name = "apellido",nullable = false,length = 60)
    private String apellido;
    @Column(name = "correo",nullable = false,length = 60, unique = true)
    private String correo;
    @Column(name = "contrasena",nullable = false,length = 100)
    private String contrasena;
    @Column(name = "direccion",nullable = false,length = 60)
    private String direccion;

    @Column(name = "telefono",nullable = false,length = 60)
    private int telefono;
    @Column(name = "genero",nullable = false,length = 9)
    private String genero;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") // FK en tabla rol
    private List<Rol> roles;

    public Usuario() {}

    public Usuario(int id_usuario, String nombre, String apellido, String correo, String contrasena, String direccion, String preferencias_alimenticias, Rol rol, int telefono, String genero) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.roles = roles;
        this.telefono = telefono;
        this.genero = genero;
    }

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

    public List<Rol> getRol() {
        return roles;
    }

    public void setRol(List<Rol> rols) {
        this.roles = rols;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
