package com.api.Api.Rest.controllers;
import com.api.Api.Rest.entities.EstadoPedido;
import com.api.Api.Rest.services.EstadoPedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/estado-pedido")
public class EstadoPedidoController extends BaseControllerImpl<EstadoPedido, EstadoPedidoServiceImpl> {
}
