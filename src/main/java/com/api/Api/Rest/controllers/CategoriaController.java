package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Categoria;
import com.api.Api.Rest.services.CategoriaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl> {

}