package com.tienda.comercio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity //la clase es una entidad
@Data // alamacena y genera de manera automatica los getters y setters
@Table (name = "clientes") // dar nombre específico a la tabla

public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // las tuplas ingresadas sean autoincrementales
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;

}
