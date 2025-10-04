package com.example.vegetariano.dtos;

public class QueryCantidadIngredientesDTO {
    private String nombrePlato;
    private Long totalIngredientes;

    public QueryCantidadIngredientesDTO(String nombrePlato, Long totalIngredientes) {
        this.nombrePlato = nombrePlato;
        this.totalIngredientes = totalIngredientes;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public Long getTotalIngredientes() {
        return totalIngredientes;
    }

    public void setTotalIngredientes(Long totalIngredientes) {
        this.totalIngredientes = totalIngredientes;
    }
}
