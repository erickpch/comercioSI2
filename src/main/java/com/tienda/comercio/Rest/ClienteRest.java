package com.tienda.comercio.Rest;

import com.tienda.comercio.Service.ClienteService;
import com.tienda.comercio.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping ("/cliente")

public class ClienteRest {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/listar")
    public ResponseEntity<List<Cliente>> read() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PostMapping(path = "/guardar")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente c){

        try {
            Cliente nuevo = clienteService.save(c);
            return ResponseEntity.created(new URI("/aulas/crear/"+nuevo.getId())).body(nuevo);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
