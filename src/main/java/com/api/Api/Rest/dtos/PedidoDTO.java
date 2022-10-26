package com.api.Api.Rest.dtos;

import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.entities.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Date fecha;
    private Float total;
    private String direccionEnvio;
    private List<DetallePedidoDTO> detallePedidoList;
    private String estadoPedido;
    private Long idUsuario;

}
