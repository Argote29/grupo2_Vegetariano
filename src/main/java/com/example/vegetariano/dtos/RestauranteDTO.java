
package com.example.vegetariano.dtos;

public class RestauranteDTO {
    private int id_restaurante;
    private int id_usuario;
    private String nombre_restaurante;
    private String direccion;
    private String tipo_cocina;
    private String horario;
    private int contacto;

    public RestauranteDTO() {}


    public int getId_restaurante() { return id_restaurante; }
    public void setId_restaurante(int id_restaurante) { this.id_restaurante = id_restaurante; }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

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