package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.services.CiudadService;
import com.api.Api.Rest.services.CiudadServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ciudades")
public class CiudadController extends BaseControllerImpl<Ciudad, CiudadServiceImpl> {



   // private CiudadService ciudadService;
    /*
    public CiudadController(CiudadService ciudadService){this.ciudadService = ciudadService; }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ciudadService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ciudadService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Ciudad entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ciudadService.save(entity));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Ciudad entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ciudadService.update(id, entity));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ciudadService.delete(id));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }
    */
}
