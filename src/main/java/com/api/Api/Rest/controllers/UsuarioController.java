package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.services.UsuarioService;
import com.api.Api.Rest.services.UsuarioServiceImpl;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

}