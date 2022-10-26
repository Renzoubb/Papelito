package com.api.Api.Rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoPedidoDTO {
    private Long id;
    private String nombreEstado;
    private int orden;
}
