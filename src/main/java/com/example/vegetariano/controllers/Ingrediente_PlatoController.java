package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.QueryPlatoIngredientesDTO;
import com.example.vegetariano.entities.Ingrediente_Plato;
import com.example.vegetariano.serviceinterfaces.IIngrediente_PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediente-plato")
public class Ingrediente_PlatoController {

    @Autowired
    private IIngrediente_PlatoService ipS;

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping
    public List<Ingrediente_Plato> list() {
        return ipS.list();
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping("/plato/{id_plato}")
    public List<Ingrediente_Plato> listByPlato(@PathVariable("id_plato") int id_plato) {
        return ipS.listByPlato(id_plato);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping("/{id}")
    public Ingrediente_Plato listId(@PathVariable("id") int id) {
        return ipS.listId(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @PostMapping
    public void insert(@RequestBody Ingrediente_Plato ingredientePlato) {
        ipS.insert(ingredientePlato);
    }
    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @PutMapping
    public void update(@RequestBody Ingrediente_Plato ingredientePlato) {
        ipS.update(ingredientePlato);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        ipS.delete(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','RESTAURANT')")
    @GetMapping("/detalle")
    public List<QueryPlatoIngredientesDTO> obtenerPlatosConIngredientes() {
        return ipS.obtenerPlatosConIngredientes();
    }
}
