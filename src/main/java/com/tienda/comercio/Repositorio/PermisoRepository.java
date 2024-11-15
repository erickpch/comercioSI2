package com.tienda.comercio.Repositorio;

import com.tienda.comercio.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Long> {
}
