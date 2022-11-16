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

}
