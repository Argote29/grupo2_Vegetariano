package com.example.vegetariano.servicesimplements;


import com.example.vegetariano.dtos.QueryPlatoIngredientesDTO;
import com.example.vegetariano.entities.Ingrediente_Plato;
import com.example.vegetariano.repositories.IIngrediente_PlatoRepository;

import com.example.vegetariano.serviceinterfaces.IIngrediente_PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class Ingrediente_PlatoServiceImplement implements IIngrediente_PlatoService {

    @Autowired
    private IIngrediente_PlatoRepository ipR;

    @Override
    public List<Ingrediente_Plato> list() {
        return ipR.findAll();
    }

    @Override
    public void insert(Ingrediente_Plato ingredientePlato) {
        ipR.save(ingredientePlato);
    }

    @Override
    public void delete(int id) {
        ipR.deleteById(id);
    }

    @Override
    public Ingrediente_Plato listId(int id) {
        return ipR.findById(id).orElse(null);
    }

    @Override
    public void update(Ingrediente_Plato ingredientePlato) {
        ipR.save(ingredientePlato);
    }

    @Override
    public List<Ingrediente_Plato> listByPlato(int idPlato) {
        return ipR.findByIdPlato(idPlato);
    }

    @Override
    public List<QueryPlatoIngredientesDTO> obtenerPlatosConIngredientes() {
        List<Object[]> results = ipR.obtenerPlatosConIngredientes();

        Map<Integer, QueryPlatoIngredientesDTO> mapa = new LinkedHashMap<>();

        for (Object[] fila : results) {
            int idPlato = ((Number) fila[0]).intValue();
            String nombrePlato = (String) fila[1];
            double precioPlato = ((Number) fila[2]).doubleValue();
            String infoNutricional = (String) fila[3];
            String nombreIngrediente = (String) fila[4];
            int cantidad = ((Number) fila[5]).intValue();
            String tipoUnidad = (String) fila[6];

            mapa.computeIfAbsent(idPlato, id -> new QueryPlatoIngredientesDTO(
                    id, nombrePlato, precioPlato, infoNutricional
            ));


            mapa.get(idPlato).getIngredientes().add(
                    new QueryPlatoIngredientesDTO.IngredienteDTO(nombreIngrediente, cantidad, tipoUnidad)
            );
        }

        return new ArrayList<>(mapa.values());
    }


}
