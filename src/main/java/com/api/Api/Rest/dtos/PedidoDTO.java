package com.api.Api.Rest.dtos;

import com.api.Api.Rest.entities.DetallePedido;
import com.api.Api.Rest.entities.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Date fecha;
    private Float total;
    private String direccionEnvio;
    private List<DetallePedidoDTO> detallePedido;
    private String nombreEstado;

    public PedidoDTO() {
        detallePedido = new ArrayList<>();
    }
}
