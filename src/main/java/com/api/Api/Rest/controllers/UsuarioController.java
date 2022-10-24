package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.entities.Usuario;
import com.api.Api.Rest.services.ProductoServiceImpl;
import com.api.Api.Rest.services.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {


}