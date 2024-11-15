package com.tienda.comercio.Service;

import com.tienda.comercio.Repositorio.UsuarioRepository;
import com.tienda.comercio.model.Cliente;
import com.tienda.comercio.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuarios save (Usuarios c){
        return usuarioRepository.save(c);
    }
}
