package com.api.Api.Rest.controllers;


import com.api.Api.Rest.dtos.PedidoDTO;
import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.entities.Pedido;
import com.api.Api.Rest.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    @PostMapping("/create-pedido")
    public ResponseEntity<?> createPedido(@RequestBody PedidoDTO pedidoDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.createPedido(pedidoDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }
}
