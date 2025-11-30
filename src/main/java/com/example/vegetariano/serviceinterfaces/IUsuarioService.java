package com.example.vegetariano.serviceinterfaces;
import com.example.vegetariano.dtos.QueryCantidadDeReservasPorRestauranteDTO;
import com.example.vegetariano.dtos.QueryPorcentajeUsuarioFiltradoDTO;
import com.example.vegetariano.dtos.QueryUsuarioMasResenaDTO;
import com.example.vegetariano.entities.Usuario;

import java.util.List;
public interface IUsuarioService {
    public List<Usuario> list ();
    public void insert (Usuario usuario);
    List<String[]> QueryReservaUsuario();
    public Usuario listId(int id);
    void update (Usuario usuario);
    public void delete(int id);
    List<QueryUsuarioMasResenaDTO> obtenerUsuariosMasResenas();
    public QueryPorcentajeUsuarioFiltradoDTO getPorcentajeUsuariosPorGenero(String genero);
}
