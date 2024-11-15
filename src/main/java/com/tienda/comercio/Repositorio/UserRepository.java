package com.tienda.comercio.Repositorio;
import com.tienda.comercio.model.Usuarios;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<Usuarios, Long>{

    Optional<Usuarios> findByUsername(String username);
}
