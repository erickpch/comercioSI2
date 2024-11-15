package com.tienda.comercio.Rest;

import com.tienda.comercio.Service.RolService;

import com.tienda.comercio.model.Rol;
import com.tienda.comercio.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@PreAuthorize("hasRole('rol')")
    @RestController
    @RequestMapping("/rol")
    public class RolRest {
        @Autowired
        private RolService rolService;

        @GetMapping("/listar")
        public ResponseEntity<List<Rol>> read() {
            return ResponseEntity.ok(rolService.findAll());
        }


        @PostMapping(path = "/guardar")
        public ResponseEntity<Rol> crear(@RequestBody Rol c){

            try {
                Rol nuevo = rolService.save(c);
                return ResponseEntity.created(new URI("/usuario/guardar/"+nuevo.getId())).body(nuevo);

            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }

