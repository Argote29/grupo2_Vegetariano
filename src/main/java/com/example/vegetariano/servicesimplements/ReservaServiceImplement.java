package com.example.vegetariano.servicesimplements;

import com.example.vegetariano.dtos.QueryCantidadDeReservasPorRestauranteDTO;
import com.example.vegetariano.entities.Reserva;
import com.example.vegetariano.repositories.IReservaRepository;
import com.example.vegetariano.serviceinterfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservaServiceImplement implements IReservaService {
    @Autowired
    private IReservaRepository rRe;
    @Override
    public List<Reserva> list() {
        return rRe.findAll();
    }

    @Override
    public void insert(Reserva reserva)
    {
        rRe.save(reserva);

    }

    @Override
    public void delete(int id) {
        rRe.deleteById(id);

    }

    @Override
    public Reserva listId(int id) {
        return rRe.findById(id).orElse(null);
    }

    @Override
    public void update(Reserva reserva) {
        rRe.save(reserva);

    }
    @Override
    public List<QueryCantidadDeReservasPorRestauranteDTO> obtenerNombreYCantidadPorRestaurante(int idRestaurante) {
        List<Object[]> resultados = rRe.obtenerNombreYCantidadPorRestaurante(idRestaurante);

        return resultados.stream()
                .map(obj -> new QueryCantidadDeReservasPorRestauranteDTO(
                        (String) obj[0],
                        ((Number) obj[1]).longValue()
                ))
                .toList();
    }
}
