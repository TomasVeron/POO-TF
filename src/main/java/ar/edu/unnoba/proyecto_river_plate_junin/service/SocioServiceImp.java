package ar.edu.unnoba.proyecto_river_plate_junin.service;

import ar.edu.unnoba.proyecto_river_plate_junin.model.Socio;
import ar.edu.unnoba.proyecto_river_plate_junin.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioServiceImp implements SocioService{

    @Autowired
    private SocioRepository socioRepository;

    @Override
    public List<Socio> getSocios() {
        return socioRepository.findAll();
    }
}
