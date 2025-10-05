package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.dtos.QuerySuscripcionActivaDTO;
import com.example.vegetariano.entities.HistorialSuscripcion;
import com.example.vegetariano.repositories.IHistorialSuscripcionRepository;
import com.example.vegetariano.serviceinterfaces.IHistorialSuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IHistorialSuscripcionServiceImplement implements IHistorialSuscripcionService {


    @Autowired
    private IHistorialSuscripcionRepository hSU;

    @Override
    public List<HistorialSuscripcion> list() { return hSU.findAll(); }

    @Override
    public void insert(HistorialSuscripcion historialSuscripcion) { hSU.save(historialSuscripcion); }

    @Override
    public void delete(int id) {  hSU.deleteById(id); }

    @Override
    public HistorialSuscripcion listId(int id) { return hSU.findById(id).orElse(null); }

    @Override
    public void update(HistorialSuscripcion historialSuscripcion) { hSU.save(historialSuscripcion); }

    @Override
    public List<QuerySuscripcionActivaDTO> findSuscripcionesActivas() {
        List<Object[]> resultados = hSU.findSuscripcionesActivas();

        return resultados.stream()
                .map(obj -> new QuerySuscripcionActivaDTO(
                        (String) obj[0],       // nombre del usuario
                        ((Date) obj[1]).toLocalDate()     // fecha final (tipo DATE)
                ))
                .collect(Collectors.toList());
    }

}
