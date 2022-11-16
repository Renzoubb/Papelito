package com.api.Api.Rest.controllers;

import com.api.Api.Rest.dtos.ProductoDTO;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.services.ProductoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {

    @GetMapping("/categoria")
    public ResponseEntity<?> ProductosPorCategoria(@RequestParam int categoria) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ProductosPorCategoria(categoria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }
    @GetMapping("/categoria/paged")
    public ResponseEntity<?> ProductosPorCategoriaPage(@RequestParam int categoria, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ProductosPorCategoriaPage(categoria, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }
    @GetMapping("/nombre/paged")
    public ResponseEntity<?> ProductosPorNombre(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ProductosPorNombre(nombre, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/destacados")
    public ResponseEntity<?> destacados() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.destacados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }
    @GetMapping("/ofertas")
    public ResponseEntity<?> ofertas() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ofertas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }


    @PostMapping("/destacar-productos")
    public ResponseEntity<?> destacar(@RequestBody List<ProductoDTO> productoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.destacarProductos(productoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }
    @GetMapping("/ofertar-productos")
    public ResponseEntity<?> ofertar(List<ProductoDTO> productoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ofertarProductos(productoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }
}
