package com.api.Api.Rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombreProducto;
    private String descripcionProducto;
    private float precioProducto;
    private String nombreCategoria;
}
