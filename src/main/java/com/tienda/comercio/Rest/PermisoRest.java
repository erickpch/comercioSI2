package com.tienda.comercio.Rest;

import com.tienda.comercio.Service.PermisoService;
import com.tienda.comercio.model.Permiso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permiso")
public class PermisoRest {

    @Autowired
    PermisoService permisoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Permiso>> read() {
        return ResponseEntity.ok(permisoService.findAll());
    }


    @PostMapping(path = "/guardar")
    public ResponseEntity<Permiso> crear(@RequestBody Permiso p){
        try {

            Permiso nuevo = permisoService.save(p);
            System.out.println(nuevo);

            return ResponseEntity.ok(nuevo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
