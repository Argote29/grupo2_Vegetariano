package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.dtos.QueryPorcentajeUsuarioFiltradoDTO;
import com.example.vegetariano.dtos.QueryUsuarioMasResenaDTO;
import com.example.vegetariano.entities.Usuario;
import com.example.vegetariano.repositories.IUsuarioRepository;
import com.example.vegetariano.serviceinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;
    @Override
    public List<Usuario> list(){return uR.findAll();}
    @Override
    public void insert(Usuario usuario){uR.save(usuario);}
    @Override
    public List<String[]> QueryReservaUsuario() {
        return uR.QueryReservaUsuario();
    }

    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<QueryUsuarioMasResenaDTO> obtenerUsuariosMasResenas() {
        List<Object[]> lista = uR.usuariosMasResenas();
        List<QueryUsuarioMasResenaDTO> resultado = new ArrayList<>();

        for (Object[] fila : lista) {
            String nombre = (String) fila[0];
            Long total = ((Number) fila[1]).longValue();
            resultado.add(new QueryUsuarioMasResenaDTO(nombre,total));
        }

        return resultado;
    }

    @Override
    public QueryPorcentajeUsuarioFiltradoDTO getPorcentajeUsuariosPorGenero(String genero) {

        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede ser nulo o vacío.");
        }

        String generoFiltrado = genero.trim().toUpperCase();


        QueryPorcentajeUsuarioFiltradoDTO resultado =
                uR.findPromedioUsuariosPorGenero(generoFiltrado);

        return resultado;
    }
}
