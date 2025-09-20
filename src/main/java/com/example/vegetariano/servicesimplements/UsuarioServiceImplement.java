package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import com.example.vegetariano.serviceinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;
    public List<Usuario> list(){return uR.findAll();}
    public void insert(Usuario usuario){uR.save(usuario);}
    public List<String[]> QueryReservaUsuario() {
        return uR.QueryReservaUsuario();
    }


}
