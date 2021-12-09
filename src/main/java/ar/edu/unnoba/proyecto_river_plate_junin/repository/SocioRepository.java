package ar.edu.unnoba.proyecto_river_plate_junin.repository;

import ar.edu.unnoba.proyecto_river_plate_junin.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {


    public Socio findByNombre(String nombre);

    @Query(value =
            "SELECT * FROM socios s order by s.activo ASC, s.apellido ASC, s.nombre ASC", nativeQuery = true)
    List<Socio> filterSocios();

    public String findByNumeroDocumento(String dni);

}
