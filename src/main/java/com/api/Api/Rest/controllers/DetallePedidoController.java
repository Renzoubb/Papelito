package com.api.Api.Rest.controllers;

import com.api.Api.Rest.dtos.CreacionPedidoDTO;
import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.entities.Domicilio;
import com.api.Api.Rest.services.DetallePedidoServiceImpl;
import com.api.Api.Rest.services.DomicilioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalles-pedido")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{

}
