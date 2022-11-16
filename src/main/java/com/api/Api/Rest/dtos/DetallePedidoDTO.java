package com.api.Api.Rest.dtos;

import com.api.Api.Rest.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDTO {
    private Long id;
    private Float subtotal;
    private Integer cantidad;
    private Long idProducto;
    private String nombreProducto;
    private Float precioProducto;
    private String imageProducto;
    private String nombreCategoria;
    private Long idPedido;
}
