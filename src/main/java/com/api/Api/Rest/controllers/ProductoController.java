package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.services.ProductoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {


}
