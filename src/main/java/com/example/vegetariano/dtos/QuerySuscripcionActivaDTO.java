package com.example.vegetariano.dtos;

public class QuerySuscripcionActivaDTO {

    private long activos;
    private long inactivos;

    public QuerySuscripcionActivaDTO(long activos, long inactivos) {
        this.activos = activos;
        this.inactivos = inactivos;
    }

    public long getActivos() {
        return activos;
    }

    public void setActivos(long activos) {
        this.activos = activos;
    }

    public long getInactivos() {
        return inactivos;
    }

    public void setInactivos(long inactivos) {
        this.inactivos = inactivos;
    }
}
