<<<<<<< HEAD
package com.example.vegetariano.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
=======
<<<<<<< HEAD
package com.example.vegetariano.dtos;

import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import jakarta.persistence.Column;
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private int id_reserva;
<<<<<<< HEAD

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_reserva;

    @Schema(type = "string", example = "18:30", description = "Hora en formato HH:mm")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;

=======
    private LocalDate fecha_reserva;
    private LocalTime hora;
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
    private int numero_personas;
    private String estado;
    private int id_usuario;
    private int id_restaurante;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
<<<<<<< HEAD
}
=======
}
=======
package com.example.vegetariano.dtos;

import com.example.vegetariano.entities.Restaurante;
import com.example.vegetariano.entities.Usuario;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private int id_reserva;
    private LocalDate fecha_reserva;
    private LocalTime hora;
    private int numero_personas;
    private String estado;
    private int id_usuario;
    private int id_restaurante;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
}
>>>>>>> e1645271619c55ea2f508aa7ec1c23a1f4672a86
>>>>>>> f44f6e44411c9355e2be20fb1804fc3c674c6497
