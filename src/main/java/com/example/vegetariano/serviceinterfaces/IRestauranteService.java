package com.example.vegetariano.serviceinterfaces;

import com.example.vegetariano.dtos.QueryRestauranteSinPromoDTO;
import com.example.vegetariano.dtos.QueryRestaurantesMasVariedadPlatosDTO;
import com.example.vegetariano.entities.Restaurante;

import java.util.List;

public interface    IRestauranteService {
    public List<Restaurante> list();
    public void insert(Restaurante restaurante);
    public void delete(int id);
    public Restaurante listId(int id);
    void update(Restaurante restaurante);

    List<Object[]> QueryRestaurantePromedioResena();    
    List<QueryRestauranteSinPromoDTO> queryRestaurantesinpromos();
    List<QueryRestaurantesMasVariedadPlatosDTO> Queryvariedad();
    List<String[]> QueryPromedioPorTipoCocina();
}


