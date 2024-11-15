package com.tienda.comercio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity //la clase es una entidad
@Data // alamacena y genera de manera automatica los getters y setters
@Table (name = "rols") // dar nombre específico a la tabla

public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // las tuplas ingresadas sean autoincrementales
    private Long id;
    private String name;

    @OneToMany(mappedBy = "id_rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<RolPermiso> id_rol_permiso;


}
