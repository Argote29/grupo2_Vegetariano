package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.entities.Rol;

import java.util.List;
public interface IRolService
{
    public List<Rol> list();
    public void insert(Rol rol);
    public void delete(int id);
    public Rol listId(int id);
    void update(Rol rol);
}
