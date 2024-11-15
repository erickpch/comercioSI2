package com.tienda.comercio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol_permisos")
public class RolPermiso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol id_rol;


    @ManyToOne
    @JoinColumn(name = "id_permiso")
    private Permiso id_permiso;
}
