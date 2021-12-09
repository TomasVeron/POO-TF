package ar.edu.unnoba.proyecto_river_plate_junin.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "socios")
@Data
public class Socio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long id;

    @Column(name = "dni", unique = true)
    @NotBlank(message = "El campo DNI no puede estar vacio")
    @Size(min = 8, max = 8)
    private String numeroDocumento;
    
    @Column
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;
    
    @Column
    @NotBlank(message = "El campo apellido no puede estar vacio")
    private String apellido;
    
    @Column(name="fecha_alta")
    private Date fechaAlta;
    
    @Column(name="fecha_nacimiento")
//    @NotBlank(message = "El campo fecha de nacimiento no puede estar vacio")
//    @Past(message = "fecha invalida")
    private Date fechaNacimiento;
    
    @Column
    @NotBlank(message = "El campo direccion no puede estar vacio")
    private String direccion;
    
    @Column
    @NotBlank(message = "El campo telefono no puede estar vacio")
    private String telefono;
    
    @Column
    @NotBlank(message = "El campo email no puede estar vacio")
    @Email(message = "Email invalido")
    private String email;
    
    @Column
    @NotNull(message = "El campo no puede ser null")
    private boolean activo=true;



}
