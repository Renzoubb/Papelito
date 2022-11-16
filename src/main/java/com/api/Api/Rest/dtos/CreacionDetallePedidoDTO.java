package com.api.Api.Rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreacionDetallePedidoDTO {
        private Integer cantidad;
        private Long productoId;
}
