package ar.edu.unnoba.proyecto_river_plate_junin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cuotas")
public class Cuota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuota")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "fecha_caducidad")
    private Date fechaCaducidad;

    @Column
    private float importe;

    @JoinColumn(name="id_socio", referencedColumnName = "id_socio")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Socio socio;

}
