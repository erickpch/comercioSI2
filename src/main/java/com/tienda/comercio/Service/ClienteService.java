package com.tienda.comercio.Service;

import com.tienda.comercio.Repositorio.ClienteRepository;
import com.tienda.comercio.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save (Cliente c){
        return clienteRepository.save(c);
    }


}
