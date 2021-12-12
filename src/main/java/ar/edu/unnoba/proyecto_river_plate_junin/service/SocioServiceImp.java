package ar.edu.unnoba.proyecto_river_plate_junin.service;

import ar.edu.unnoba.proyecto_river_plate_junin.model.Socio;
import ar.edu.unnoba.proyecto_river_plate_junin.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SocioServiceImp implements SocioService{

    @Autowired
    private SocioRepository repository;


    @Override
    public List<Socio> getAllSocios() {
        return repository.filterSocios();

    }


    @Override
    public Socio createSocio(Socio socio) throws Exception {
        if(socio.getNumeroDocumento()==repository.findByNumeroDocumento(socio.getNumeroDocumento())){
            throw new Exception("el codigo o dni de socio no esta disponible");
        }
        socio.setFechaAlta(new Date());
        socio.setActivo(true);
        return repository.save(socio);
    }


    @Override
    public Socio updateSocio(Socio socio) {

        Socio uDB = repository.findById(socio.getId()).orElse(null);
        uDB.setEmail(socio.getEmail());
        uDB.setDireccion(socio.getDireccion());
        uDB.setTelefono(socio.getTelefono());
        uDB.setActivo(socio.isActivo());
        return repository.save(uDB);
    }

    @Override
    public Socio getSocio (Socio socio) {
        return repository.findById(socio.getId()).orElse(null);

    }
}
