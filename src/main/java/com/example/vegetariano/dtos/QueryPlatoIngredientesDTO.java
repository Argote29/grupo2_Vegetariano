package com.example.vegetariano.dtos;

import java.util.ArrayList;
import java.util.List;

public class QueryPlatoIngredientesDTO {
    private int idPlato;
    private String nombrePlato;
    private double precioPlato;
    private String infoNutricional;
    private List<IngredienteDTO> ingredientes = new ArrayList<>();

    // Constructor
    public QueryPlatoIngredientesDTO(int idPlato, String nombrePlato, double precioPlato, String infoNutricional) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.infoNutricional = infoNutricional;
    }

    // Getters y setters
    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getInfoNutricional() {
        return infoNutricional;
    }

    public void setInfoNutricional(String infoNutricional) {
        this.infoNutricional = infoNutricional;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    // Clase interna para ingredientes
    public static class IngredienteDTO {
        private String nombreIngrediente;
        private int cantidad;
        private String tipoUnidad;

        public IngredienteDTO(String nombreIngrediente, int cantidad, String tipoUnidad) {
            this.nombreIngrediente = nombreIngrediente;
            this.cantidad = cantidad;
            this.tipoUnidad = tipoUnidad;
        }

        public String getNombreIngrediente() {
            return nombreIngrediente;
        }

        public void setNombreIngrediente(String nombreIngrediente) {
            this.nombreIngrediente = nombreIngrediente;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getTipoUnidad() {
            return tipoUnidad;
        }

        public void setTipoUnidad(String tipoUnidad) {
            this.tipoUnidad = tipoUnidad;
        }
    }
}
