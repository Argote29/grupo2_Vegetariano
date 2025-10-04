package com.example.vegetariano.serviceinterfaces;
import com.example.vegetariano.entities.Usuario;

import java.util.List;
public interface IUsuarioService {
    public List<Usuario> list ();
    public void insert (Usuario usuario);
    public void delete (int id);
    public Usuario listid (int id);
    void update(Usuario usuario);
}
