package com.tienda.comercio.Rest;

import com.tienda.comercio.DTO.RolPermisoDTO;
import com.tienda.comercio.Service.PermisoService;
import com.tienda.comercio.Service.RolPermisoService;
import com.tienda.comercio.Service.RolService;
import com.tienda.comercio.model.Permiso;
import com.tienda.comercio.model.Rol;
import com.tienda.comercio.model.RolPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rol_permiso")
public class RolPermisoRest {
    @Autowired
    RolPermisoService rolPermisoService;
    @Autowired
    PermisoService permisoService;
    @Autowired
    RolService rolService;

    @GetMapping("/listar")
    public ResponseEntity<List<RolPermiso>> read() {
        return ResponseEntity.ok(rolPermisoService.findAll());
    }


    @PostMapping(path = "/guardar")
    public ResponseEntity<RolPermiso> crear(@RequestBody RolPermisoDTO r){

        try {
            Permiso permiso = permisoService.findById(r.getId_permiso()).orElseThrow(() -> new Exception("no encontrado"));
            Rol id_rol = rolService.findById(r.getId_rol()).orElseThrow(() -> new Exception("no encontrado"));

            RolPermiso rolPermiso = new RolPermiso();
            rolPermiso.setId_permiso(permiso);
            rolPermiso.setId_rol(id_rol);

            RolPermiso nuevo = rolPermisoService.save(rolPermiso);
            return ResponseEntity.created(new URI("/rol_permiso/guardar/"+nuevo.getId())).body(nuevo);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
