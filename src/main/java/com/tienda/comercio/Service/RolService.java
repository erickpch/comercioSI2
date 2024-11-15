package com.tienda.comercio.Service;

import com.tienda.comercio.Repositorio.RolRepository;
import com.tienda.comercio.Repositorio.UsuarioRepository;
import com.tienda.comercio.model.Rol;
import com.tienda.comercio.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;



    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol save (Rol c){
        return rolRepository.save(c);
    }

    public Optional<Rol> findById(Long idRol) {
        return rolRepository.findById(idRol);
    }
}
