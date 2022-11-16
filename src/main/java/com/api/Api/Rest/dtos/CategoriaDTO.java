package com.api.Api.Rest.dtos;

import com.api.Api.Rest.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nombreCategoria;
    private List<ProductoDTO> productoList;
}
