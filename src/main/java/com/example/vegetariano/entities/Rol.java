package com.example.vegetariano.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "Rol",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","nombre"})})
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;


    public Rol() {}

    public Rol(int id_rol, String nombre) {
        this.id_rol = id_rol;
        this.nombre = nombre;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
