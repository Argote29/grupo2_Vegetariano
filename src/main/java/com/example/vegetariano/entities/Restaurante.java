package com.example.vegetariano.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_restaurante;

    @Column(name = "nombre_restaurante", length = 30)
    private String nombre_restaurante;

    @Column(name = "direccion", length = 60)
    private String direccion;

    @Column(name = "tipo_cocina", length = 30)
    private String tipo_cocina;

    @Column(name = "horario")
    private String horario;

    @Column(name = "contacto")
    private int contacto;

    public Restaurante() {}

    public Restaurante(int id_restaurante, String nombre_restaurante,
                       String direccion, String tipo_cocina, String horario, int contacto) {
        this.id_restaurante = id_restaurante;
        this.nombre_restaurante = nombre_restaurante;
        this.direccion = direccion;
        this.tipo_cocina = tipo_cocina;
        this.horario = horario;
        this.contacto = contacto;
    }

    // Getters y Setters
    public int getId_restaurante() { return id_restaurante; }
    public void setId_restaurante(int id_restaurante) { this.id_restaurante = id_restaurante; }


    public String getNombre_restaurante() { return nombre_restaurante; }
    public void setNombre_restaurante(String nombre_restaurante) { this.nombre_restaurante = nombre_restaurante; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTipo_cocina() { return tipo_cocina; }
    public void setTipo_cocina(String tipo_cocina) { this.tipo_cocina = tipo_cocina; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public int getContacto() { return contacto; }
    public void setContacto(int contacto) { this.contacto = contacto; }
}