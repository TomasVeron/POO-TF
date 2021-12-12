package ar.edu.unnoba.proyecto_river_plate_junin.service;


import ar.edu.unnoba.proyecto_river_plate_junin.model.Socio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocioService {

    public List<Socio> getAllSocios();

    public Socio createSocio(Socio socio) throws Exception;

    public Socio updateSocio(Socio socio);

    public Socio getSocio (Socio socio);

}
