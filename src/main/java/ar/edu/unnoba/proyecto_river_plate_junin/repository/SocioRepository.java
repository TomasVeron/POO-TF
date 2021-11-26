package ar.edu.unnoba.proyecto_river_plate_junin.repository;

import ar.edu.unnoba.proyecto_river_plate_junin.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {


}
