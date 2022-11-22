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
    @GetMapping("/byProvincia/{idProvincia}")
    public ResponseEntity<?> getCiudadesByProvincia(@PathVariable Long idProvincia) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getCiudadesByProvincia(idProvincia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }
}
