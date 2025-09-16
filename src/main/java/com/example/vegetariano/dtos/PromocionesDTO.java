package com.example.vegetariano.dtos;

import java.time.LocalDate;

public class PromocionesDTO {
    private int  id_Promociones;
    private String  descripcion;
    private LocalDate fecha_inico_promo;
    private LocalDate fecha_final_promo;
    private String  descuento;

    public int getId_Promociones() {
        return id_Promociones;
    }

    public void setId_Promociones(int id_Promociones) {
        this.id_Promociones = id_Promociones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inico_promo() {
        return fecha_inico_promo;
    }

    public void setFecha_inico_promo(LocalDate fecha_inico_promo) {
        this.fecha_inico_promo = fecha_inico_promo;
    }

    public LocalDate getFecha_final_promo() {
        return fecha_final_promo;
    }

    public void setFecha_final_promo(LocalDate fecha_final_promo) {
        this.fecha_final_promo = fecha_final_promo;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
