package com.example.vegetariano.dtos;

public class IngredientesDTO {
    private int  id_ingredientes;
    private String nombre_ingrediente;
    private Boolean tipo_natural;
    private String nivel_insecticida;
    private String formas_preparar;
    private String origen;
    private Boolean contiene_gluten;

    public int getId_ingredientes() {
        return id_ingredientes;
    }

    public void setId_ingredientes(int id_ingredientes) {
        this.id_ingredientes = id_ingredientes;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public Boolean getTipo_natural() {
        return tipo_natural;
    }

    public void setTipo_natural(Boolean tipo_natural) {
        this.tipo_natural = tipo_natural;
    }

    public String getNivel_insecticida() {
        return nivel_insecticida;
    }

    public void setNivel_insecticida(String nivel_insecticida) {
        this.nivel_insecticida = nivel_insecticida;
    }

    public String getFormas_preparar() {
        return formas_preparar;
    }

    public void setFormas_preparar(String formas_preparar) {
        this.formas_preparar = formas_preparar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Boolean getContiene_gluten() {
        return contiene_gluten;
    }

    public void setContiene_gluten(Boolean contiene_gluten) {
        this.contiene_gluten = contiene_gluten;
    }
}
