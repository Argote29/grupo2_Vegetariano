package com.example.vegetariano.dtos;
import java.math.BigDecimal;
public class QueryPorcentajeUsuarioFiltradoDTO {
    private Long cantidadUsuarios;
    private BigDecimal porcentaje;

    public QueryPorcentajeUsuarioFiltradoDTO(Long cantidadUsuarios, BigDecimal porcentaje) {
        this.cantidadUsuarios = cantidadUsuarios;
        this.porcentaje = porcentaje;
    }

    public QueryPorcentajeUsuarioFiltradoDTO() {
    }

    public Long getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public void setCantidadUsuarios(Long cantidadUsuarios) {
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
