package com.example.vegetariano.serviceinterfaces;
import com.example.vegetariano.dtos.QueryCantidadDeReservasPorRestauranteDTO;
import com.example.vegetariano.dtos.QueryUsuarioMasResenaDTO;
import com.example.vegetariano.entities.Usuario;

import java.util.List;
public interface IUsuarioService {
    public List<Usuario> list ();
    public void insert (Usuario usuario);
    List<String[]> QueryReservaUsuario();
    List<QueryUsuarioMasResenaDTO> obtenerUsuariosMasResenas();

}
