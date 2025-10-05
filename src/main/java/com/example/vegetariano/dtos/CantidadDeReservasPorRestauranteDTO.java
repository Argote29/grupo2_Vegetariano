package com.example.vegetariano.dtos;

public class CantidadDeReservasPorRestauranteDTO {
    private String nombre_restaurante;
    private long cantidad_reserva;

    public CantidadDeReservasPorRestauranteDTO(String nombre_restaurante, long cantidad_reserva) {
        this.nombre_restaurante = nombre_restaurante;
        this.cantidad_reserva = cantidad_reserva;
    }

    public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    public long getCantidad_reserva() {
        return cantidad_reserva;
    }

    public void setCantidad_reserva(long cantidad_reserva) {
        this.cantidad_reserva = cantidad_reserva;
    }
}
