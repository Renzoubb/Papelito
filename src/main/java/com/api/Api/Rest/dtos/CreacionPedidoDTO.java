package com.api.Api.Rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreacionPedidoDTO {
    private String direccionEnvio;
    private List<CreacionDetallePedidoDTO> detallePedido;
    private Long idUsuario;
}
