package com.api.Api.Rest.controllers;


import com.api.Api.Rest.dtos.CreacionPedidoDTO;
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
    public ResponseEntity<?> createPedido(@RequestBody CreacionPedidoDTO creacionPedidoDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.createPedido(creacionPedidoDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<?> getPedidoDetail(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getPedidoDetail(id));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }

    @GetMapping("detalle")
    public ResponseEntity<?> getAllPedidosDetail(Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getAllPedidosDetail(pageable));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor, intente mas tarde.\"}");
        }
    }
}
