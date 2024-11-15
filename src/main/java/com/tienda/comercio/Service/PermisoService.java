package com.tienda.comercio.Service;

import com.tienda.comercio.Repositorio.PermisoRepository;
import com.tienda.comercio.model.Permiso;
import com.tienda.comercio.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {
    @Autowired
    PermisoRepository permisoRepository;


    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    public Permiso save(Permiso p) {
        return permisoRepository.save(p);
    }

    public Optional<Permiso> findById(Long idPermiso) {
        return permisoRepository.findById(idPermiso);
    }
}
