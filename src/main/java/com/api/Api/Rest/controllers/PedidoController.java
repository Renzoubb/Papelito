package com.api.Api.Rest.controllers;


import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{


}
